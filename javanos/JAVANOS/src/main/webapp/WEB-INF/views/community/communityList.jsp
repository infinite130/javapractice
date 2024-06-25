<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티</title>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	<c:forEach items="${ communityList}" var="community">
		<div onclick="showCommunityDeatil(${community.communityNo})">
			<table>
				<tr>
					<td>사진 넣는 곳</td>
				</tr>
				<tr>
					<td><c:out value="${community.communityTitle}"></c:out></td>
				</tr>
			</table>
		</div>
	</c:forEach>
	
	<c:if test="${ sessionScope.loginUser.userRole eq 'ROLE_USER' }">
		<button onclick="insertcommunity()">등록</button>
	</c:if>
	
	<script>
		function showCommunityDeatil(communityNo) {
			location.href="${pageContext.servletContext.contextPath}/community/detail?communityNo="+ communityNo;
		};
	</script>
	
	<script>
	function insertcommunity() {
		location.href="${pageContext.servletContext.contextPath}/community/insert";
	};
	</script>
</body>
</html>