package com.javanos.project.report.admin.controller.confim;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.javanos.project.report.model.dto.ReportDTO;
import com.javanos.project.report.model.service.ReportService;

@WebServlet("/CheckBoard")
public class CheckBoardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReportService reportService = new ReportService();
        List<ReportDTO> reportList = reportService.selectAllReports();
        
        request.setAttribute("reports", reportList);
        
        String path = "/WEB-INF/views/report/reportmanagementmain.jsp";
        request.getRequestDispatcher(path).forward(request, response);
    }
}