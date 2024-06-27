<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JAVANOS</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/common.css">
</head>
<body>
<jsp:include page="../common/menubar.jsp"/>

<!-- home.jsp 페이지에 표시될 이미지 -->
<div class="home-image-container">
    <img src="${ pageContext.servletContext.contextPath }/resources/image/common/home.png" alt="Home Image">
</div>

</body>
</html>
