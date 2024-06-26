package com.javanos.project.user.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.javanos.project.user.model.service.UserService;

@WebServlet("/user/check-email")
public class UserEmailDupCheckServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userEmail = request.getParameter("userEmail");
		
		int result = new UserService().checkDupUserEmail(userEmail);
		
		if (result > 0) {
			response.getWriter().write("fail");
		} else {
			response.getWriter().write("pass");
		}
	}

}
