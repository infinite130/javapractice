<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>response</title>
</head>
<body>
	<%
		String menuName = (String) request.getAttribute("menuName");
		int amount = (Integer) request.getAttribute("amount");
		int orderPrice = (Integer) request.getAttribute("orderPrice");
	%>
	
	<h3>�ֹ��� �޴�: <%= menuName %></h3>
	<h3>�ֹ� ����: <%= amount %></h3>
	<h1>���� �ݾ�: <%= orderPrice %></h1>
</body>
</html>