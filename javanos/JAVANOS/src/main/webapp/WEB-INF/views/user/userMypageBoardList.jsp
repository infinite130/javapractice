<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Javanos</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<style>

.boardList-wrapper {
	 max-width: 800px;
    margin: 20px auto;
    padding: 20px;
    background-color: #fff;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.outer {
    max-width: 800px;
    margin: 20px auto;
    padding: 20px;
    background-color: #fff;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.outer h2 {
    text-align: center;
    margin-bottom: 20px;
}

.table-area {
    margin-bottom: 20px;
    text-align: center;
}

table {
    width: 100%;
    border-collapse: collapse;
    box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
    text-align: center;
}

table th, table td {
    padding: 10px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}

table th {
    background-color: #f2f2f2;
}

.hidden {
    display: none;
}

.search-area {
    margin-top: 20px;
}

.search-area form {
    display: flex;
    align-items: center;
    justify-content: center;
    margin-bottom: 10px;
}

.search-area select, .search-area input[type=search], .search-area button {
    margin: 0 5px;
    padding: 5px 10px;
    border: 1px solid #ccc;
    border-radius: 4px;
    font-size: 14px;
}

.search-area button {
    background-color: #007bff;
    color: #fff;
    border: none;
    cursor: pointer;
}

.search-area button:hover {
    background-color: #0056b3;
}

.search-area button[type=submit] {
    padding: 7px 20px;
}

button#listButton {
    background-color: #6c757d;
    color: #fff;
    border: none;
    padding: 5px 10px;
    margin-left: 10px;
    cursor: pointer;
}

button#listButton:hover {
    background-color: #5a6268;
}

button#writeNotice, button#writeNotice:hover {
    background-color: #28a745;
    color: #fff;
    border: none;
    padding: 5px 10px;
    cursor: pointer;
}

button#writeNotice:hover {
    background-color: #218838;
}

table tr:hover, table td:hover {
    cursor: pointer;
}

table tr:hover {
    background-color: #dbe6ff;
}

table tr {
    transition: background-color 0.3s;
}

table th:nth-child(2),
table td:nth-child(2) {
    width: 50%; 
}
</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	<div id="wrap">
	<section>
	<div class="boardList-wrapper">
	<h2 align="center">나의 게시글</h2>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>작성일</th>
		</tr>
		<!-- (LV.2 > ST.1) 1. EL, JSTL 활용해서 목록 현출되게 하기  -->
		<c:forEach items="${ communityList }" var="board">
			<tr onclick="showCommunityDeatil(${board.communityNo})">
				<td>${ board.communityNo }</td>
				<td width=500>${ board.communityTitle }</td>
				<td>${ board.user.userNickname }</td>
				<td>${ board.communityCount }</td>
				<td>${ board.communityEnrollDate }</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	<jsp:include page="../common/paging.jsp" flush="false">
		<jsp:param value="/user/mypage/list" name="link"/>
	</jsp:include>
	</section>
	</div>
	<jsp:include page="../common/footer.jsp"/>
	
	<script>
	function showCommunityDeatil(communityNo) {
		location.href="${pageContext.servletContext.contextPath}/community/detail?communityNo="+ communityNo;
	};
	</script>
	
</body>


</html>