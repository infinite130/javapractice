<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script></head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	
	<c:if test="${ sessionScope.loginUser.userRole eq 'ROLE_USER' }">
		<button onclick="insertcommunity()">등록</button>
	</c:if>
	
	<c:forEach items="${ communityList }" var="community">
		<div onclick="showCommunityDeatil(${community.communityNo})">
			<div class="title-img-area" id="titleImgArea">
				<img id="titleImgView" onerror="setDefaultImage(this);" width="350" height="200" src="${pageContext.servletContext.contextPath }${ community.pictureList[0].thumbnailPath }">
			</div>
			<p>
				<c:out value="${community.communityTitle}"></c:out>
				<label>조회수 </label><c:out value="${community.communityCount }"></c:out>
			</p>

		</div>
	</c:forEach>
	
	
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
		function setDefaultImage(_img) {
			console.log("파일을 등록하지 않았거나 파일의 경로를 찾을 수 없습니다.");
           $(_img).onerror = null;
           $(_img).attr('src','${pageContext.servletContext.contextPath}/resources/image/community/basicImage.png');
		};
    </script>
	
	
</body>
</html>