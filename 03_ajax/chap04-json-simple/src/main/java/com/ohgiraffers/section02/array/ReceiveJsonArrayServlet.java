package com.ohgiraffers.section02.array;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.ohgiraffers.model.dto.MemberDTO;

@WebServlet("/receive/jsonarray")
public class ReceiveJsonArrayServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		MemberDTO members = new MemberDTO();
		
		MemberDTO members1 = new MemberDTO("Narae","INTP","London",33);
		MemberDTO members2 = new MemberDTO("Bracio","INTP","NewYork",20);
		MemberDTO members3 = new MemberDTO("Tiger","ESTJ","Seoul",20);
		MemberDTO members4 = new MemberDTO("Cat","ENTP","Cicago",22);
	
		List<MemberDTO> memberList = new ArrayList<>();
		
		memberList.add(members1);
		memberList.add(members2);
		memberList.add(members3);
		memberList.add(members4);
		
		JSONArray jsonArray = new JSONArray();
		for(MemberDTO member : memberList) {
			JSONObject json = new JSONObject();
			json.put("name", member.getName());
			json.put("mbti", member.getMbti());
			json.put("city", member.getCity());
			json.put("age", member.getAge());
			
			jsonArray.add(json);
		}
	
		System.out.println(memberList);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(jsonArray.toJSONString());
		out.close();

	}
	

}
