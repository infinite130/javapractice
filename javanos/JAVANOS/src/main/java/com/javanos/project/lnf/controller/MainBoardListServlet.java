package com.javanos.project.lnf.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.javanos.project.common.paging.Pagenation;
import com.javanos.project.common.paging.SelectCriteria;
import com.javanos.project.lnf.model.dto.LnfBoardDTO;
import com.javanos.project.lnf.model.service.LnfBoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/lnf/main")
public class MainBoardListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// paging & search criteria
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;

		if (currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}

		if (pageNo <= 0) {
			pageNo = 1;
		}

		String searchCondition = request.getParameter("searchCondition");
		String searchValue = request.getParameter("searchValue");

		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", searchCondition);
		searchMap.put("searchValue", searchValue);

		LnfBoardService lnfBoardService = new LnfBoardService();
		int totalCount = lnfBoardService.selectTotalCount(searchMap);

		System.out.println("totaldownCount : " + totalCount);

		/* 한 페이지에 보여 줄 게시물 수 */ 
		int limit = 10;

		/* 한 번에 보여질 페이징 버튼의 갯수 */ 
		int buttonAmount = 5;

		/* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */ 
		SelectCriteria selectCriteria = null;

		if (searchCondition != null && !"".equals(searchCondition)) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
		} else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}

		System.out.println(selectCriteria);

		// 게시글 조회
		List<LnfBoardDTO> boardList = lnfBoardService.selectAllBoardList();

		System.out.println(boardList);

		String path = "";
		if (boardList != null && !boardList.isEmpty()) {
		    path = "/WEB-INF/views/lnf/page/boardList.jsp";
		    request.setAttribute("boardList", boardList);
		    request.setAttribute("selectCriteria", selectCriteria); // 페이징 정보를 request에 추가
		} else {
		    path = "/WEB-INF/views/common/failed.jsp";
		    request.setAttribute("message", "게시글이 없습니다.");
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
}
