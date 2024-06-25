<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티 게시글 수정하기</title>
</head>
<body>
	<form action="${pageContext.servletContext.contextPath}/community/update" method="post">
		<table>
				<tr>
					<th>제목: <input type="text" name="communityTitle" value="${ community.communityTitle }"></th>
				</tr>
				<tr>
					<td>작성자: ${ community.user.userNickname }</td>
					<input type="hidden" name="communityNo" value="${ community.communityNo }">
				</tr>
				<tr>
					<td>
					사진 나오는 곳
					</td>
				</tr>
				<tr>
					<td>내용: <input type="text" name="communityBody" value="${ community.communityBody }"></td>
				</tr>
			</table>
			
			
			<button>등록</button>
			<button onclick="gobackdetail()">취소</button>
	</form>
	<script>
	function gobackdetail() {
		window.history.back();
		//혹시 모르니까
/* 		let communityNo = ${ community.communityNo }
		location.href="${pageContext.servletContext.contextPath}/community/detail?communityNo="+ communityNo;  */
	};
	</script>
</body>
</html>