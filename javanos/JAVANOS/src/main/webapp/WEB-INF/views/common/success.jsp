<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Javanos</title>
</head>
<body>
	<script>
		(function(){
			const successCode = "${ requestScope.successCode }";
			
			let successMessage = "";
			let movePath = "";
			
			switch(successCode){
				/* user 관련  */
				case "joinUser" : 
					successMessage = "회원가입에 성공하셨습니다.";
					movePath = "${ pageContext.servletContext.contextPath }";
					break;
				case "updateUser" : 
					successMessage = "정상적으로 수정되었습니다.";
					movePath = "${ pageContext.servletContext.contextPath }/user/mypage";
					break;
				case "deleteUser" : 
					successMessage = "탈퇴가 완료되었습니다.";
					movePath = "${ pageContext.servletContext.contextPath }";
					break;
					
					
					/* 공지사항 관련  */
				case "insertNotice" :
					successMessage = "정상적으로 등록되었습니다.";
					movePath = "${ pageContext.servletContext.contextPath }/notice/list";
					break;
					
				case "updateNotice" :
					successMessage = "정상적으로 수정되었습니다.";
					movePath = "${ pageContext.servletContext.contextPath }/notice/list";
					break;
					
					
					/* 커뮤니티 관련 */
				case "insertCommunity" :
					successMessage = "정상적으로 등록되었습니다.";
					movePath = "${ pageContext.servletContext.contextPath }/community/list";
					break;
				case "updateCommunity" :
					successMessage = "정상적으로 수정되었습니다.";
					movePath = "${ pageContext.servletContext.contextPath }/community/detail?communityNo=${requestScope.communityNo}";
					break;

				case "deleteCommunity" :
					successMessage = "정상적으로 삭제되었습니다.";
					movePath = "${ pageContext.servletContext.contextPath }/community/list";
					break;
					
					
					/* 분실물 관련 */
				case "enrollLnfBoard":
					successMessage = "정상적으로 등록되었습니다.";
					movePath = "${ pageContext.servletContext.contextPath }/lnf/insert";
					break;

				case "modifyLnfBoard":
					successMessage = "정상적으로 수정되었습니다.";
					movePath = "${ pageContext.servletContext.contextPath }/lnf/modify";
					break;

				case "deleteLnfBoard":
					successMessage = "정상적으로 삭제되었습니다.";
					movePath = "${ pageContext.servletContext.contextPath }/lnf/delete";
					break;

				case "searchLnfBoard":
					successMessage = "정상적으로 등록되었습니다.";
					movePath = "${ pageContext.servletContext.contextPath }/lnf/search";
					break;

					/* 내려요 관련 */
				case "downEnroll" :
					successMessage = "정상적으로 등록되었습니다.";
					movePath = "${ pageContext.servletContext.contextPath }/down/enroll";
					break;
					
					/* 신고 관련 */
				case "reportSubmitted":
					successMessage = "신고가 완료되었습니다.";
					movePath = "${ pageContext.servletContext.contextPath }/community/list";
					break;
			}

			alert(successMessage);
			
			location.replace(movePath);
		})();
	
	</script>
</body>
</html>
