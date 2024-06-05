package com.ohgiraffers.practice.orderpage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@WebServlet("/order")
public class OrderPageTestServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	Map<String, String[]> requestMap = request.getParameterMap();
//	Set<String> keySet = requestMap.keySet();
//	Iterator<String> keyIter = keySet.iterator();
//	
//	System.out.println("[주문내역]");
//	
//	while(keyIter.hasNext()) {
//		String key = keyIter.next();
//		String[] value = requestMap.get(key);
//		
//		for(int i = 0; i < value.length; i++) {
//			System.out.println(value[i]);
//		}
//	}
//	
	Enumeration<String> names = request.getParameterNames();
	
	System.out.println("[주문내역]");
	
	PrintWriter out = response.getWriter();
	out.print("<h3>[주문내역]</h3>");

	while(names.hasMoreElements()) {
		
		String key = names.nextElement();
		
		String[] value = requestMap.get(key);

		for(String str : value) {
			System.out.println(str);
			response.setContentType("text/html; charse=UTF-8");
			
			out.print(key+": "+str+"<br>");
		}
	}
	out.close();
	}

}
