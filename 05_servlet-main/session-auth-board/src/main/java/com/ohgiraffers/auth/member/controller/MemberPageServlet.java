package com.ohgiraffers.auth.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/member/page")
public class MemberPageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO LV.2 > ST.1 > 1. BoardService의 메소드를 호출하여 boardList를 반환받기
		// TODO LV.2 > ST.1 > 1+. boardList를 반환받기 위한 BoardDTO 작성하기
		// TODO LV.2 > ST.1 > 6. boardList를 request의 attribute로 추가하여 포와딩하기 
		request.getRequestDispatcher("/WEB-INF/views/member/page.jsp").forward(request, response);
		
		// TODO LV.2 > ST.1 > 7. views/member/page.jsp 를 수정하여 조회한 게시판 목록이 보여지게 하기
	}

}
