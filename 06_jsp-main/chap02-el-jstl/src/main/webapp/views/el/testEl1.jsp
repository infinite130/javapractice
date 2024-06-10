<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h1>전달된 request 객체에 저장된 정보 출력</h1>
	
<%-- 	<% --%>
<!-- // 		String name = (String) request.getAttribute("name"); -->
<!-- // 		int age = (Integer) request.getAttribute("age"); -->
<!-- // 		String job = (String) request.getAttribute("job"); -->
<%-- 	%> --%>
	
<%-- 	name: <%= name %><br> --%>
<%-- 	age: <%= age %><br> --%>
<%-- 	job: <%= job %> --%>


<%-- 	name: ${ requestScope.name }<br> --%>
<%-- 	age: ${ requestScope.age }<br> --%>
<%-- 	job: ${ requestScope.job } --%>

	name : ${ name }<br>
	age : ${ age }<br>
	job : ${ job }
	
	<br>
	
	<h1>items 이름으로 저장된 리스트 정보 출력</h1>
	
	<%
		ArrayList items = (ArrayList) request.getAttribute("items");
		for(int i = 0; i < items.size(); i++) {
	%>
		<%= i %>: <%= items.get(i) %>

	<% } %>
	
	<br>
	
	0 : ${ items[0] }<br>
	1 : ${ itmes[1] }<br>
	2 : ${ items[2] }
</body>
</html>