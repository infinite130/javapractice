<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Javanos</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
 	<jsp:include page="../common/menubar.jsp"/> 

	<div class="join-wrapper">
		<h2>회원가입</h2>
		<form action="${ pageContext.servletContext.contextPath }/user/join" method="post" id="join-form">
			<input type="text" name="userId" id="userId" placeholder="*아이디" required>
			<input type="button" value="중복확인" id="dupCheck" required><br>
			<input type="password" name="userPwd" placeholder="*비밀번호" required><br>
			<input type="password" name="userPwdCheck" placeholder="*비밀번호 확인" required><br>
			<input type="text" name="userName" placeholder="*이름" required><br>
			<input type="text" name="userNickname" placeholder="*닉네임" required><br>
			<input type="email" name="userEmail" placeholder="*이메일" required><br>
			<label for="agreeTerms">
				<input type="checkbox" id="agreeTerms" name="agreeTerms" required>
				이용약관과 개인정보 수집 및 정보이용에 동의합니다
			</label><br>
			<input type="submit" id="joinBtn" value="회원가입"><br>
		</form>
	</div>
	
	<script>
		$(document).ready(function() {
			$("#dupCheck").click(function() {
				let userId = $("#userId").val().trim();
				if (userId === "") {
					alert("아이디를 입력해주세요.");
					return;
				}
				
				$.ajax({
					url: "${ pageContext.servletContext.contextPath }/user/checkid",
					type: "post",
					data: {userId: userId},
					success: function(data) {
						if(data == 'pass') {
							alert('사용 가능한 ID 입니다.');
						} else {
							alert('이미 존재하는 ID 입니다.');
							$("#userId").val('');
						}
					},
					error: function(error) {
						alert('처리중 예외가 발생하였습니다.');
					}
				});
			});
		});
	</script>
	

</body>
</html>