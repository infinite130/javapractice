package com.ohgiraffers.response.section01.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/response")
public class ResponseTestServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		System.out.println("default response type: " + response.getContentType());
		System.out.println("default response encoding : " + response.getCharacterEncoding());
		
		response.setContentType("text/html; charset=UTF-8");
		
		StringBuilder responseBuilder = new StringBuilder();
		responseBuilder.append("<!doctype html>\n")
					   .append("<html>\n")
					   .append("<head>\n")
					   .append("</head>\n")
					   .append("<body>\n")
					   .append("<h1>Hello Servlet Response!</h1>\n")
					   .append("</body>\n")
					   .append("</html>");
		
		out.print(responseBuilder.toString());
		
		out.close();
	}

}
