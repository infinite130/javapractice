package com.javanos.project.lnf.controller;

import java.io.IOException;
import java.util.List;

import com.javanos.project.lnf.model.dto.LnfBoardDTO;
import com.javanos.project.lnf.model.service.LnfBoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/lnf/search")
public class LnfSerachServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//request.setCharacterEncoding("UTF-8");
		
		String searchCondition = request.getParameter("searchCondition");
		String keyword = request.getParameter("keyword");
		
		LnfBoardService lnfBoardService = new LnfBoardService();
		List<LnfBoardDTO> boardList = null;
		
		if ("staLine".equals(searchCondition)) {
			boardList = lnfBoardService.searchByLine(keyword);
		} else if ("body".equals(searchCondition)) {
			boardList = lnfBoardService.searchByStation(keyword);
		} else if ("titleAndBody".equals(searchCondition)) {
			boardList = lnfBoardService.searchByMissing(keyword);
		}
		
		System.out.println(searchCondition);
		request.setAttribute("searchBoardList", boardList);
		request.getRequestDispatcher("/WEB-INF/views/lnf/page/boardList.jsp").forward(request, response);
	}

}
