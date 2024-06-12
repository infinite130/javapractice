package com.ohgiraffers.section03.map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.ohgiraffers.model.dto.MemberDTO;

@WebServlet("/receive/hashMap")
public class ReceiveMapServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDTO member1 = new MemberDTO("get","bracio","saurus",10000);
		MemberDTO member2 = new MemberDTO("get","jeneration","new",20);
		MemberDTO member3 = new MemberDTO("get","king","kong",100);
		MemberDTO member4 = new MemberDTO("get","cat","cute",2);
		
		Map<String, MemberDTO> memberMap = new HashMap<>();
		memberMap.put("one",member1);
		memberMap.put("two",member2);
		memberMap.put("three",member3);
		memberMap.put("four",member4);
		
		System.out.println(memberMap);
		
		StringBuilder sb = new StringBuilder();
		Iterator<String> keyIter = memberMap.keySet().iterator();
		
		sb.append("{");
		while(keyIter.hasNext()) {
			String key = keyIter.next();
			
			sb.append("\"")
			  .append(key)
			  .append("\"")
			  .append(":")
			  .append(memberMap.get(key));
			
			if(keyIter.hasNext()) {
				sb.append(",");
			}
		}
		sb.append("}");
		
		System.out.println(sb);
		
		response.setContentType("application/json; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
//		out.print(memberMap);
		out.print(sb);
		out.close();

	}

}