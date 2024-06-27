package com.javanos.project.lnf.controller;

import java.io.IOException;
import java.util.List;

import com.javanos.project.lnf.model.dto.StationDTO;
import com.javanos.project.lnf.model.service.LnfBoardService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/lnf/first")
	public class FirstPageServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// DB 가지고 오기
		// String StaLine = new LnfBoardService().selectStaLine();
		
//		request.setAttribute("StaLine", StaLine);
//		System.out.println(StaLine);
         // JSP로 포워딩
         request.getRequestDispatcher("/WEB-INF/views/lnf/first/firstPage.jsp").forward(request, response);
 

        }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
		// 비동기 통신으로 호선 필터링한 역 정보 가지고 오기
		

	}

}
