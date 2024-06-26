package com.javanos.project.lnf.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;
import com.javanos.project.lnf.model.dao.LnfDAO;
import com.javanos.project.lnf.model.dao.LnfDAOImplementation;
import com.javanos.project.lnf.model.dto.StationDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/lnf/first")
	public class FirstPageServlet extends HttpServlet {
	
	// 역 선택
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
            // DAO를 사용하여 데이터베이스에서 호선 정보를 가져옵니다.
            LnfDAO dao = new LnfDAOImplementation(); // LnfDAO를 구현한 클래스의 인스턴스 생성
            List<StationDTO> staLine = dao.getAllStationLine(); // 모든 호선 정보를 가져오는 메서드 호출

            // 가져온 호선 정보를 request attribute로 설정하여 JSP로 전달
            request.setAttribute("staLine", staLine);

            // JSP로 포워딩
            request.getRequestDispatcher("/WEB-INF/views/lnf/first/firstPage.jsp").forward(request, response);
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();

        }
	}

	// 비동기 통신으로 호선 필터링한 역 정보 가지고 오기
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String staLine = request.getParameter("staLine");
        
        // DAO를 사용하여 staLine에 해당하는 역 이름 목록을 조회
        LnfDAO dao = new LnfDAOImplementation();
        List<StationDTO> staName = dao.getStationNamesByLine(staLine);
        
        // JSON으로 응답을 생성
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(new Gson().toJson(staName));
        out.flush();

	}

}
