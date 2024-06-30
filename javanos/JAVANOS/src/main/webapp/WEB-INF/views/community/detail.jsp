<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티 게시글 상세보기</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/community/communityList.css">
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	
	<div class="button-area">
	    <c:if test="${ sessionScope.loginUser.userNo eq community.userNo }">
	        <button onclick="gomModifypage()">수정</button>
	        <button onclick="deletecommunity()">삭제</button>
	    </c:if>
	</div>
	
	<div class="table-area">
		<table>
	        <tr>
	            <td data-label="제목">제목</td>
	            <td colspan="3" data-label="제목 내용">${ community.communityTitle }</td>
	            <td data-label="조회수">조회수</td>
	            <td data-label="조회수 내용">${ community.communityCount }</td>
	        </tr>
	        <tr>
	            <td data-label="작성일">작성일</td>
	            <td colspan="3" data-label="작성일 내용">${ formattedDateTime }</td>
	            <td data-label="작성자">작성자</td>
	            <td data-label="작성자 내용">${ community.user.userNickname }</td>
	        </tr>
	        <tr>
	            <td data-label="사진">사진</td>
	            
	            <c:choose>
	            	<c:when test="${ not empty community.pictureList[0].thumbnailPath }">
	            		<td data-label="사진 내용" colspan="5">
			                <c:forEach items="${ community.pictureList }" var="picture">
			                        <img id="image" onerror="setDefaultImage(this);" src="${pageContext.servletContext.contextPath }${ picture.thumbnailPath }">
			                </c:forEach>
	                 	</td>
	            	</c:when>
	            	<c:when test="${ empty community.pictureList[0].thumbnailPath }">
	            		<td colspan="5">
	            			<label>첨부한 사진이 없습니다.</label>
	            		</td>
	            	</c:when>
	            </c:choose>
	        </tr>
	        <tr>
	            <td data-label="내용">내용</td>
	            <td colspan="5" data-label="내용 내용">${ community.communityBody }</td>
	        </tr>
    	</table>
    	
    	
    	<div>
			<c:choose>
				<c:when test="${ (sessionScope.loginUser.userRole eq 'ROLE_USER') && (!(sessionScope.loginUser.userNo eq community.userNo))}">
					<button id="reportBtn">신고</button>
				</c:when>
				<c:when test="${ sessionScope.loginUser.userRole eq 'ROLE_ADMIN' }">
					<button>계정정지</button>
				</c:when>
			</c:choose>
			<button id="listbtn" onclick="gotolist()">목록보기</button>
		</div>
	</div>
    
	
	<script>
		document.addEventListener('DOMContentLoaded', function() {
		    // 여기서 클릭 이벤트 설정
		    console.log("DOM이 로드되었습니다.");

		    let button = document.getElementById('reportBtn');
		    button.addEventListener('click', function() {
		        showreportpage();
		    });
		});
		
		
		function showreportpage() {
		    let communityNo = ${ community.communityNo };
		    let reportedUserId = ${ community.userNo };
			 alert(`communityNo: ${communityNo}, reportedUserId: ${reportedUserId}`);
		    
		    location.href = "${pageContext.servletContext.contextPath}/reportmain?communityNo=" + communityNo + "&reportedUserId=" + reportedUserId;
		}
	</script>
	
	
	<script>
	// 수정버튼 클릭했을 때 적용되는 함수
	function gomModifypage() {
		let communityNo = ${ community.communityNo }
		location.href="${pageContext.servletContext.contextPath}/community/update?communityNo="+ communityNo;
	};
	</script>
	
	<script>
		//삭제 버튼 클릭했을 때 적용되는 함수
		function deletecommunity() {
			let communityNo = ${ community.communityNo }
			location.href="${pageContext.servletContext.contextPath}/community/delete?communityNo="+ communityNo;
		}
	</script>
	
	<script>
	function gotolist() {
		location.href="${pageContext.servletContext.contextPath}/community/list";
	}
	</script>
	
	<script>
		function setDefaultImage(img) {
			console.log("파일을 등록하지 않았거나 파일의 경로를 찾을 수 없습니다.");
			img.onerror = null;
			img.src ='${pageContext.servletContext.contextPath}/resources/image/community/basicImage.png';
		};
    </script>
 	
	 
	
</body>
</html>