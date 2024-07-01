package com.javanos.project.report.admin.controller.confim;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.javanos.project.report.model.service.ReportService;

@WebServlet("/confirmReport")
public class ConfirmReportServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println("Action: " + action);  // 디버깅 출력

        if ("confirm".equals(action)) {
            try {
                int reportNo = Integer.parseInt(request.getParameter("reportId"));
                ReportService reportService = new ReportService();
                boolean isStatusUpdated = reportService.updateReportStatus(reportNo, "계정정지완료");

                // 상태 업데이트 결과 출력
                System.out.println("Report No: " + reportNo);
                System.out.println("Is Status Updated: " + isStatusUpdated);

                response.sendRedirect(request.getContextPath() + "/CheckBoard");
            } catch (NumberFormatException e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid report number.");
            } catch (Exception e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing the request.");
            }
        } else if ("reject".equals(action)) {
            try {
                int reportNo = Integer.parseInt(request.getParameter("reportId"));
                ReportService reportService = new ReportService();
                boolean isStatusUpdated = reportService.updateReportStatus(reportNo, "신고처리거절");

                // 상태 업데이트 결과 출력
                System.out.println("Report No: " + reportNo);
                System.out.println("Is Status Updated: " + isStatusUpdated);

                response.sendRedirect(request.getContextPath() + "/CheckBoard");
            } catch (NumberFormatException e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid report number.");
            } catch (Exception e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing the request.");
            }
        } else {
            doGet(request, response);
        }
    }
}