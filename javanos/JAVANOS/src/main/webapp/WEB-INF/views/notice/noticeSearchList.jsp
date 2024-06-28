<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 검색 결과</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/notice/event.js"></script>

</head>
<body>

	<jsp:include page="../common/menubar.jsp" />

	<div class="outer outer-notice-list">
		<br>
		<h2 align="center">공지사항 검색 결과</h2>
		<div class="table-area">
			<table align="center" id="searchResultTable">
				<thead>
					<tr>
						<th>번호</th>
						<th width="300px">제목</th>
						<th width="100px">작성자</th>
						<th>조회수</th>
						<th width="100px">작성일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ searchResultList }" var="notice">
						<tr>
							<td><c:out value="${ notice.noticeNo }" /></td>
							<td><c:out value="${ notice.noticeTitle }" /></td>
							<td><c:out value="${ notice.noticeWriter.userNickname }" /></td>
							<td><c:out value="${ notice.noticeCount }" /></td>
							<td><c:out value="${ notice.noticeEnrollDate }" /></td>
						</tr>
					</c:forEach>
					<c:if test="${ empty searchResultList }">
						<tr>
							<td colspan="5" align="center">검색 결과가 없습니다.</td>
						</tr>
					</c:if>
				</tbody>
			</table>
		</div>
		<div class="search-area" align="center">
			<form id="searchForm"
				action="${pageContext.servletContext.contextPath}/notice/noticeSearchList"
				method="GET">
				<select id="searchCondition" name="searchCondition">
					<option value="title">제목</option>
					<option value="body">내용</option>
					<option value="titleAndBody">제목+내용</option>
				</select> <input type="search" name="keyword">
				<button type="submit">검색하기</button>
			</form>

			<c:if test="${ sessionScope.loginUser.userRole eq 'ROLE_ADMIN' }">
				<!-- 관리자인 경우에만 작성 버튼이 보여집니다. -->
				<button id="writeNotice">작성</button>
			</c:if>
		</div>
	</div>

</body>
</html>
