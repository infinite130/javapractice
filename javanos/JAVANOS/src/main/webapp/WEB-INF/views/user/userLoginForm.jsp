<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Javanos</title>
<%-- <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/user/userLoginForm.css">
 --%>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>

	<div class="login-wrapper">
		<h2>Login</h2>
		<form action="${ pageContext.servletContext.contextPath }/user/login" method="post" id="login-form">
			<input type="text" name="userId" placeholder="아이디를 입력하세요" required><br>
			<input type="password" name="userPwd" placeholder="비밀번호를 입력하세요" required><br>
			<input type="submit" id="loginBtn" value="로그인"><br>
		</form>
		<p>아직 회원이 아니신가요? <a href="${ pageContext.servletContext.contextPath }/user/join">회원가입</a>
	
	</div>

</body>
</html>