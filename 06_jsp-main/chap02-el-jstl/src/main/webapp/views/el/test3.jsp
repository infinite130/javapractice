<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>EL test3</title>
</head>
<body>

	<h1>parameter �� �޾Ƽ� ���</h1>
	
	<%
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		String[] no = request.getParameterValues("no");
		String option = request.getParameter("option");
	%>
	
	��ǰ�� : <%= name %><br>
	���� : <%= price %><br>
	��ǰ��ȣ : <%= no[0] %>, <%= no[1] %><br>
	�ɼ� : <%= option %>

	<br>
	<h3>EL ver</h3>

	��ǰ�� : ${ param.name }<br>
	���� : ${ param.price }<br>
	��ǰ��ȣ : ${ paramValues.no[0] }, ${ paramValues.no[1] }<br>
	�ɼ� : ${ (empty param.option) ? "�ɼ� ����" :  param.option }
</body>
</html>