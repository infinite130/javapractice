<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Javanos</title>
</head>
<body>
 	<jsp:include page="../common/menubar.jsp"/> 

	<div class="mypage-wrapper">
		<h2 align="center">마이페이지</h2>
		<form action="${ pageContext.servletContext.contextPath }/user/mypage" method="post" id="mypage-form">
			<table align="center">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="userId" id="userId" value="${ sessionScope.loginUser.userId }" readonly></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="userName" value="${ sessionScope.loginUser.userName }" readonly></td>
				</tr>
				<tr>
					<td>닉네임</td>
					<td><input type="text" name="userNickname" value="${ sessionScope.loginUser.userNickname }" required></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="email" name="userEmail" value="${ sessionScope.loginUser.userEmail }" required></td>
				</tr>
			</table>
			<div class="btns" align="center">
				<input type="submit" id="updateBtn" value="수정"><br>
				<input type="button" id="cancleBtn" value="취소">
				<input type="button" id="deleteBtn" value="회원탈퇴">
			</div>
		</form>
	</div>
	
	<script>
		document.getElementById("deleteBtn").onclick = function() {
			if (confirm("회원탈퇴 하시겠습니까?")) {
				// 기존 폼의 action을 회원탈퇴 서블릿으로 설정하고 제출
				var form = document.getElementById("mypage-form");
				form.action = "${ pageContext.servletContext.contextPath }/user/delete";
				form.submit();
			}
		};
	</script>


</body>
</html>