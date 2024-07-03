package com.javanos.project.user.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.javanos.project.community.model.dto.CommunityDTO;
import com.javanos.project.user.model.dto.UserDTO;
import com.javanos.project.user.model.service.UserService;

@WebServlet("/user/mypage/list")
public class UserMypageBoardListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDTO loginUser = (UserDTO) request.getSession().getAttribute("loginUser");
		
		List<CommunityDTO> communityList = new UserService().selectBoardList(loginUser);
		
		System.out.println("Servlet: " + communityList);
		
		request.setAttribute("communityList", communityList);
		
		request.getRequestDispatcher("/WEB-INF/views/user/userMypageBoardList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
