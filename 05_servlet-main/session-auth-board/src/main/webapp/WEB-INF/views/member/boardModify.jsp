<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="" method="">
	<table>
		<tr>
			<td>제목</td>
			<td><input type="text" name="boardTitle" value=""></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${ sessionScope.loginMember.memberName }</td>
			<input type="hidden" name="boardWriterMemberNo" value="${ sessionScope.loginMember.memberNo }">
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea rows="50" cols="100" name="boardBody" maxlength="1000" value=""></textarea></td>
		</tr>
		<tr>
			<td><button>수정</button></td>
		</tr>
	</table>
	</form>
</body>
</html>