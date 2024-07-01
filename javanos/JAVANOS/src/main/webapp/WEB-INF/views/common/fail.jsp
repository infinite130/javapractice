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
			case "communityUpdate":
				window.location.replace('${ pageContext.servletContext.contextPath }/community/detail?communityNo=${requestScope.communityNo}');
				break;
		}
	</script>
	
	<h1 align="center">${ requestScope.message }</h1>


</body>
</html>