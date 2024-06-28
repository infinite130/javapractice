package com.javanos.project.notice.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.javanos.project.notice.model.dto.NoticeDTO;
import com.javanos.project.notice.model.service.NoticeService;

@WebServlet("/notice/noticeSearchList")
public class NoticeSearchListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String searchCondition = request.getParameter("searchCondition");
		String keyword = request.getParameter("keyword");
		
		NoticeService noticeService = new NoticeService();
		List<NoticeDTO> noticeList = null;
		
		if ("title".equals(searchCondition)) {
			noticeList = noticeService.searchNoticeByTitle(keyword);
		} else if ("body".equals(searchCondition)) {
			noticeList = noticeService.searchNoticeByBody(keyword);
		} else if ("titleAndBody".equals(searchCondition)) {
			noticeList = noticeService.searchNoticeByTitleAndBody(keyword);
		}
		
		request.setAttribute("noticeList", noticeList);
		request.getRequestDispatcher("/WEB-INF/views/notice/noticeList.jsp").forward(request, response);
	}
	
	
}
