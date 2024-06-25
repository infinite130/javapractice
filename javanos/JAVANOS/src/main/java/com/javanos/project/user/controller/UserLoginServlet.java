package com.javanos.project.user.controller;

import java.io.IOException;

import com.javanos.project.user.model.dto.UserDTO;
import com.javanos.project.user.model.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/WEB-INF/views/user/userLoginForm.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");

		UserDTO requestUser = new UserDTO();
		requestUser.setUserId(userId);
		requestUser.setUserPwd(userPwd);

		UserDTO loginUser = new UserService().loginCheck(requestUser);

		if (loginUser != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			response.sendRedirect(request.getContextPath()); // main으로 이동
		} else {
			request.setAttribute("message", "로그인에 실패하였습니다.");
			request.setAttribute("code", "loginUser");
			request.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(request, response);
		}

	}
}
