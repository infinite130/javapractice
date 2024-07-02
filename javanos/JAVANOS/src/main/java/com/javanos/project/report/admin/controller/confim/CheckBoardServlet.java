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
import com.javanos.project.common.paging.Pagenation;
import com.javanos.project.common.paging.SelectCriteria;

@WebServlet("/CheckBoard")
public class CheckBoardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = 1;
        int limit = 10;
        int buttonAmount = 5;

        if (request.getParameter("currentPage") != null) {
            pageNo = Integer.parseInt(request.getParameter("currentPage"));
        }

        ReportService reportService = new ReportService();
        int totalCount = reportService.selectTotalCount();

        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);

        List<ReportDTO> reportList = reportService.selectReports(selectCriteria);

        request.setAttribute("reports", reportList);
        request.setAttribute("selectCriteria", selectCriteria);

        String path = "/WEB-INF/views/report/reportmanagementmain.jsp";
        request.getRequestDispatcher(path).forward(request, response);
    }
}
