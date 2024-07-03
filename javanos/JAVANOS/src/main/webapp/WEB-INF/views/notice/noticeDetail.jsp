<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 상세정보</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/notice/noticeDetail.css">

</head>
<body>

	<%-- 공지사항 상세 내용 페이지 --%>

	<jsp:include page="../common/menubar.jsp" />
	<div class="outer outer-notice-detail">
		<br>
		<h2 align="center">공지 사항 내용</h2>
		<div class="table-area">
			<table>
				<tr>
					<td>제목</td>
					<td colspan="3"><p>
							<c:out value="${ requestScope.notice.noticeTitle }" />
						</p></td>
				</tr>
				<tr>
					<td>작성자</td>
					<%-- ${}: jsp에서 자바 객체의 필드나 속성 값을 출력할 때 사용함 --%>
					<td><p>
							<c:out value="${ requestScope.notice.noticeWriter.userNickname }" />
						</p></td>
					<td>작성일</td>
					<td><p>
							<c:out value="${ requestScope.notice.noticeEnrollDate }" />
						</p></td>
				</tr>
				<tr>
					<td>내용</td>
					<td colspan="3"><textarea
							style="resize: none; width: 90%; height: 200px;" readonly><c:out
								value="${ requestScope.notice.noticeBody }" /></textarea></td>
				</tr>
			</table>
			<br>
			<div align="center">
				<button id="listButton"
					onclick="location.href='${ pageContext.servletContext.contextPath }/notice/list'">목록</button>
				<%-- 조건문으로 관리자일때만 보이는 버튼 만듬 --%>
				<c:if test="${ sessionScope.loginUser.userRole eq 'ROLE_ADMIN' }">
					<%-- ?no=${requestScope.notice.no}: ?(쿼리문자열 시작을 의미), no=${}(key=value 형식의 파라미터값) --%>
					<%-- 따라서 ? 뒤는 사용자가 클릭한 버튼을 통해 해당 공지사항의 번호이고, 그 번호의 수정페이지로 이동함 --%>
					<button id="updateButton"
						onclick="location.href='${ pageContext.servletContext.contextPath }/notice/update?no=${ requestScope.notice.noticeNo }'">수정</button>
					<button id="deleteButton"
						onclick="deleteNotice(${ requestScope.notice.noticeNo })">삭제</button>
				</c:if>
			</div>
		</div>
	</div>

	<script>
    function deleteNotice(noticeNo) {
        if (confirm("정말로 삭제하시겠습니까?")) {
            location.href = "${ pageContext.servletContext.contextPath }/notice/delete?no=" + noticeNo;
        }
    }
</script>


</body>
</html>