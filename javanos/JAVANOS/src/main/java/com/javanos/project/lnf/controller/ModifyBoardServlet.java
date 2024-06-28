package com.javanos.project.lnf.controller;

import java.io.IOException;

import com.javanos.project.lnf.model.dto.LnfBoardDTO;
import com.javanos.project.lnf.model.service.LnfBoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/lnf/modify")
public class ModifyBoardServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		LnfBoardService lnfBoardService = new LnfBoardService();
		LnfBoardDTO lnfDetail = lnfBoardService.selectBoardDetail(no);
		
		System.out.println(lnfDetail);
		
		String path = "";
		if(lnfDetail != null) {
			path = "/WEB-INF/views/lnf/page/detailForm.jsp";
			request.setAttribute("detail", lnfDetail);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "수정 실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

	}


}
