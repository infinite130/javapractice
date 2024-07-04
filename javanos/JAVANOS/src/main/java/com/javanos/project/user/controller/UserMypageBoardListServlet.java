package com.javanos.project.user.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import com.javanos.project.common.paging.Pagenation;
import com.javanos.project.common.paging.SelectCriteria;
import com.javanos.project.community.model.dto.CommunityDTO;
import com.javanos.project.community.model.service.CommunityService;
import com.javanos.project.user.model.dto.UserDTO;
import com.javanos.project.user.model.service.UserService;

@WebServlet("/user/mypage/list")
public class UserMypageBoardListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDTO loginUser = (UserDTO) request.getSession().getAttribute("loginUser");

		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;

		if (currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}

		if (pageNo <= 0) {
			pageNo = 1;
		}

		int totalCount = new UserService().selectTotalCount(loginUser);

		int limit = 10;
		int buttonAmount = 10;
		SelectCriteria selectCriteria = null;
		selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		List<CommunityDTO> communityList = new UserService().selectBoardList(loginUser, selectCriteria);

		String path = "";

		if (communityList != null) {
			path = "/WEB-INF/views/user/userMypageBoardList.jsp";
			request.setAttribute("communityList", communityList);
			request.setAttribute("selectCriteria", selectCriteria);
		} else {
			path = "/WEB-INF/views/common/fail.jsp";
			request.setAttribute("message", "게시물 목록 조회 실패!");
		}

		request.getRequestDispatcher(path).forward(request, response);
	}
}
