<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 수정</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/notice/noticeUpdateForm.css">
<script>
	// 취소 버튼 클릭 시 초기화 및 이동 처리
	function cancelAndMoveToList() {
		// 입력된 내용 초기화
		document.querySelector("form").reset();

		// 공지사항 전체 목록 페이지로 이동
		location.href = "${pageContext.servletContext.contextPath}/notice/list";
	}
</script>
</head>
<body>

	<%-- 공지사항 내용수정 화면 폼 --%>

	<jsp:include page="../common/menubar.jsp" />

	<div class="outer outer-notice-insert">
		<br>
		<h2 align="center">공지 사항 수정</h2>
		<div class="table-area">
			<form
				action="${ pageContext.servletContext.contextPath }/notice/update"
				method="post">

				<table>
					<tr>
						<td>번호</td>
						<td><input type="text" size="50" name="noticeNo"
							value="${ requestScope.notice.noticeNo }" readonly></td>
					</tr>
					<tr>
						<td>제목</td>
						<td><input type="text" size="50" name="title"
							value="${ requestScope.notice.noticeTitle }"></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td><input type="text"
							value="${ requestScope.notice.noticeWriter.userNickname }"
							name="writer" readonly></td>
					</tr>
					<tr>
						<td>내용</td>
					</tr>
					<tr>
						<td colspan="2"><textarea name="content" cols="60" rows="15"
								style="resize: none;"><c:out
									value="${ requestScope.notice.noticeBody }" /></textarea></td>
					</tr>
				</table>
				<br>
				<div align="center">
					<button id="cancleButton" type="button" onclick="cancelAndMoveToList()">취소</button>
					<button id="updateButton" type="submit">수정</button>
				</div>
			</form>
		</div>
	</div>

</body>
</html>