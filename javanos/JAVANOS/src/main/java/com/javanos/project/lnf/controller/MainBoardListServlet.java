package com.javanos.project.lnf.controller;

import java.io.IOException;
import java.util.List;

import com.javanos.project.lnf.model.dto.LnfBoardDTO;
import com.javanos.project.lnf.model.service.LnfBoardService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/lnf/main")
public class MainBoardListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 게시글 조회
		List<LnfBoardDTO> boardList = new LnfBoardService().selectAllBoardList();
		
//		System.out.println(boardList);
		
		String path = "";
		if(boardList != null) {
			path = "/WEB-INF/views/lnf/page/boardList.jsp";
			request.setAttribute("boardList", boardList);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);

	}

}
