package com.javanos.project.report.admin.controller.confim;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.javanos.project.report.model.dto.ReportDTO;
import com.javanos.project.report.model.service.ReportService;
import com.javanos.project.user.model.service.UserService;

@WebServlet("/reportdetail")
public class ReportDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ReportService reportService = new ReportService();
    private UserService userService = new UserService(); // 사용자 서비스 추가

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // GET 요청으로 전달된 매개변수를 가져옴
            int reportNo = Integer.parseInt(request.getParameter("reportNo"));

            // 신고 내용을 조회하여 request 속성에 설정
            ReportDTO report = reportService.selectReportByNo(reportNo);
            request.setAttribute("report", report);

            // JSP 페이지로 포워딩
            request.getRequestDispatcher("/WEB-INF/views/report/reportdetail.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            // 잘못된 reportNo가 전달된 경우 오류 처리
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid report number.");
        } catch (Exception e) {
            // 기타 예외 처리
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing the request.");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("delete".equals(action)) {
            try {
                // 삭제 요청 처리
                int reportNo = Integer.parseInt(request.getParameter("reportId"));
                reportService.deleteReport(reportNo);
                // 삭제 성공 메시지 설정
                request.getSession().setAttribute("message", "신고글이 삭제되었습니다.");
                response.sendRedirect(request.getContextPath() + "/CheckBoard");
            } catch (NumberFormatException e) {
                // 잘못된 reportNo가 전달된 경우 오류 처리
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid report number.");
            } catch (Exception e) {
                // 기타 예외 처리
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing the request.");
            }
        } else if ("confirm".equals(action)) {
            try {
                // 계정 정지 요청 처리
                int reportNo = Integer.parseInt(request.getParameter("reportId"));
                ReportDTO report = reportService.selectReportByNo(reportNo);
                
                // 신고된 사용자의 ID를 가져옴
                String reportedUserId = report.getReportedUser().getUserId();

                // 사용자 계정을 정지 처리하는 서비스 호출
                userService.suspendUserAccount(reportedUserId);

                // 정지 성공 메시지 설정
                request.getSession().setAttribute("message", "사용자 계정이 정지되었습니다.");

                // 홈페이지로 리다이렉트
                response.sendRedirect(request.getContextPath() + "/home");
            } catch (NumberFormatException e) {
                // 잘못된 reportNo가 전달된 경우 오류 처리
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid report number.");
            } catch (Exception e) {
                // 기타 예외 처리
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing the request.");
            }
        } else {
            doGet(request, response);
        }
    }
}
