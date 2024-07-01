package com.javanos.project.lnf.controller;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

import com.javanos.project.lnf.model.dto.LnfBoardDTO;
import com.javanos.project.lnf.model.service.LnfBoardService;
import com.javanos.project.user.model.dto.UserDTO;

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
		
		String path = "";
		if (lnfDetail !=null) {
			path = "/WEB-INF/views/lnf/page/modifyForm.jsp";
			request.setAttribute("lnfDetail", lnfDetail);
		} else {
			path = "/WEB-INF/views/common/fail.jsp";
			request.setAttribute("message", "게시글 수정용 조회하기 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		// 발견일, 분실 품목, 보관 장소, 상세 설명 변경; 수정일
		
		//발견일
		String findDateStr = request.getParameter("findDate");
		Date findDate = null;
		try {
		    findDate = new SimpleDateFormat("yyyy-MM-dd").parse(findDateStr);
		} catch (ParseException e) {
		    e.printStackTrace(); // 오류 처리 필요
		}
		// 발견 시간 
		Time findTime = null;
        try {
            String findTimeStr = request.getParameter("findTime");
            if (findTimeStr != null && !findTimeStr.isEmpty()) {
                LocalTime localTime = LocalTime.parse(findTimeStr, DateTimeFormatter.ofPattern("HH:mm"));
                findTime = Time.valueOf(localTime);
            }
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
		String missing = request.getParameter("missing");
		String keep = request.getParameter("keep");
		String description = request.getParameter("description");
		String staLine = request.getParameter("staLine");
		String staName = request.getParameter("staName");
		int writerUserNO = ((UserDTO) request.getSession().getAttribute("loginUser")).getUserNo();
		
		
		LnfBoardDTO modifyBoard = new LnfBoardDTO();
		modifyBoard.setLnfNo(no);
		modifyBoard.setFindDate(findDate);
		modifyBoard.setFindTime(findTime);
		modifyBoard.setMissing(missing);
		modifyBoard.setKeep(keep);
		modifyBoard.setDescription(description);
		modifyBoard.setDescription(staLine);
		modifyBoard.setDescription(staName);
		modifyBoard.setWriterNo(writerUserNO);
		
		LnfBoardService lnfBoardService = new LnfBoardService();
		int result = lnfBoardService.modifyBoard(modifyBoard);
		System.out.println(result);
		
		String path = "";
		if (result > 0) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "updateNotice");
		} else {
			path = "/WEB-INF/views/common/fail.jsp";
			request.setAttribute("message", "공지사항 수정에 실패했습니다.");
		}
		
		response.sendRedirect(request.getContextPath() + "/lnf/detail?boardNo=" + no);
		
	}


}
