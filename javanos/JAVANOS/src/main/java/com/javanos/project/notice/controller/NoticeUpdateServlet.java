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

@WebServlet("/notice/update")
public class NoticeUpdateServlet extends HttpServlet {

	// 공지사항 수정 페이지로 이동하기 위한 공지사항 정보
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 클라이언트가 get 요청을 보냈을 때의 처리 절차:
	    // 1. 요청에서 공지사항 번호를 가져옴
		int no = Integer.parseInt(request.getParameter("no"));

	    // 2. 공지사항 서비스 객체 생성
		NoticeService noticeService = new NoticeService();
		
	    // 3. 공지사항 번호에 해당하는 상세정보 조회
//		selectNoticeDetail 메소드 호출 - 공지사항번호에 해당하는 "상세정보" 를 조회, 결과를 notice 변수에 DTO로 저장함
		NoticeDTO notice = noticeService.selectNoticeDetail(no);

	    // 4. 조회된 공지사항 정보가 존재하면 수정페이지로 전달, 없으면 실패 메시지 설정
//		경로 저장할 변수 초기화해줌
		String path = "";
//		notice(상세정보)가 있을 경우
		if (notice != null) {
//			상세정보있을때 updateForm페이지 경로 지정
			path = "/WEB-INF/views/notice/noticeUpdateForm.jsp";
//			조회된 상세정보 요청 속성에 추가??
			request.setAttribute("notice", notice);
		} else {
//			상세정보 
			path = "/WEB-INF/views/common/fail.jsp";
			request.setAttribute("message", "공지사항 수정용 조회하기 실패!");
		}

		request.getRequestDispatcher(path).forward(request, response);

	}

	// 공지사항 수정을 처리함
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	    // 1. 요청에서 수정된 공지사항 정보를 가져옴
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		int writerUserNo = ((UserDTO) request.getSession().getAttribute("loginUser")).getUserNo();

	    // 2. 공지사항 DTO 객체를 생성하고, 가져온 데이터를 설정
		NoticeDTO originNotice = new NoticeDTO();
		originNotice.setNoticeNo(noticeNo);
		originNotice.setNoticeTitle(title);
		originNotice.setNoticeBody(body);
		originNotice.setNoticeUserno(writerUserNo);

	    // 3. 공지사항 서비스 객체 생성
		NoticeService noticeService = new NoticeService();
		int result = noticeService.updateNotice(originNotice);
		System.out.println("servlet의 result " + result);

	    // 4. 공지사항 업데이트를 수행하고 결과를 저장
		String path = "";
		if (result > 0) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "updateNotice");
		} else {
			path = "/WEB-INF/views/common/fail.jsp";
			request.setAttribute("message", "공지사항 수정에 실패했습니다.");
		}
	    // 5. 업데이트 결과에 따라 적절한 페이지로 포워딩
		request.getRequestDispatcher(path).forward(request, response);
	}
}
