package com.javanos.project.report.admin.controller.confim;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CheckBoard")
public class CheckBoardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // 관리자인 경우 계정 관리 게시판 페이지로 포워딩
        request.getRequestDispatcher("/WEB-INF/views/report/reportmanagementmain.jsp").forward(request, response);
    }
}
