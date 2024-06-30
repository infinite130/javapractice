package com.javanos.project.report.admin.controller.confim;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.javanos.project.report.model.dto.ReportDTO;
import com.javanos.project.report.model.service.ReportService;

@WebServlet("/reportdetail")
public class ReportDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ReportService reportService = new ReportService();

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
        doGet(request, response);
    }
}