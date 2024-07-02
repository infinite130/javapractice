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
    <header>
    <!-- 로고 이미지 추가 및 링크 설정 -->
    <div class="logo-container">
        <a href="${ pageContext.servletContext.contextPath }">
            <img id="logoImg" src="${ pageContext.servletContext.contextPath }/resources/image/common/logo.png" alt="Logo">
        </a>
    </div>
        <div class="menu-area">
            <div class="nav-area">
                <ul>
                    <li><a href="${ pageContext.servletContext.contextPath }/home">소개</a></li>
                    <li><a href="${ pageContext.servletContext.contextPath }/down/enroll">내려요</a></li>
                    <li><a href="${ pageContext.servletContext.contextPath }/lnf/first">분실물</a></li>
                    <li><a href="${ pageContext.servletContext.contextPath }/community/list">커뮤니티</a></li>
                    <li><a href="${ pageContext.servletContext.contextPath }/notice/list">공지사항</a></li>
                    <c:choose>
                        <c:when test="${ empty sessionScope.loginUser }"> 
                            <li><a href="${ pageContext.servletContext.contextPath }/user/login">로그인</a></li>
                        </c:when>
                        <c:when test="${ sessionScope.loginUser.userRole eq 'ROLE_USER' }">
                            <li><a href="${ pageContext.servletContext.contextPath }/user/mypage">마이페이지</a></li>
                            <li><a href="${ pageContext.servletContext.contextPath }/user/logout">로그아웃</a></li>
                        </c:when>
                        <c:when test="${ sessionScope.loginUser.userRole eq 'ROLE_ADMIN' }">
                            <li><a href="${ pageContext.servletContext.contextPath }/CheckBoard">신고내역</a></li>
                            <li><a href="${ pageContext.servletContext.contextPath }/user/logout">로그아웃</a></li>
                        </c:when>
                    </c:choose>
                </ul>
            </div>
        </div>
    </header>
</body>
</html>
