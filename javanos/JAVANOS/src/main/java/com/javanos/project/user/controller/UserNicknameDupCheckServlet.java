package com.javanos.project.user.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.javanos.project.user.model.service.UserService;

@WebServlet("/user/check-nickname")
public class UserNicknameDupCheckServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userNickname = request.getParameter("userNickname");

		int result = new UserService().checkDupUserNickname(userNickname);
		
		if (result > 0) {
			response.getWriter().write("fail");
		} else {
			response.getWriter().write("pass");
		}
	}

}
