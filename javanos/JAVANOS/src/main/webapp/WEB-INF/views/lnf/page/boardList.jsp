<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>분실물 게시판</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	
	<jsp:include page="../../common/menubar.jsp"/>
	
	<!-- 게시글 출력할 것 -->
	<h2 align = "center">분실물 게시판</h2>
	<div align = "center">
		<table>
			<tr>
				<th>#</th>
				<th>습득 호선</th>
				<th>습득 역</th>
				<th>분실 품목</th>
				<th>등록일</th>
				<th>발견일</th>
			</tr>
			<c:forEach items="${ boardList }" var="lnfBoard">
			<tr>
				<td><c:out value="${ lnfBoard.lnfNo }"/></td>
				<td><c:out value="${ lnfBoard.staNo.staLine }"/></td> <!-- 습득 호선 -->
				<td><c:out value="${ lnfBoard.staNo.staName }"/></td> <!-- 습득 역 -->
				<td><c:out value="${ lnfBoard.missing }"/></td> <!-- 분실 품목 -->
				<td><c:out value="${ lnfBoard.enrollDate }"/></td> <!-- 등록일 -->
				<td><c:out value="${ lnfBoard.findDate }"/></td> <!-- 발견일 -->
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
	
	<script>
		if(document.getElementsByTagName("td")) {
			const $tds = document.getElementsByTagName("td");
			for(let i = 0; i < $tds.length; i++) {
				
				/* $tds[i].onmouseenter = function() {
					this.parentNode.style.backgroundColor = "orangered";
					this.parentNode.style.cursor = "pointer";
				}
				
				$tds[i].onmouseout = function() {
					this.parentNode.style.backgroundColor = "black";
				} */
				
				$tds[i].onclick = function() {
					/* 게시물 번호까지 알아왔으니 이제 상세보기는 할 수 있겠지? */
					const no = this.parentNode.children[0].innerText;
					location.href = "${ pageContext.servletContext.contextPath }/lnf/detail?no=" + no;
				}
				
			}
			
		}

	</script>

</body>
</html>