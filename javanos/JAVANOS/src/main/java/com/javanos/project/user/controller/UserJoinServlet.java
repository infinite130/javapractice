package com.javanos.project.user.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.javanos.project.user.model.dto.UserDTO;
import com.javanos.project.user.model.service.UserService;

@WebServlet("/user/join")
public class UserJoinServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 회원가입 후 url로 /user/join 비정상 접근 시 로그인 정보를 초기화(세션 초기화)
		HttpSession session = request.getSession(false);	// 세션이 존재하면 반환, 존재하지 않으면 null 반환
				
		if(session != null && session.getAttribute("loginUser") != null) {
			session.invalidate();	// 세션 초기화
		}
				
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