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
		alert('${ requestScope.message }');
		
		const code = '${ requestScope.code }';
		console.log(code);
		switch(code) {
				/* user 관련  */
			case "joinUser":
				window.location.replace('${ pageContext.servletContext.contextPath }/user/join');
				break;
			case "loginUser":
				window.location.replace('${ pageContext.servletContext.contextPath }/user/login');
				break;
			case "updateUser":
				window.location.replace('${ pageContext.servletContext.contextPath }/user/mypage');
				break;
			case "deleteUser":
				window.location.replace('${ pageContext.servletContext.contextPath }/user/mypage');
				break;
				
				
				/* 공지사항 관련  */
			case "insertNotice":
				window.location.replace('${ pageContext.servletContext.contextPath }/notice/list');
				break;
			case "updateNotice":
				window.location.replace('${ pageContext.servletContext.contextPath }/notice/list');
				break;
				
				
				/* 커뮤니티 관련 */
			case "insertCommunity":
				window.location.replace('${ pageContext.servletContext.contextPath }/community/list');
				break;
			case "updateCommunity":
				window.location.replace('${ pageContext.servletContext.contextPath }/community/detail?communityNo=${requestScope.communityNo}');
				break;
			case "deleteCommunity":
				window.location.replace('${ pageContext.servletContext.contextPath }/community/list');
				break;
				
				
				/* 분실물 관련 */
			case "enrollLnfBoard":
				window.location.replace('${ pageContext.servletContext.contextPath }/lnf/insert');
				break;

			case "modifyLnfBoard":
				window.location.replace('${ pageContext.servletContext.contextPath }/lnf/modify');
				break;

			case "deleteLnfBoard":
				window.location.replace('${ pageContext.servletContext.contextPath }/lnf/delete');
				break;

			case "searchLnfBoard":
				window.location.replace('${ pageContext.servletContext.contextPath }/lnf/search');
				break;

				
				
				
				
				/* 내려요 관련 */
				
				/* 신고 관련 */
				
				
		}
	</script>
	
</body>
</html>
