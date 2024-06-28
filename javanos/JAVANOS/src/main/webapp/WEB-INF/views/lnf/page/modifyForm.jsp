<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정 - 분실물 게시판</title>
</head>
<body>

	<jsp:include page="../../common/menubar.jsp"/>
	
	<h2>게시글 수정</h2>
	<div align="center">
		<table>
		<form action="${ pageContext.servletContext.contextPath }/lnf/modify" method="post">
			<tr>
				<th>습득 호선</th>
				<th>습득 역</th>
				<th>발견일</th>
				<th>등록일</th>
				<th>분실 품목</th>
				<th>보관 장소</th>
				<th>상세 설명</th>
			</tr>
			<c:forEach items="${ boardList }" var="lnfBoard">
			<tr>
				<td><c:out value="${ lnfBoard.staNo.staLine }"/></td> <!-- 습득 호선 -->
				<td><c:out value="${ lnfBoard.staNo.staName }"/></td> <!-- 습득 역 -->
				<td><c:out value="${ lnfBoard.findDate }"/></td> <!-- 발견일 -->
				<td><c:out value="${ lnfBoard.enrollDate }"/></td> <!-- 등록일 -->
				<td><c:out value="${ lnfBoard.missing }"/></td> <!-- 분실 품목 -->
				<td><c:out value="${ lnfBoard.keep }"/></td> <!-- 분실 품목 -->
				<td><c:out value="${ lnfBoard.description }"/></td> <!-- 분실 품목 -->
			</tr>
			</c:forEach>
		</form>
		</table>
		
		<div align="center">
					<button type="reset" id="cancel">취소하기</button>
					<button type="submit">수정하기</button>
		</div>
		
	</div>

</body>
</html>