<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Javanos</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/user/userLoginForm.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>

	<div class="login-wrapper">
		<h2>Login</h2>
		<form action="${ pageContext.servletContext.contextPath }/user/login" method="post" id="login-form">
			<input type="text" name="userId" id="userId" placeholder="아이디를 입력하세요" ><br>
			<span id="userIdError" class="error"></span><br>
			
			<input type="password" name="userPwd" id="userPwd" placeholder="비밀번호를 입력하세요" ><br>
			<span id="userPwdError" class="error"></span><br>
			
			<input type="submit" id="loginBtn" value="로그인"><br>
		</form>
		<p>아직 회원이 아니신가요? <a href="${ pageContext.servletContext.contextPath }/user/join">회원가입</a>
	
	</div>
	
	<script>
		$(document).ready(function() {
			$('#login-form').submit(function(event) {
				
				$('#userIdError').text("");
				$('#userPwdError').text("");
				
				let valid = true;
				
				if($('#userId').val().trim() === "") {
                    $('#userIdError').text("아이디를 입력하세요.");
					valid = false;
				}
				
				if($('#userPwd').val().trim() ===  "") {
                    $('#userPwdError').text("비밀번호를 입력하세요.");
					valid = false;
				}
				
				if(!valid) {
					event.preventDefault();
				}
			});
		});
	
	</script>
</body>
</html>