package com.javanos.project.user.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.javanos.project.user.model.dto.UserDTO;
import com.javanos.project.user.model.service.UserService;

@WebServlet("/user/join")
public class UserJoinServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/WEB-INF/views/user/userJoinForm.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String userNickname = request.getParameter("userNickname");
		String userEmail = request.getParameter("userEmail");

		UserDTO requestUser = new UserDTO();
		requestUser.setUserId(userId);
		requestUser.setUserPwd(userPwd);
		requestUser.setUserName(userName);
		requestUser.setUserNickname(userNickname);
		requestUser.setUserEmail(userEmail);

		int result = new UserService().joinUser(requestUser);

		String page = "";
		if (result > 0) {
			page = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "joinUser");
		} else {
			page = "/WEB-INF/views/common/fail.jsp";
			request.setAttribute("code", "joinUser");
			request.setAttribute("message", "회원가입에 실패하였습니다.");
		}
		request.getRequestDispatcher(page).forward(request, response);
	}
}