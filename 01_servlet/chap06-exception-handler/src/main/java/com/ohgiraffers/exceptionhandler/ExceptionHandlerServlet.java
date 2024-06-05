package com.ohgiraffers.exceptionhandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;

@WebServlet("/showErrorPage")
public class ExceptionHandlerServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Enumeration<String> attrNames = request.getAttributeNames();
		while(attrNames.hasMoreElements()) {
			System.out.println(attrNames.nextElement());
		}
		
		String errorMessage = (String) request.getAttribute("jakarta.servlet.error.message");
		Integer errorStatusCode = (Integer) request.getAttribute("jakarta.servlet.error.status_code");
		
//		StringBuilder responseBuilder = new StringBuilder();
//		responseBuilder.append("<!doctype html>\n")
//					   .append("<html>\n")
//					   .append("<head>\n")
//					   .append("</head>\n")
//					   .append("<body>\n")
//					   .append("<h1>Error Page</h1>\n")
//					   .append("<h3>ErroCode : </h3> + errorStatusCode\n")
//					   .append("<h1>Error Page</h1>\n")
//					   .append("</body>\n")
//					   .append("</html>");
//		
//		response.setContentType("text/html; charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		
//		out.print(responseBuilder.toString());
//		out.close();
		
		response.setContentType("text/html; charse=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<h1>Error Page :P</h1>\n" + "<h3>ErroCode : </h3>" + errorStatusCode);
		out.print("<h3>ErrorMessage : </h3>" + errorMessage);
		out.close();


	
	}

}
