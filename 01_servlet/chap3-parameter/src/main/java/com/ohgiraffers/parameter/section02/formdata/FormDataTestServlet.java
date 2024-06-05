package com.ohgiraffers.parameter.section02.formdata;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@WebServlet("/formdata")
public class FormDataTestServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		System.out.println("이름 : " + name);
		
		Map<String, String[]> requestMap = request.getParameterMap();
		Set<String> keySet = requestMap.keySet();		
		Iterator<String> keyIter = keySet.iterator();
		
		while(keyIter.hasNext()) {
			String key = keyIter.next();
			String[] value = requestMap.get(key);
			
			System.out.println("[key] " + key);
			for(int i = 0; i < value.length; i++) {
				System.out.println("value["+i+"] " + value[i]);
			}
		}
		
		Enumeration<String> names = request.getParameterNames();
		
		while(names.hasMoreElements()) {
			String key = names.nextElement();
			
			System.out.println("<key> " + key);
			String[] value = requestMap.get(key);
			for(String str : value) {
				System.out.println("<value> " + str);
			}
		}
		
	}

}
