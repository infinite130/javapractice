<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSP Action Tag</title>
</head>
<body>
<%-- 	<%@ include file="common.jsp" %> --%>
		<jsp:include page="common.jsp"/>
		<h1>여기는 testAction.jsp</h1>
		
		<%
			request.setAttribute("name", "다람쥐");
		
// 			RequestDispatcher rd = request.getRequestDispatcher("testForward.jsp");
// 			rd.forward(request, response);
		%>
		
		<jsp:forward page="testForward.jsp"/>
</body>
</html>