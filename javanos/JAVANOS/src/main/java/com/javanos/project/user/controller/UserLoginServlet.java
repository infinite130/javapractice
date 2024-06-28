package com.javanos.project.user.controller;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
		
		// 로그인 후 url로 /user/login 비정상 접근 시 로그인 정보를 초기화(세션 초기화)
		HttpSession session = request.getSession(false);	// 세션이 존재하면 반환, 존재하지 않으면 null 반환
		
		if(session != null && session.getAttribute("loginUser") != null) {
			session.invalidate();	// 세션 초기화
		}
			
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
			Date stopDate = loginUser.getUserStopDate();
			System.out.println(stopDate);
			if(stopDate == null || stopDate.before(new Date())) {
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", loginUser);
				response.sendRedirect(request.getContextPath()); // main으로 이동
			} else {
				loginUser = null;
				request.setAttribute("message", "계정이 정지되었습니다. \\n" + stopDate + "일 이후에 다시 시도해주세요.");
				request.setAttribute("code", "loginUser");
				request.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("message", "로그인에 실패하였습니다.");
			request.setAttribute("code", "loginUser");
			request.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(request, response);
		}
	}
}
