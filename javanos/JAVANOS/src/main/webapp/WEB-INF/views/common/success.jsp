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
