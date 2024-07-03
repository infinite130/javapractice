package com.javanos.project.notice.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.javanos.project.notice.model.dto.NoticeDTO;
import com.javanos.project.notice.model.service.NoticeService;

@WebServlet("/notice/detail")
public class NoticeSelectDetailServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		NoticeService noticeService = new NoticeService();
		
		NoticeDTO noticeDetail = noticeService.selectNoticeDetail(no);
		
		System.out.println("noticeDetail : " + noticeDetail);
		
		String path = "";
		
		if(noticeDetail != null) {
			path = "/WEB-INF/views/notice/noticeDetail.jsp";
			request.setAttribute("notice", noticeDetail);
		}else {
			path = "/WEB-INF/views/common/fail.jsp";
			request.setAttribute("message", "공지사항 상세 보기에 실패했습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
