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
		
//		/* 목록보기를 눌렀을 시 가장 처음에 보여지는 페이지는 1페이지이다.
//		 * 파라미터로 전달되는 페이지가 있는 경우 currentPage는 파라미터로 전달받은 페이지 수 이다.
//		 * */
//		String currentPage = request.getParameter("currentPage");
//		int pageNo = 1;
//		
//		if(currentPage != null && !"".equals(currentPage)) {
//			pageNo = Integer.parseInt(currentPage);
//		}
//		
//		/* 0보다 작은 숫자값을 입력해도 1페이지를 보여준다 */
//		if(pageNo <= 0) {
//			pageNo = 1;
//		}
//		
//		String searchCondition = request.getParameter("searchCondition");
//		String searchValue = request.getParameter("searchValue");
//		
//		Map<String, String> searchMap = new HashMap<>();
//		searchMap.put("searchCondition", searchCondition);
//		searchMap.put("searchValue", searchValue);
//		
//		/* 전체 게시물 수가 필요하다.
//		 * 데이터베이스에서 먼저 전체 게시물 수를 조회해올 것이다.
//		 * 검색조건이 있는 경우 검색 조건에 맞는 전체 게시물 수를 조회한다.
//		 * */
//		LnfBoardService boardService = new LnfBoardService();
//		int totalCount = boardService.selectTotalCount(searchMap);
//		
//		System.out.println("totalBoardCount : " + totalCount);
//		
//		/* 한 페이지에 보여 줄 게시물 수 */
//		int limit = 10;		//얘도 파라미터로 전달받아도 된다.
//		/* 한 번에 보여질 페이징 버튼의 갯수 */
//		int buttonAmount = 5;
//		
//		/* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
//		SelectCriteria selectCriteria = null;
//		
//		if(searchCondition != null && !"".equals(searchCondition)) {
//			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
//		} else {
//			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
//		}
//		
//		System.out.println(selectCriteria);
//		
		// 게시글 조회
		List<LnfBoardDTO> boardList = new LnfBoardService().selectAllBoardList();
		
		System.out.println(boardList);
		
		String path = "";
		if (boardList != null && !boardList.isEmpty()) {
		    path = "/WEB-INF/views/lnf/page/boardList.jsp";
		    request.setAttribute("boardList", boardList);
		} else {
		    path = "/WEB-INF/views/common/failed.jsp";
		    request.setAttribute("message", "게시글이 없습니다.");
		}
		request.getRequestDispatcher(path).forward(request, response);
		
		// 검색 메소드 
		String searchCondition = request.getParameter("searchCondition");
		String keyword = request.getParameter("keyword");

		LnfBoardService lnfBoardService = new LnfBoardService();
		List<LnfBoardDTO> searchBoardList = null;

		System.out.println(searchCondition);

		if (searchCondition != null && keyword != null) {
		    if ("staLine".equals(searchCondition)) {
		        searchBoardList = lnfBoardService.searchByLine(keyword);
		    } else if ("staName".equals(searchCondition)) {
		        searchBoardList = lnfBoardService.searchByStation(keyword);
		    } else if ("missing".equals(searchCondition)) {
		        searchBoardList = lnfBoardService.searchByMissing(keyword);
		    }
		}

		System.out.println(searchBoardList);

		request.setAttribute("searchBoardList", searchBoardList);
		request.getRequestDispatcher("/WEB-INF/views/lnf/page/searchForm.jsp").forward(request, response);
	}

}
