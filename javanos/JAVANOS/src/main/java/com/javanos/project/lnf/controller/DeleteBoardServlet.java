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
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		LnfBoardService lnfBoardService = new LnfBoardService();
		int result = lnfBoardService.deleteBoard(no);
		
		if(result > 0) {
		response.sendRedirect(request.getContextPath() + "/lnf/main");
		} else {
		request.setAttribute("message", "게시글 삭제에 실패했습니다.");
		request.getRequestDispatcher("/WEB-INF/views/common/failed.jsp").forward(request, response);
		}
		
	}
}
