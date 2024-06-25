package com.javanos.project.community.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.javanos.project.community.model.dto.CommunityDTO;
import com.javanos.project.community.model.service.CommunityService;

@WebServlet("/community/update")
public class CommunityUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int communityNo = Integer.valueOf(request.getParameter("communityNo"));

		CommunityDTO community = new CommunityService().selectOneCommunity(communityNo);

		request.setAttribute("community", community);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/community/updateform.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int communityNo = Integer.valueOf(request.getParameter("communityNo"));
		String communityTitle = request.getParameter("communityTitle");
		String communityBody = request.getParameter("communityBody");
		LocalDateTime communityModifyDate = LocalDateTime.now();

		CommunityDTO updateCommunity = new CommunityDTO();
		updateCommunity.setCommunityNo(communityNo);
		updateCommunity.setCommunityTitle(communityTitle);
		updateCommunity.setCommunityBody(communityBody);
		updateCommunity.setCommunityModifyDate(communityModifyDate);

		int result = new CommunityService().updateCommunity(updateCommunity);

		String path = "";
		
		  if(result>0) { //성공 
			  path = "/WEB-INF/views/common/success.jsp";
			  request.setAttribute("communityNo", updateCommunity.getCommunityNo());
		      request.setAttribute("successCode", "communityUpdate");
			  request.setAttribute("message", "수정되었습니다!! :)");
		  }else { //실패 
			  System.out.println("수정실패");
			  path = "/WEB-INF/views/common/fail.jsp";
			  request.setAttribute("message", "게시판 수정에 실패하셨습니다.");
			  request.setAttribute("code", "communityUpdate");
		  }
		  
		  request.getRequestDispatcher(path).forward(request, response);

	}

}
