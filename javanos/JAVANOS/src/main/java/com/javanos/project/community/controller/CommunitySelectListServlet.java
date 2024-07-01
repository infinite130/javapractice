package com.javanos.project.community.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.javanos.project.common.paging.Pagenation;
import com.javanos.project.common.paging.SelectCriteria;
import com.javanos.project.community.model.dto.CommunityDTO;
import com.javanos.project.community.model.service.CommunityService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/community/list")
public class CommunitySelectListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("뭐야 되는거야 안되는거야");
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;

		if (currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}

		if (pageNo <= 0) {
			pageNo = 1;
		}

		int totalCount = new CommunityService().selectTotalCount();
		
		if(totalCount>0) {
			System.out.println("totalCommunityCount : " + totalCount);
			
			/* 한 페이지에 보여 줄 게시물 수 */ 
			int limit = 10;
			
			/* 한 번에 보여질 페이징 버튼의 갯수 */ 
			int buttonAmount = 10;
			
			/* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */ 
			SelectCriteria selectCriteria = null;
			
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
			
			System.out.println(selectCriteria);
			
			//CommunityDTO를 list로 구성해서 forward시키기
			List<CommunityDTO> communityList = new CommunityService().selectThumbnailList(selectCriteria);
			
			for (Iterator iterator = communityList.iterator(); iterator.hasNext();) {
				CommunityDTO communityDTO = (CommunityDTO) iterator.next();
				System.out.println(communityDTO);
			}
			
			String path = "";
			if(communityList!=null) {
				path = "/WEB-INF/views/community/communityList.jsp";
				request.setAttribute("communityList", communityList);
				request.setAttribute("selectCriteria", selectCriteria);
				
			}
			
			request.getRequestDispatcher(path).forward(request, response);
			
		}else {
			System.out.println("게시글 전체 수 세기 실패!!");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}