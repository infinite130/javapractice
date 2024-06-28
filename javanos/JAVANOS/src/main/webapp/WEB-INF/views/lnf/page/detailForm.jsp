<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 조회 - 분실물 게시판</title>
</head>
<body>

	<jsp:include page="../../common/menubar.jsp"/>
	
	<h2 div align="center">게시글 조회</h2>
	<div align = "center">
		<table>
			<form action="${ pageContext.servletContext.contextPath }/lnf/detail" method="get">
			
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
		
		<div>
				<c:if test="${ sessionScope.loginMember.role eq 'ROLE_USER' }">
					<button onclick="location.href='${ pageContext.servletContext.contextPath }/lnf/modify?no=${ requestScope.notice.no }'">수정</button>
				</c:if>
				<c:if test="${ sessionScope.loginMember.role eq 'ROLE_USER' }">
					<button onclick="location.href='${ pageContext.servletContext.contextPath }/lnf/delete?no=${ requestScope.notice.no }'">삭제</button>
				</c:if>
		</div>

	</div>

	

</body>
</html>