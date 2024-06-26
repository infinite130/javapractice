<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>분실물 게시판</title>
</head>
<body>
	
	<jsp:include page="../../common/menubar.jsp"/>
	
	<!-- 게시글 출력할 것 -->
	<div>
		<table>
			<tr>
				<th>#</th>
				<th>습득 호선</th>
				<th>습득 역</th>
				<th>분실 품목</th>
				<th>등록일</th>
				<th>발견일</th>
			</tr>
			<c:forEach var="lnfBoard" items="${ requestScope.boardList }">
			<tr>
				<td><c:out value="${ board.no }"/></td>
				<td><c:out value="${ board.sta.line }"/></td>
				<td><c:out value="${ board.sta.date }"/></td>
				<td><c:out value="${ board.missing }"/></td>
				<td><c:out value="${ board.enroll.date }"/></td>
				<td><c:out value="${ board.find.date }"/></td>
			</tr>
			</c:forEach>
		</table>
	</div>
	
	<!-- 검색 -->
	<div class="search-area" align="center">
			<form id="loginForm" action="${ pageContext.servletContext.contextPath }/board/main" method="get">		
			    <input type="hidden" name="currentPage" value="1">
			    <select id="searchCondition" name="searchCondition">
					<option value="missing" ${ requestScope.selectCriteria.searchCondition eq "missing"? "selected": "" }>분실 품목</option>
					<option value="staLine" ${ requestScope.selectCriteria.searchCondition eq "staLine"? "selected": "" }>역</option>
					<option value="staName" ${ requestScope.selectCriteria.searchCondition eq "staName"? "selected": "" }>호선</option>
				</select>
		        <input type="search" id="searchValue" name="searchValue" value="<c:out value="${ requestScope.selectCriteria.searchValue }"/>">

				<button type="submit">검색하기</button>
			</form>
		</div>
	</div>

</body>
</html>