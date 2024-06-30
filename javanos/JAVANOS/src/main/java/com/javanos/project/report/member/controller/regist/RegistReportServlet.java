package com.javanos.project.report.member.controller.regist;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.javanos.project.report.model.dto.ReportDTO;
import com.javanos.project.report.model.service.ReportService;
import com.javanos.project.user.model.dto.UserDTO;

import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet("/RegistReport")
public class RegistReportServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        UserDTO loginUser = (UserDTO) session.getAttribute("loginUser");
        if (loginUser == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        String userId = loginUser.getUserId();

        String check1 = request.getParameter("actualCheck1");
        String additionalText = request.getParameter("additionalText");
        String communityNo = request.getParameter("communityNo");
        String reportedUserId = request.getParameter("reportedUserId");

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDate = formatter.format(new Date());

        // 로그 추가
        System.out.println("신고한 회원: " + userId);
        System.out.println("신고당한 회원: " + reportedUserId);
        System.out.println("신고 내용: " + check1);
        if (additionalText != null && !additionalText.isEmpty()) {
            System.out.println("기타 내용: " + additionalText);
        }
        System.out.println("등록일: " + currentDate);

        // 신고 데이터를 ReportDTO 객체로 변환
        ReportDTO report = new ReportDTO();
        report.setReportReason(check1);
        report.setReportDate(new java.sql.Date(new Date().getTime())); // Date 객체 변환
        report.setReportUser(loginUser);

        // 사용자 ID로 사용자 정보를 조회하여 UserDTO 객체 생성
        ReportService reportService = new ReportService();
        UserDTO reportedUser = reportService.selectUserByUserId(reportedUserId);
        
  
        
        report.setReportedUser(reportedUser);

        // 데이터베이스에 저장
        int result = reportService.insertReport(report);

        if (result > 0) {
            request.setAttribute("successCode", "reportSubmitted");
            request.getRequestDispatcher("/WEB-INF/views/common/success.jsp").forward(request, response);
        } 
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}