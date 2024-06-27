<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JAVANOS</title>
</head>
<body>
<jsp:include page="../common/menubar.jsp"/>

<!-- 루트 URL에 접속할 때만 표시될 이미지 -->
<div class="main-image-container">
    <img src="${ pageContext.servletContext.contextPath }/resources/image/common/mainimage.png" alt="Main Image">
</div>

</body>
</html>
