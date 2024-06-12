package com.ohgiraffers.section01.simple;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.simple.JSONObject;

import com.ohgiraffers.model.dto.MemberDTO;

@WebServlet("/receive/simple")
public class ReceiveSimpleJasonObjectServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		MemberDTO member = new MemberDTO("Narae","INTP","London",33);
		
		JSONObject json = new JSONObject();
		json.put("name", member.getName());
		json.put("mbti", member.getMbti());
		json.put("city", member.getCity());
		json.put("age", member.getAge());
		
		response.setContentType("application/json; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.print(json.toJSONString());
		out.close();
	}

}
