package com.javanos.project.report.member.controller.regist;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

import com.javanos.project.report.model.dto.ReportDTO;
import com.javanos.project.report.model.service.ReportService;
import com.javanos.project.user.model.dto.UserDTO;
import com.javanos.project.community.model.dto.CommunityDTO;
import com.javanos.project.community.model.service.CommunityService;

import java.text.SimpleDateFormat;

@WebServlet("/RegistReport")
public class RegistReportServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ReportService reportService = new ReportService();
    private CommunityService communityService = new CommunityService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        UserDTO loginUser = (UserDTO) session.getAttribute("loginUser");
        if (loginUser == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String check1 = request.getParameter("actualCheck1");
        int communityNo = Integer.parseInt(request.getParameter("communityNo"));

        // 커뮤니티 정보를 가져옴
        CommunityDTO community = communityService.selectOneThumbnailList(communityNo);
        if (community == null) {
            request.setAttribute("message", "커뮤니티 게시글을 찾을 수 없습니다.");
            request.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(request, response);
            return;
        }

        String reportedUserId = community.getUser().getUserId(); // 수정된 부분

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDate = formatter.format(new Date());

        // 로그 추가
        System.out.println("신고한 회원: " + loginUser.getUserId());
        System.out.println("신고당한 회원: " + reportedUserId);
        System.out.println("신고 내용: " + check1);
        System.out.println("등록일: " + currentDate);

        // 신고 데이터를 ReportDTO 객체로 변환
        ReportDTO report = new ReportDTO();
        report.setReportReason(check1);
        report.setReportDate(new java.sql.Date(new Date().getTime())); // Date 객체 변환
        report.setReportUser(loginUser);
        report.setCommunityNo(communityNo);

        // 클라이언트로부터 신고할 회원의 번호를 받음
        String reportedUserNoStr = request.getParameter("reportedUserNo");
        if (reportedUserNoStr == null || reportedUserNoStr.isEmpty()) {
            request.setAttribute("message", "신고할 회원의 번호가 제공되지 않았습니다.");
            request.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(request, response);
            return;
        }

        // 사용자 번호를 정수로 변환
        int reportedUserNo;
        try {
            reportedUserNo = Integer.parseInt(reportedUserNoStr);
        } catch (NumberFormatException e) {
            request.setAttribute("message", "유효하지 않은 회원 번호 형식입니다.");
            request.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(request, response);
            return;
        }

        // 사용자 ID로 사용자 정보를 조회하여 UserDTO 객체 생성
        UserDTO reportedUser = reportService.selectUserByUserNo(reportedUserNo);

        if (reportedUser == null) {
            request.setAttribute("message", "신고할 사용자를 찾을 수 없습니다.");
            request.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(request, response);
            return;
        }
        report.setReportedUser(reportedUser);

        // 데이터베이스에 저장
        int result = reportService.insertReport(report);

        if (result > 0) {
            session.setAttribute("message", "신고가 성공적으로 접수되었습니다.");
            response.getWriter().write("<script>alert('신고가 성공적으로 접수되었습니다.');location.href='" + request.getContextPath() + "/community/list';</script>");
        } else {
            request.setAttribute("message", "신고 등록에 실패했습니다.");
            request.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
