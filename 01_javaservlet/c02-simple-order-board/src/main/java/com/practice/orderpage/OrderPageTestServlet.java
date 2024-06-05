package com.practice.orderpage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/order")
public class OrderPageTestServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Map<String, String[]> requestMap = request.getParameterMap();
		
		Enumeration<String> names = request.getParameterNames();
		
		PrintWriter out = response.getWriter();
		
		while(names.hasMoreElements()) {
			
			String key = names.nextElement();
			String[] value = requestMap.get(key);
			
			for(String str : value) {
				
				response.setContentType("text/html; charse=UTF-8");
				
				out.print(key+" : " + str+"<br>");
				
				
			}
			
		}
		
		out.close();
		
		// 3. 예외만들기
		// 입력받은 파라미터의 유효성을 검증하여(if 조건문 사용)
		// 잘못된 값이 들어온 경우 에러를 발생시키기&에러가 발생한다면 에러를 핸들링하는 페이지 만들
		
	}

}
