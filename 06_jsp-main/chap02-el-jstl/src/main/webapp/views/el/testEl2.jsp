<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "com.ohgiraffers.eljstl.model.dto.MemberDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>testEl2</title>
</head>
<body>
	<h1>���޵� request ��ü�� ����� MemberDTO �ʵ尪 ���</h1>
	
	<%
		MemberDTO member = (MemberDTO) request.getAttribute("member");
	%>
	�̸� : <%= member.getName() %><br>
	���� : <%= member.getAge() %><br>
	��ȭ��ȣ : <%= member.getPhone() %><br>
	�̸��� : <%= member.getEmail() %>
	
	<br>
	<br>
	�̸� : ${ requestScope.member.name }<br>
	���� : ${ requestScope.member.age }<br>
	��ȭ��ȣ : ${ member.phone }<br>
	�̸��� : ${ member.email }
	

</body>
</html>