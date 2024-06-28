package com.javanos.project.user.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.javanos.project.user.model.dto.UserDTO;
@WebServlet("/user/check-pwd")
public class UserPwdCheckServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		
		HttpSession session = request.getSession();
		UserDTO loginUser = (UserDTO) session.getAttribute("loginUser");
		System.out.println(userId);
		System.out.println(userPwd);
		System.out.println(loginUser);
	}

}
