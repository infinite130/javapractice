<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/common.css">

</head>
<body>
<div class="header">
		<div class="menu-area">
			<div class="nav-area">
				<c:if test="${ empty sessionScope.loginMember }">
					<ul>
					<li><a href="">home</a></li>
					<li><a href="">내려요</a></li>
					<li><a href="">분실물</a></li>
					<li><a href="">커뮤니티</a></li>
					<li><a href="">공지사항</a></li>
					<li><a href="">로그인</a></li>
					</ul>
				</c:if>
				
				<c:if test="${ !empty sessionScope.loginMember }">
				<ul>
					<li><a href="">home</a></li>
					<li><a href="">내려요</a></li>
					<li><a href="">분실물</a></li>
					<li><a href="">커뮤니티</a></li>
					<li><a href="">공지사항</a></li>
					<li><a href="">마이페이지</a></li>
					<li><a href="">로그아웃</a></li>
					</ul>
				</c:if>
				
				<c:if test="${ sessionScope.loginMember.role eq 'ROLE_ADMIN' }">
				<ul>
					<li><a href="">home</a></li>
					<li><a href="">내려요</a></li>
					<li><a href="">분실물</a></li>
					<li><a href="">커뮤니티</a></li>
					<li><a href="">공지사항</a></li>
					<li><a href="">신고내역</a></li>
					<li><a href="">로그아웃</a></li>
					</ul>
				</c:if>
			</div>
		</div>
</body>
</html>