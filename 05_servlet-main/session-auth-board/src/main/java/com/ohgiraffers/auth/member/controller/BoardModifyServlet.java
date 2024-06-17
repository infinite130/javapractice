package com.ohgiraffers.auth.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

//TODO LV.2 > ST.4 > 1. 요청 매핑하기 
public class BoardModifyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO LV.2 > ST.4 > 3. 수정 페이지로 포와딩 시키기 (views/member/boardModify.jsp)
		//TODO LV.2 > ST.4 > 3+. 수정 페이지(views/member/boardModify.jsp) 완성시키기
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO LV.2 > ST.4 > 4. request에서 수정 파라미터를 꺼내서 DTO로 뭉쳐주기
		//TODO LV.2 > ST.4 > 5. BoardService의 메소드를 호출하여 게시글 수정하기
		//TODO LV.2 > ST.4 > 9. 상세 조회 서블릿 호출로 redirect 시키기
	}

}
