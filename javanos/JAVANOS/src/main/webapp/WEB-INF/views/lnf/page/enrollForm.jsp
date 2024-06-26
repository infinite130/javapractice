<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>습득 글 작성 - 분실물 게시판</title>
</head>
<body>

	<jsp:include page="../../common/menubar.jsp"/>
	
	<div>
		<h2 align="center">분실물 게시글 등록</h2>
		<br>
		<form action="${ pageContext.servletContext.contextPath }/board/insert" method="post">
			<table>
			<!-- 호선, 습득 역, 발견일 정보 출력 -->
			<tr>
				<td>호선</td>
				<td>${ sessionScope.loginMember.memberName }</td>
					<input type="hidden" name="boardWriterMemberNo" value="${ sessionScope.loginMember.memberNo }">
					
				<c:forEach var="fruit" items="${fruits}">
    				<p>${fruit}</p>
				</c:forEach>
			</tr>
			
			<!-- 입력 받기  -->
				<tr>
					<td>분실 품목</td>
					<td>
						<input type="text" name="missing"/>
					</td>
				</tr>
				<tr>
					<td>발견 시간</td>
					<td>
						<input type="time" name="findTime"/>
					</td>
				</tr>
				<tr>
					<td>보관 장소</td>
					<td>
						<input type="text" name="keep"/>
					</td>
				</tr>
				<tr>
					<td>상세 설명</td>
					<td>
						<input type="text" name="description"/>
					</td>
				</tr>				

			</table>
				<br>
			<div align="center">
				<button type="submit">등록</button>
			</div>
		</form>	
	</div>	

</body>
</html>