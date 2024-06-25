package com.javanos.project.community.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.javanos.project.community.model.service.CommunityService;


@WebServlet("/community/delete")
public class CommunityDeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int communityNo = Integer.valueOf(request.getParameter("communityNo"));
		
		int result = new CommunityService().deleteCommunity(communityNo);
		
		String path = "";
		
		  if(result>0) { //성공 
			  path = "/WEB-INF/views/common/success.jsp";
		      request.setAttribute("successCode", "communityDelete");
			  request.setAttribute("message", "삭제되었습니다!! :)");
		  }else { //실패 
			  System.out.println("삭제실패");
			  path = "/WEB-INF/views/common/fail.jsp";
			  request.setAttribute("message", "게시판 삭제에 실패하셨습니다.");
			  request.setAttribute("code", "communityDelete");
		  }
		  
		  request.getRequestDispatcher(path).forward(request, response);

	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
