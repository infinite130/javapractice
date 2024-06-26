package com.javanos.project.report.admin.controller.confim;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/reportdetail")
public class ReportDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // GET 요청으로 전달된 매개변수를 가져옴
        String userId = request.getParameter("userId");
        String reportedUserId = request.getParameter("reportedUserId");
        String check1 = request.getParameter("check1");
        String additionalText = request.getParameter("additionalText");
        String currentDate = request.getParameter("currentDate");

        // 받은 데이터를 request 속성에 설정
        request.setAttribute("userId", userId);
        request.setAttribute("reportedUserId", reportedUserId);
        request.setAttribute("check1", check1);
        request.setAttribute("additionalText", additionalText);
        request.setAttribute("currentDate", currentDate);

        // JSP 페이지로 포워딩
        request.getRequestDispatcher("/WEB-INF/views/report/reportdetail.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
