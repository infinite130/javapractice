<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티 게시글 상세보기</title>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	
	<c:if test="${ sessionScope.loginUser.userNo eq community.userNo }">
		<button onclick="gomModifypage()">수정</button>
			<button onclick="deletecommunity()">삭제</button>
	</c:if>
	
	<table>
		<tr>
			<td>제목: ${ community.communityTitle }</td>
			<td>조회수: ${ community.communityCount }</td>
		</tr>
		
		<tr>
			<td>작성일: ${ community.communityEnrollDate }</td>
			<td>작성자: ${ community.user.userNickname }</td>
		</tr>
		
		<tr>
			<c:if test="${ not empty community.pictureList[0].thumbnailPath }">
				<c:forEach items="${ community.pictureList }" var = "picture">
					<td>
						<img id="image" onerror="setDefaultImage(this);" width="250" height="180" src="${pageContext.servletContext.contextPath }${ picture.thumbnailPath }">
					</td>
				</c:forEach>
			</c:if>
		</tr>
		
		<tr>
			<td>내용: ${ community.communityBody }</td>
		</tr>
	</table>
	
	
	<c:choose>
		<c:when test="${ (sessionScope.loginUser.userRole eq 'ROLE_USER') && (!(sessionScope.loginUser.userNo eq community.userNo))}">
			<button>신고</button>
		</c:when>
		<c:when test="${ sessionScope.loginUser.userRole eq 'ROLE_ADMIN' }">
			<button>계정정지</button>
		</c:when>
	</c:choose>
	<button id="listbtn" onclick="gotolist()">목록보기</button>
	
	
	
	<script>
	// 수정버튼 클릭했을 때 적용되는 함수
	function gomModifypage() {
		let communityNo = ${ community.communityNo }
		location.href="${pageContext.servletContext.contextPath}/community/update?communityNo="+ communityNo;
	};
	</script>
	
	<script>
		//삭제 버튼 클릭했을 때 적용되는 함수
		function deletecommunity() {
			let communityNo = ${ community.communityNo }
			location.href="${pageContext.servletContext.contextPath}/community/delete?communityNo="+ communityNo;
		}
	</script>
	
	<script>
	function gotolist() {
		location.href="${pageContext.servletContext.contextPath}/community/list";
	}
	</script>
 	
	 
	
</body>
</html>