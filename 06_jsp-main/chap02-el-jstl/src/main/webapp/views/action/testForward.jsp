<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Title (forward)</title>
</head>
<body>
	<h1><%= request.getAttribute("name") %>�� ȯ���մϴ�!</h1>

	<h2>jsp:useBean Ȱ��</h2>
	
	<jsp:useBean id="member" class="com.ohgiraffers.eljstl.model.dto.MemberDTO" scope="page" />
	
	<jsp:setProperty name="member" property="name" value="�ٶ���" />
	<jsp:setProperty name="member" property="age" value="900" />
	<%-- <jsp:setProperty name="member" property="age" value="�ȳ��ϼ���" /> --%>
	<jsp:setProperty name="member" property="phone" value="010-1234-5678" />
	<jsp:setProperty name="member" property="email" value="squirrel@ohgiraffers.com" />
	
	�̸�: <jsp:getProperty name="member" property="name" /><br>
	����: <jsp:getProperty name="member" property="age" /><br>
	��ȭ��ȣ: <jsp:getProperty name="member" property="phone" /><br>
	�̸���: <jsp:getProperty name="member" property="email" /><br>
</body>
</html>