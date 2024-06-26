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

@WebServlet("/board/insert")
public class EnrollBoardServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/lnf/page/enrollForm.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* 가지고 와야 할 정보
		 * 게시판 정보
		 * first page - 역, 호선, 발견 일 (근데 이걸 enrollForm 받아와야 하는건가)
		 * enroll page - 발견 시간, 분실 품목, 보관 장소, 내용
		 */
		
		int lnfNo = Integer.parseInt(request.getParameter("lnfNo"));
//		int staNo=((StationDTO) request.getSession().getAttribute("stationNo")).getStaNo();
		String missing = request.getParameter("missing");
		String findDateStr = request.getParameter("findDate");
			Date findDate = null;
			try {
	            SimpleDateFormat sdf = new SimpleDateFormat("yy-mm-dd");
	            java.util.Date date = sdf.parse(findDateStr);
	            findDate = new Time(date.getTime());
	        } catch (ParseException e) {
	            e.printStackTrace();
	            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid time format");
	            return;
	        }
		String findTimeStr = request.getParameter("findTime");
			Time findTime = null;
			try {
	            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	            java.util.Date date = sdf.parse(findTimeStr);
	            findTime = new Time(date.getTime());
	        } catch (ParseException e) {
	            e.printStackTrace();
	            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid time format");
	            return;
	        }
		String keep = request.getParameter("keep");
		String description =request.getParameter("description");
		int writerNo = ((UserDTO) request.getSession().getAttribute("userNo")).getUserNo();
		
		LnfBoardDTO enrollBoard = new LnfBoardDTO();
		enrollBoard.setLnfNo(lnfNo);
		enrollBoard.getStaNo();
		enrollBoard.setMissing(missing);	
		enrollBoard.setFindDate(findDate);
		enrollBoard.setFindTime(findTime);
		enrollBoard.setKeep(keep);
		enrollBoard.setDescription(description);
		enrollBoard.getUserNo();
		
		int result = new LnfBoardService().enrollBoard(enrollBoard);
		
		
		request.getRequestDispatcher(request.getContextPath() +"/board/main");
	}

}
