<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>EL & JSTL</title>
</head>
<body>
	<h1>JSP Action Tag</h1>
	<h3><a href="views/action/testAction.jsp">JSP Action Tag test</a></h3>
	
	<br>

	<h1>EL (Expression Language)</h1>
	<h3><a href="test1">request.getAttribute() test</a></h3>
	<h3><a href="test2">request �� ����� ��ü ��� test</a></h3>
	<h3><a href="views/el/test3.jsp?name=ipone&price=100&no=5&no=6&option=apple">parameter �� ���� ������ ��� EL test</a></h3>
	<h3><a href="test4">requestScope �� sessionScope �켱���� �׽�Ʈ</a></h3>
	<br>
	
	<h1>JSTL (JSP Standard Tag Library)</h1>
	<h3><a href="views/jstl/testJstlCore.jsp">Core Library Test</a></h3>
	
	
</body>
</html>