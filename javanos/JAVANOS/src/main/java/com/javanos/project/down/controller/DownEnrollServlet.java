package com.javanos.project.down.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.javanos.project.common.paging.Pagenation;
import com.javanos.project.common.paging.SelectCriteria;
import com.javanos.project.down.model.dto.DownDTO;
import com.javanos.project.down.model.service.DownService;
import com.javanos.project.user.model.dto.UserDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/down/enroll")
public class DownEnrollServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/* 내려요 게시글 조회 */
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

		DownService downService = new DownService();
		int totalCount = downService.selectTotalCount(searchMap);

		System.out.println("totaldownCount : " + totalCount);

		/* 한 페이지에 보여 줄 게시물 수 */ 
		int limit = 5;
		
		/* 한 번에 보여질 페이징 버튼의 갯수 */ 
		int buttonAmount = 5;

		/* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */ 
		SelectCriteria selectCriteria = null;

		if (searchCondition != null && !"".equals(searchCondition)) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition,
					searchValue);
		} else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}

		System.out.println(selectCriteria);

		/* 조회해온다 */
		List<DownDTO> downList = downService.selectDownList(selectCriteria);

		System.out.println("boardList : " + downList);

		String path = "";
		if (downList != null) {
			path = "/WEB-INF/views/down/DownEnrollForm.jsp";
			request.setAttribute("downList", downList);
			request.setAttribute("selectCriteria", selectCriteria);
		}

		
		request.getRequestDispatcher(path).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* 내려요 게시글 등록기능 */  
		
		int inStationNo = Integer.parseInt(request.getParameter("inStationNo"));
		int downStationNo = Integer.parseInt(request.getParameter("downStationNo"));
		int userNo = (((UserDTO) request.getSession().getAttribute("loginUser")).getUserNo()); 
		String downRoom = request.getParameter("downRoom");
		String downFull = request.getParameter("downFull");

		DownDTO newDown = new DownDTO();
		newDown.setInStationNo(inStationNo);
		newDown.setDownStationNo(downStationNo);
		newDown.setUserNo(userNo);
		newDown.setDownRoom(downRoom);
		newDown.setDownFull(downFull);

		DownService DownService = new DownService();
		int result = DownService.insertDown(newDown);

		response.sendRedirect(request.getContextPath() + "/down/enroll");

	}

}
