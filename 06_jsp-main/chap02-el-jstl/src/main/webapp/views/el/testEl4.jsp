<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>testEL4 session request</title>
</head>
<body>
	<h1>requestScope & sessionScope</h1>
	
	<h3>requestScope �� member</h3>
	�̸� : ${ requestScope.member.name }<br>
	���� : ${ requestScope.member.age }<br>
	��ȭ��ȣ : ${ requestScope.member.phone }<br>
	�̸��� : ${ requestScope.member.email }

	<br>
	<h3>sessionScope �� member</h3>
	�̸� :${ sessionScope.member.name }<br>
	���� : ${ sessionScope.member.age }<br>
	��ȭ��ȣ : ${ sessionScope.member.phone }<br>
	�̸��� : ${ sessionScope.member.email }
	
	<br>
	<h3>Scope �� �����Ǿ��� �� �켱���� �׽�Ʈ</h3>
	
	�̸� : ${ member.name }<br>
	���� : ${ member.age }<br>
	��ȭ��ȣ : ${ member.phone }<br>
	�̸��� : ${ member.email }

</body>
</html>