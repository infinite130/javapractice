package com.ohgiraffers.section02.list;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.ohgiraffers.model.dto.MemberDTO;


@WebServlet("/receive/list")
public class ReceiveListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDTO member1 = new MemberDTO("get","bracio","saurus",10000);
		MemberDTO member2 = new MemberDTO("get","jeneration","new",20);
		MemberDTO member3 = new MemberDTO("get","king","kong",100);
		MemberDTO member4 = new MemberDTO("get","cat","cute",2);
		
		List<MemberDTO> memberList = new ArrayList<>();
		memberList.add(member1);
		memberList.add(member2);
		memberList.add(member3);
		memberList.add(member4);
		
		System.out.println(memberList);
		
		response.setContentType("application/jason; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(memberList);
		out.close();
		
	}

}
