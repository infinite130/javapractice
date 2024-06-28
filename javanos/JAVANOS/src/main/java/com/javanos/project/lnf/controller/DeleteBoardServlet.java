package com.javanos.project.lnf.controller;

import java.io.IOException;

import com.javanos.project.lnf.model.service.LnfBoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/lnf/delete")
public class DeleteBoardServlet extends HttpServlet {

	// 진짜 삭제하는 게 아니라 숨김 처리하는 method
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
//		
//		int result = new LnfBoardService().deleteBoard();
//
//		response.sendRedirect(request.getContextPath() + "/member/page");
	}

}
