<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>EL test3</title>
</head>
<body>

	<h1>parameter 값 받아서 출력</h1>
	
	<%
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		String[] no = request.getParameterValues("no");
		String option = request.getParameter("option");
	%>
	
	상품명 : <%= name %><br>
	가격 : <%= price %><br>
	제품번호 : <%= no[0] %>, <%= no[1] %><br>
	옵션 : <%= option %>

	<br>
	<h3>EL ver</h3>

	상품명 : ${ param.name }<br>
	가격 : ${ param.price }<br>
	제품번호 : ${ paramValues.no[0] }, ${ paramValues.no[1] }<br>
	옵션 : ${ (empty param.option) ? "옵션 없음" :  param.option }
</body>
</html>