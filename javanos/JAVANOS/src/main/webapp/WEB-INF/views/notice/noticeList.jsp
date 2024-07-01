<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 목록</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/notice/noticeList.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/notice/event.js"></script>

<script>

	// JavaScript로 작성 버튼 클릭 이벤트 처리
	window.onload = function() {
		// 작성 버튼 클릭 시 작성 페이지로 이동
		const writeButton = document.getElementById("writeNotice");
		if (writeButton) {
			writeButton.onclick = function() {
				location.href = "${pageContext.servletContext.contextPath}/notice/insert";
			}
		}

		// 각 공지사항 행 클릭 시 상세보기 페이지로 이동
		const noticeRows = document.querySelectorAll("#listArea tr");
		noticeRows
				.forEach(function(row) {
					row.onclick = function() {
						const noticeNo = this.cells[1].innerText.trim(); // 두 번째 셀의 텍스트(공지번호)
						location.href = "${pageContext.servletContext.contextPath}/notice/detail?no="
								+ noticeNo;
					};
				});

		
		// 검색하기 버튼 클릭 이벤트 처리
		const searchButton = document.querySelector("button[type=submit]");
        if (searchButton) {
            searchButton.onclick = function() {
                const searchCondition = document.getElementById("searchCondition").value;
                const keyword = document.querySelector("input[type=search]").value;
                
                // AJAX를 이용하여 서버에 검색 요청 보내기
                fetchSearchResults(searchCondition, keyword);
			};
		}
        
        
        // 목록 버튼 클릭 시 전체 공지사항 목록 페이지로 이동
        const listButton = document.getElementById("listButton");
        if (listButton) {
            listButton.onclick = function() {
                location.href = "${pageContext.servletContext.contextPath}/notice/list";
            }
        }
        
	};
	
	function fetchSearchResults(searchCondition, keyword) {
        const url = "${pageContext.servletContext.contextPath}/notice/noticeSearchList";
        const params = `searchCondition=${searchCondition}&keyword=${keyword}`;

        fetch(url + "?" + params)
            .then(response => response.json())
            .then(data => {
                // 검색 결과를 받아서 처리할 코드
                renderSearchResults(data);
            })
            .catch(error => {
                console.error('Error:', error);
            });
    }

    function renderSearchResults(noticeList) {
        const tableBody = document.querySelector("#listArea tbody");
        tableBody.innerHTML = ""; // 기존 목록 초기화

        noticeList.forEach(function(notice) {
            const row = document.createElement("tr");
            row.innerHTML = `
                <td>${notice.noticeNo}</td>
                <td>${notice.noticeTitle}</td>
                <td>${notice.noticeWriter.userNickname}</td>
                <td>${notice.noticeCount}</td>
                <td>${notice.noticeEnrollDate}</td>
            `;
            tableBody.appendChild(row);
        });
    }
</script>
</head>
<body>


	<jsp:include page="../common/menubar.jsp" />
	<div id="wrap">
		<section>

			<div class="outer outer-notice-list">
				<br>
				<h2 align="center">공지사항</h2>
				<div class="table-area">
					<table align="center" id="listArea">
						<tr align="center">
							<th>번호</th>
							<th class="hidden number-cell">pk번호</th>
							<th width="300px">제목</th>
							<th width="100px">작성자</th>
							<th width="100px">작성일</th>
							<th>조회수</th>
						</tr>
						<c:forEach items="${ noticeList }" var="notice" varStatus="loop">
							<tr>
								<td>${loop.index + 1}</td>
								<td class="hidden number-cell"><c:out
										value="${ notice.noticeNo }" /></td>
								<td><c:out value="${ notice.noticeTitle }" /></td>
								<td><c:out value="${ notice.noticeWriter.userNickname }" /></td>
								<td><c:out value="${ notice.noticeEnrollDate }" /></td>
								<td><c:out value="${ notice.noticeCount }" /></td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<div class="search-area" align="center">
					<form
						action="${pageContext.request.contextPath}/notice/noticeSearchList"
						method="GET">
						<select id="searchCondition" name="searchCondition">
							<option value="title">제목</option>
							<option value="body">내용</option>
							<option value="titleAndBody">제목+내용</option>
						</select> <input type="search" name="keyword">
						<button type="submit">검색하기</button>
					</form>

					<!-- 목록 버튼 추가 -->
					<button id="listButton">목록</button>


					<!-- 관리자인 경우에만 작성 버튼이 보여집니다. -->
					<c:if test="${ sessionScope.loginUser.userRole eq 'ROLE_ADMIN' }">
						<button id="writeNotice">작성</button>
					</c:if>
				</div>
			</div>
			<jsp:include page="../common/paging.jsp" flush="false">
				<jsp:param value="/notice/list" name="link"/>
			</jsp:include>
		</section>
	</div>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>

