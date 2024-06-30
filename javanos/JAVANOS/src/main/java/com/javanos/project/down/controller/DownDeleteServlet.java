package com.javanos.project.down.controller;

import java.io.IOException;

import com.javanos.project.down.model.service.DownService;
import com.javanos.project.notice.model.service.NoticeService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/down/delete")
public class DownDeleteServlet extends HttpServlet{ 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int deletedown = Integer.parseInt(request.getParameter("downNo"));
		
		DownService downservice = new DownService();
		int result = downservice.deleteDown(deletedown);
		
		if(result > 0) {
			response.sendRedirect(request.getContextPath() + "/down/enroll");
		} else {
			request.setAttribute("message", "게시글 삭제에 실패했습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/failed.jsp").forward(request, response);
		}
	}

}
