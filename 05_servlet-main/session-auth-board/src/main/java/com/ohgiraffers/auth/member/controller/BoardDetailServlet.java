package com.ohgiraffers.auth.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

//TODO LV.2 > ST.3 > 1. 요청 매핑하기 
public class BoardDetailServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO LV.2 > ST.3 > 3. request의 파라미터로 받은 boardNo 가져오기
		//TODO LV.2 > ST.3 > 4. 받아온 boardNo를 넘겨주며 BoardService 메소드를 호출하여 BoardDTO 반환받기
		
		//TODO LV.2 > ST.3 > 8. 조회완료한 boardDTO를 request에 attribute로 추가하여 상세 조회 페이지(views/member/boardDetail.jsp)로 포워딩
		//TODO LV.2 > ST.3 > 9. EL을 이용하여 상세조회 페이지 완성하기
	}

}
