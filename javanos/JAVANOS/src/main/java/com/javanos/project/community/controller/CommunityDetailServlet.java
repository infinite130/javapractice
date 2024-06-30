package com.javanos.project.community.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.javanos.project.community.model.dto.CommunityDTO;
import com.javanos.project.community.model.service.CommunityService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/community/detail")
public class CommunityDetailServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int communityNo = Integer.valueOf(request.getParameter("communityNo"));
		
		System.out.println(communityNo);

		CommunityDTO community = new CommunityService().selectOneThumbnailList(communityNo);
		
		System.out.println(community);
		
		
		
		  LocalDateTime enrollDate = community.getCommunityEnrollDate();
		  
		  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"); String
		  formattedDateTime = enrollDate.format(formatter);
		  
		  System.out.println(formattedDateTime);
		  
		  request.setAttribute("formattedDateTime", formattedDateTime);
		 
		request.setAttribute("community", community);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/community/detail.jsp");
		rd.forward(request, response);
	}

	
}
