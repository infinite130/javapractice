package com.javanos.project.lnf.controller;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.javanos.project.lnf.model.dto.LnfBoardDTO;
import com.javanos.project.lnf.model.dto.StationDTO;
import com.javanos.project.lnf.model.service.LnfBoardService;
import com.javanos.project.user.model.dto.UserDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/lnf/insert")
public class EnrollBoardServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/lnf/page/enrollForm.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String StaLine = request.getParameter("staLine");
		String staName = request.getParameter("staName");
		
		String findDateStr = request.getParameter("findDate");
		Date findDate = null;
		try {
		    findDate = new SimpleDateFormat("yyyy-MM-dd").parse(findDateStr);
		} catch (ParseException e) {
		    e.printStackTrace(); // 오류 처리 필요
		}
		
		String missing = request.getParameter("missing");
		String keep = request.getParameter("keep");
		String description = request.getParameter("description");
//		int writerMemberNo = ((UserDTO) request.getSession().getAttribute("loginMember")).getUserNo();
		
		StationDTO newStaBoard = new StationDTO();
		newStaBoard.setStaLine(StaLine);
		newStaBoard.setStaName(staName);
		
		LnfBoardDTO newBoard = new LnfBoardDTO();
		newBoard.setMissing(missing);
		newBoard.setKeep(keep);
		newBoard.setDescription(description);
//		newBoard.getUserNo();
		
		LnfBoardService boardService = new LnfBoardService();
		int result = boardService.enrollBoard(newBoard);
		
		System.out.println(boardService);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("message", "게시판 등록이 완료되었습니다.");
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "게시판 작성에 실패하셨습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
