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
	
	<h3>requestScope 의 member</h3>
	이름 : ${ requestScope.member.name }<br>
	나이 : ${ requestScope.member.age }<br>
	전화번호 : ${ requestScope.member.phone }<br>
	이메일 : ${ requestScope.member.email }

	<br>
	<h3>sessionScope 의 member</h3>
	이름 :${ sessionScope.member.name }<br>
	나이 : ${ sessionScope.member.age }<br>
	전화번호 : ${ sessionScope.member.phone }<br>
	이메일 : ${ sessionScope.member.email }
	
	<br>
	<h3>Scope 가 생략되었을 때 우선순위 테스트</h3>
	
	이름 : ${ member.name }<br>
	나이 : ${ member.age }<br>
	전화번호 : ${ member.phone }<br>
	이메일 : ${ member.email }

</body>
</html>