<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>분실물 게시판</title>
</head>
<body>

	<jsp:include page="../../common/menubar.jsp" />

	<div>
		<h2>분실물 찾기</h2>
		<br>

		<form action="${ pageContext.servletContext.contextPath }/lnf/main" method="get">

				<button type="submit">찾기</button>
				
		</form>
				
	</div>


	<div>
		<h2>분실물 등록하기</h2>
		<br>
		<form action="${ pageContext.servletContext.contextPath }/lnf/insert" method="get">
			
				<button type="submit">글쓰기</button>
			</div>
		</form>
	</div>

</body>
</html>