package com.ohgiraffers.listener.section01.context;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/context")
public class ContextListenerTestServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("context listener 확인용 servlet");
		
		ServletContext context = request.getServletContext();
		
		context.setAttribute("test", "value");
		
		context.setAttribute("test", "value2");
		
		context.removeAttribute("test");
	}

}
