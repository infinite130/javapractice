<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="../../common/menubar.jsp"/>
	
	<h2>게시글 조회</h2>
	<div>
		<table div align="center">
		<form action="${ pageContext.servletContext.contextPath }/lnf/detail" method="get">
			<tr>
				<th>습득 호선</th>
				<th>습득 역</th>
				<th>발견일</th>
				<th>등록일</th>
			</tr>
			<tr>
				<th>분실 품목</th>
				<th>보관 장소</th>
			</tr>
			<tr>
				<th>상세 설명</th>
			</tr>
			<c:forEach var="lnfBoard" items="${ requestScope.lnfBoardList }">
			<tr>
				<td><c:out value="${ StaBoard.staLine }"/></td>
				<td><c:out value="${ StaBoard.StaName }"/></td>
				<td><c:out value="${ lnfBoard.find.date }"/></td>
				<td><c:out value="${ lnfBoard.enroll.date }"/></td>
			</tr>
			<tr>
				<td><c:out value="${ lnfBoard.missing }"/></td>
				<td><c:out value="${ lnfBoard.keep }"/></td>
			</tr>
			<tr>
				<td><c:out value="${ lnfBoard.description }"/></td>
			</tr>
			</c:forEach>
		</form>
		</table>
		
	<div div align="right">
		<form action="${ pageContext.servletContext.contextPath }/lnf/modify" method="get">
			<button type="modify">수정</button>
		</form>
		<form action="${ pageContext.servletContext.contextPath }/lnf/delete" method="get">
			<button type="delete">삭제</button>
		</form>
	</div>
	</div>

	

</body>
</html>