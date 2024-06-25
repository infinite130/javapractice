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

@WebServlet("/user/delete")
public class UserDeleteServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDTO loginUser = (UserDTO) request.getSession().getAttribute("loginUser");

		int result = new UserService().deleteUser(loginUser);

		String page = "";
		if(result > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", null);
			page = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "deleteUser");
		} else {
			page = "/WEB-INF/views/common/fail.jsp";
			request.setAttribute("code", "deleteUser");
			request.setAttribute("message", "회원탈퇴에 실패하였습니다.");
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	}
}
