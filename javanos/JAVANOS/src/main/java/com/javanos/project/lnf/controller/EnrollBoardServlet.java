package com.javanos.project.lnf.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.javanos.project.lnf.model.dto.LnfBoardDTO;
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
	
		// TBL_STATION 테이블에서 역 정보를 조회
//		int no = Integer.parseInt(request.getParameter("no"));
//		
//		LnfBoardService lnfBoardService = new LnfBoardService();
//		StationDTO selectStaName = lnfBoardService.selectStaName(no);
//
//		System.out.println(selectStaName);
//
//	    // 조회 결과를 JSP로 전달
//	    request.setAttribute("staName", selectStaName);
		
		request.getRequestDispatcher("/WEB-INF/views/lnf/page/enrollForm.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 역, 호선, 발견일, 분실 품목, 보관 장소, 상세 설명
		String staLine = request.getParameter("staLine");
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
		int writerUserNO = ((UserDTO) request.getSession().getAttribute("loginUser")).getUserNo();
	
		
		LnfBoardDTO newBoard = new LnfBoardDTO();
		newBoard.setLnfStaLine(staLine);
		newBoard.setLnfStaName(staName);
		newBoard.setFindDate(findDate);
		newBoard.setMissing(missing);
		newBoard.setKeep(keep);
		newBoard.setDescription(description);
		newBoard.setWriterNo(writerUserNO);
		
		System.out.println(newBoard);
		
		LnfBoardService boardService = new LnfBoardService();
		int result = boardService.enrollBoard(newBoard);
		
		System.out.println(boardService);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "enrollBoard");
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "게시판 작성에 실패하셨습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
