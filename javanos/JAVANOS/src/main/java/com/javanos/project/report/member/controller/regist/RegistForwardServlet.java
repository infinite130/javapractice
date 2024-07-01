package com.javanos.project.report.member.controller.regist;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.javanos.project.report.model.service.ReportService;
import java.io.IOException;

@WebServlet("/reportmain")
public class RegistForwardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reportedUserNo = request.getParameter("reportedUserNo");

        if (reportedUserNo != null) {
            ReportService reportService = new ReportService();
            String reportedUserNickname = reportService.getUserNicknameByUserNo(Integer.parseInt(reportedUserNo));
            request.setAttribute("reportedUserNickname", reportedUserNickname);
        }

        request.getRequestDispatcher("/WEB-INF/views/report/reportregistmain.jsp").forward(request, response);
    }
}