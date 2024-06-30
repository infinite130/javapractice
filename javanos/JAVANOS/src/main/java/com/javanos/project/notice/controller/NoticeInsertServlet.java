package com.javanos.project.notice.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.javanos.project.notice.model.dto.NoticeDTO;
import com.javanos.project.notice.model.service.NoticeService;
import com.javanos.project.user.model.dto.UserDTO;

@WebServlet("/notice/insert")
public class NoticeInsertServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		여기 요약
//		1. 클라가 get 요청 보냄
//		2. path 페이지 반환
//		3. 클라는 insertForm.jsp 볼 수 있음		
		
//		클라에게 포워딩(전달해줄)할 JSP 파일경로 -> String 문자열로 저장함
		String path = "/WEB-INF/views/notice/noticeInsertForm.jsp";
		
//		path 경로로 요청을 보낼 객체 반환. 클라의 요청을 지정된 경로*inserForm.jsp로 포워딩(전달)함.
//		-> 요청 url은 변경되지 않지만 서버측에서 다른 리소스가 응답 생성해서 클라이언트에게 반환함.(dispatcher기능)
		request.getRequestDispatcher(path).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		int writerUserNo = ((UserDTO) request.getSession().getAttribute("loginUser")).getUserNo();
		
		NoticeDTO newNotice = new NoticeDTO();
		newNotice.setNoticeTitle(title);
		newNotice.setNoticeBody(body);
		newNotice.setNoticeUserno(writerUserNo);  // 공지 작성자 회원번호 넣음
		
		// service 호출 - db 접근 위해
		NoticeService noticeService = new NoticeService();
		int result = noticeService.insertNotice(newNotice); // 성공 여부 숫자로 받기위해
		
		// 새 공지 삽입 성공 실패 여부에 따른 결과
		String path = "";
		if(result > 0 ) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "insertNotice");
		}else {
			path = "/WEB-INF/views/common/fail.jsp";
			request.setAttribute("message", "공지사항 등록에 실패했습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
		
	}

}
