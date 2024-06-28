<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/community/communityList.css">
<body>	
	<jsp:include page="../common/menubar.jsp"/>
	
	<div class="outer-community-list">
		<br>
		<h2 align="center">커뮤니티 게시판</h2>
		<br>
		<div class="community-list-area" >
			<c:if test="${ sessionScope.loginUser.userRole eq 'ROLE_USER' }">
				<button onclick="insertcommunity()">등록</button>
			</c:if>
			<c:forEach items="${ communityList }" var="community">
				<div class= "list-bar" onclick="showCommunityDeatil(${community.communityNo})">
					<div class="title-img-area" id="titleImgArea">
						<img id="titleImgView" onerror="setDefaultImage(this);" src="${pageContext.servletContext.contextPath }${ community.pictureList[0].thumbnailPath }">
					</div>
					
					<div id="communityTitleArea">
						<c:out value="${community.communityTitle}"></c:out>
					</div>
					
					<p>
						<label>조회수 </label>
						<c:out value="${community.communityCount }"></c:out>
					</p>
				</div>
			</c:forEach>
		
		
		
		</div>
	
	
	
	
	
	</div>
	
	
	
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
	
	<script>
		function setDefaultImage(img) {
			console.log("파일을 등록하지 않았거나 파일의 경로를 찾을 수 없습니다.");
			img.onerror = null;
			img.src ='${pageContext.servletContext.contextPath}/resources/image/community/basicImage.png';
		};
    </script>
	
	
</body>
</html>