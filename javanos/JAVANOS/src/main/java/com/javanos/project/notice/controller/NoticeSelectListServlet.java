package com.javanos.project.notice.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.javanos.project.common.paging.Pagenation;
import com.javanos.project.common.paging.SelectCriteria;
import com.javanos.project.notice.model.dto.NoticeDTO;
import com.javanos.project.notice.model.service.NoticeService;

@WebServlet("/notice/list")
public class NoticeSelectListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

////		여기 요약
////		1. 클라가 get요청 보냄
////		2. noticeService 이용해 모든 공지사항 목록 조회함
////		3. 조회된 목록 존재하면 목록페이지를 전달, 실패하면 실패 메세지 페이지로 포워딩
////		4. 최종 - 클라는 공지사항 목록을 확인가능한 페이지로 이동하게됨 
//
////		noticeService 객체 생성
////		noticeService의 selectAllNoticeServiceList 메소드 호출해서 "모든 공지사항 목록 조회"
////		-> 결과를 "변수 noticeList"에 저장 list<noticeDTO>
//		List<NoticeDTO> noticeList = new NoticeService().selectAllNoticeList();
//
////		모든 공지사항 목록 조회한 결과(noticeList)를 콘솔에 출력
//		System.out.println(noticeList);
//
////		경로 초기화
//		String path = "";
////		공지사항 목록 존재하면
//		if (noticeList != null) {
////			공지사항 목록 페이지로 조회된 목록을 요청 속성에 넣음
//			path = "/WEB-INF/views/notice/noticeList.jsp";
//			request.setAttribute("noticeList", noticeList);
//		} else {
////			공지사항 목록 없으면 실패 메시지 요청 속성에 넣음
//			path = "/WEB-INF/views/common/fail.jsp";
//			request.setAttribute("message", "공지사항 조회 실패!");
//		}
//
//		request.getRequestDispatcher(path).forward(request, response);
//
//	}

		

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
        
        NoticeService noticeService = new NoticeService();
        int totalCount = noticeService.selectTotalCount(searchMap);
        
        System.out.println("totalNoticeCount : " + totalCount);
        
        /* 한 페이지에 보여 줄 게시물 수 */
		int limit = 10;		//얘도 파라미터로 전달받아도 된다.
		/* 한 번에 보여질 페이징 버튼의 갯수 */
		int buttonAmount = 5;
		
		/* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
		SelectCriteria selectCriteria = null;
		
		if(searchCondition != null && !"".equals(searchCondition)) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
		} else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		
		System.out.println(selectCriteria);
		
		
		/* 조회해온다 */
		List<NoticeDTO> noticeList = noticeService.selectAllNoticeList(selectCriteria);
		
		System.out.println("noticeList : " + noticeList);

		
		/* 조회해온다 */
        String path = "";
        if (noticeList != null) {
            path = "/WEB-INF/views/notice/noticeList.jsp";
            request.setAttribute("noticeList", noticeList);
            request.setAttribute("selectCriteria", selectCriteria);
        } else {
            path = "/WEB-INF/views/common/fail.jsp";
            request.setAttribute("message", "공지사항 조회 실패!");
        }

        request.getRequestDispatcher(path).forward(request, response);
    }
		

}
