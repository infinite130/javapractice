package com.javanos.project.notice.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.javanos.project.notice.model.service.NoticeService;

@WebServlet("/notice/delete")
public class NoticeDeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noticeNo = Integer.parseInt(request.getParameter("no"));
		
		NoticeService noticeService = new NoticeService();
		int result = noticeService.deleteNotice(noticeNo);
		
		if(result > 0) {
			response.sendRedirect(request.getContextPath() + "/notice/list");
		} else {
			request.setAttribute("message", "공지사항 삭제에 실패했습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/failed.jsp").forward(request, response);
		}
	}
}
