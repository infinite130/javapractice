package com.ohgiraffers.json.section03.jasonarray;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/receive/jsonarray")
public class ReceiveJasonArrayServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("[{\"type\":\"get\",\"firstname\":\"whale\",\"lastname\":\"king\",\"height\":200},"
				+"{\"type\":\"get\",\"firstname\":\"bracio\",\"lastname\":\"hat\",\"height\":184},"
				+"{\"type\":\"get\",\"firstname\":\"dog\",\"lastname\":\"cute\",\"height\":50},"
				+"{\"type\":\"get\",\"firstname\":\"sheep\",\"lastname\":\"yang\",\"height\":100}]");
		out.close();
		
	}

}
