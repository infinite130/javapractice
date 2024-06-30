package com.javanos.project.user.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.javanos.project.user.model.dto.UserDTO;
import com.javanos.project.user.model.service.UserService;
@WebServlet("/user/check-pwd")
public class UserPwdCheckServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		UserDTO loginUser = new UserDTO();
		loginUser.setUserId(userId);
		loginUser.setUserPwd(userPwd);
		
		String storedPwd = new UserService().checkPwd(loginUser);
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if (passwordEncoder.matches(userPwd, storedPwd)) {
			response.getWriter().write("pass");
		}  else {
			response.getWriter().write("pass");
		}
	}
}