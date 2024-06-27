package com.javanos.project.down.controller;

import java.io.IOException;

import com.javanos.project.down.model.dto.DownDTO;
import com.javanos.project.down.model.service.DownService;
import com.javanos.project.user.model.dto.UserDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/down/enroll")
public class DownEnrollServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 내려요 게시글 조회 */
		
		
		String path = "/WEB-INF/views/down/DownEnrollForm.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	
	
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	int inStationNo = Integer.parseInt(request.getParameter("inStationNo"));  
	int downStationNo = Integer.parseInt(request.getParameter("downStationNo"));  
	//int userNo = ((UserDTO) request.getSession().getAttribute("loginUser")).getUserNo();
	int userNo = 1 ;
	String downRoom = request.getParameter("downRoom");
	String downFull = request.getParameter("downFull");
	
	DownDTO newDown = new DownDTO();
	newDown.setInStationNo(inStationNo);
	newDown.setDownStationNo(downStationNo);
	newDown.setUserNo(userNo);
	newDown.setDownRoom(downRoom);
	newDown.setDownFull(downFull);
	
	DownService DownService = new DownService();
	int result = DownService.insertDown(newDown);
	
	response.sendRedirect(request.getContextPath() + "/down/enroll");
	

}
	
	
}
