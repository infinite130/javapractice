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
	<h2>분실물 게시판</h2>
	<div>
		<table>
			<tr>
				<th>#</th>
<!-- 				<th>습득 호선</th>
				<th>습득 역</th> -->
				<th>분실 품목</th>
				<th>등록일</th>
				<th>발견일</th>
			</tr>
			<c:forEach var="lnfBoard" items="${ requestScope.lnfBoardList }">
			<tr>
				<td><c:out value="${ lnfBoard.lnfNo }"/></td>
				<td><c:out value="${ lnfBoard.missing }"/></td>
				<td><c:out value="${ lnfBoard.enroll.date }"/></td>
				<td><c:out value="${ lnfBoard.find.date }"/></td>
			</tr>
			</c:forEach>
		</table>
	</div>
	
	
	
	<!-- 검색 -->
	<div class="search-area" align="center">
			<form id="loginForm" action="${ pageContext.servletContext.contextPath }/lnf/search" method="get">		
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

</body>
</html>