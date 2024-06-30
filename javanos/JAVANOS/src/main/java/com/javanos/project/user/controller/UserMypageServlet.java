package com.javanos.project.user.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.javanos.project.user.model.dto.UserDTO;
import com.javanos.project.user.model.service.UserService;

@WebServlet("/user/mypage")
public class UserMypageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/WEB-INF/views/user/userMypageForm.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDTO originUser = (UserDTO) request.getSession().getAttribute("loginUser");
		
		String pwd = request.getParameter("newPwd");
		String nickname = request.getParameter("userNickname");
		String email = request.getParameter("userEmail");
				
		originUser.setUserPwd(pwd);
		originUser.setUserNickname(nickname);
		originUser.setUserEmail(email);
		
		UserDTO updateUser = new UserService().updateUser(originUser);
		
		String page = "";
		if(updateUser != null) {
			page = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "updateUser");
		} else {
			page = "/WEB-INF/views/common/fail.jsp";
			request.setAttribute("code", "updateUser");
			request.setAttribute("message", "회원정보 수정에 실패하였습니다.");
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	}
}
