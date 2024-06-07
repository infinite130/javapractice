package com.practice.order;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/print")
public class OrderResultServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String product = request.getParameter("product");
		String number = request.getParameter("number");
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charse=UTF-8");
		out.print("<h3>"+product+"("+number+"개)</h3");
		out.print("<h3>주문이 완료되었습니다</h3>");
		out.print("<a href=\"otherservlet\">클릭");
		out.print("</a>");
		out.close();
		
	
		
		
		
	}

}
