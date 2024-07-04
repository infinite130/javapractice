<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Javanos</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/user/userJoinForm.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
 	<jsp:include page="../common/menubar.jsp"/> 
 	<div id="wrap">
	<section>

	<div class="join-wrapper">
		<h2>Sign Up</h2>
		<form action="${ pageContext.servletContext.contextPath }/user/join" method="post" id="join-form">
			<input type="text" name="userId" id="userId" placeholder="*아이디" ><br>
			<span id="userIdType" class="message"></span><br>
			
			<input type="password" name="userPwd" id="userPwd" placeholder="*비밀번호" ><br>
			<span id="userPwdType" class="message"></span><br>
			
			<input type="password" name="userPwdCheck" id="userPwdCheck" placeholder="*비밀번호 확인" ><br>
			<span id="userPwdCheckType" class="message"></span><br>
			
			<input type="text" name="userName" id="userName" placeholder="*이름" ><br>
			<span id="userNameType" class="message"></span><br>
			
			<input type="text" name="userNickname" id="userNickname" placeholder="*닉네임" ><br>
			<span id="userNicknameType" class="message"></span><br>
			
			<input type="email" name="userEmail" id="userEmail" placeholder="*이메일" ><br>
			<span id="userEmailType" class="message"></span><br>
			
			<label for="agreeTerms" class="agree-container">
				<input type="checkbox" id="agreeTerms" name="agreeTerms" >
				이용약관과 개인정보 수집 및 정보이용에 동의합니다
			</label><br>
			<span id="agreeTermsType" class="message"></span><br>
			
			<input type="submit" id="joinBtn" value="회원가입"><br>
		</form>
	</div>
	</section>
	</div>
	<jsp:include page="../common/footer.jsp"/>
	
	<script>
		$(document).ready(function() {
			
			// 아이디 입력 필드 실시간 유효성 검사
		    $("#userId").on('input', function() {
		        validateUserId();
		    });

		    // 비밀번호 입력 필드 실시간 유효성 검사
		    $("#userPwd").on('input', function() {
		        validateUserPwd();
		    });

		    // 비밀번호 확인 입력 필드 실시간 유효성 검사
		    $("#userPwdCheck").on('input', function() {
		        validateUserPwdCheck();
		    });

		    // 이름 입력 필드 실시간 유효성 검사
		    $("#userName").on('input', function() {
		        validateUserName();
		    });

		    // 닉네임 입력 필드 실시간 유효성 검사
		    $("#userNickname").on('input', function() {
		        validateUserNickname();
		    });

		    // 이메일 입력 필드 실시간 유효성 검사
		    $("#userEmail").on('input', function() {
		        validateUserEmail();
		    });

		    // 이용약관 동의 체크박스 실시간 유효성 검사
		    $("#agreeTerms").on('change', function() {
		        validateAgreeTerms();
		    });

		    // 폼 제출 시 유효성 검사
		    $("#join-form").submit(function(event) {
		        let isValid = true;

		        validateUserId();
		        validateUserPwd();
		        validateUserPwdCheck();
		        validateUserName();
		        validateUserNickname();
		        validateUserEmail();
		        validateAgreeTerms();

		        // 모든 입력 필드 유효성 검사
		        // message 요소가 'invalid' 클래스를 가지고 있는지 확인
		        $(".message").each(function() {		 
		            if ($(this).hasClass('invalid')) { 
		                isValid = false;	// 유효성 검사 실패
		                return false; 		// 유효성 검사 실패 시 바로 종료
		            }
		        });

		        if (!isValid) {
		            event.preventDefault();
		        }
		    });

		    // 아이디 유효성 검사 함수
		    function validateUserId() {
		        let userIdPattern = /^[a-z0-9_]{6,12}$/;
		        let userId = $("#userId").val().trim();

		        if (userId === "") {
		            $("#userIdType").text("아이디는 필수입니다.").removeClass('valid').addClass('invalid');
		        } else if (userIdPattern.test(userId)) {
		            dupCheckUserId(userId);
		        } else {
		            $("#userIdType").text("아이디는 6~12자의 영문 소문자, 숫자, 특수기호(_) 만 사용 가능합니다.").removeClass('valid').addClass('invalid');
		        }
		    }
		    
		 	// 아이디 중복 체크 함수
		    function dupCheckUserId(userId) {
		        $.ajax({
		            url: "${ pageContext.servletContext.contextPath }/user/check-id",
		            type: "post",
		            data: {userId: userId},
		            success: function(data) {
		                if (data.trim() === 'pass') {
		                    $("#userIdType").text("사용 가능한 ID 입니다.").removeClass('invalid').addClass('valid');
		                } else {
		                    $("#userIdType").text("이미 사용 중인 ID 입니다.").removeClass('valid').addClass('invalid');
		                }
		            },
		            error: function(error) {
		                $("#userIdType").text("아이디 확인 중 오류가 발생하였습니다.").removeClass('valid').addClass('invalid');
		            }
		        });
		    }

		    // 비밀번호 유효성 검사 함수
		    // 특수문자(!@#$%^&*?_) 가능
		    function validateUserPwd() {
 		        /* let userPwdPattern = /^(?=.*[A-Za-z])(?=.*\d)|(?=.*[A-Za-z])(?=.*[!@#$%^&*?_])|(?=.*\d)(?=.*[!@#$%^&*?_])[A-Za-z\d!@#$%^&*?_]{8,16}$/; */
 		        let userPwdPattern = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*?_])[A-Za-z\d!@#$%^&*?_]{8,16}$/;
		        let userPwd = $("#userPwd").val().trim();

		        if (userPwd === "") {
		            $("#userPwdType").text("비밀번호는 필수입니다.").removeClass('valid').addClass('invalid');
		        } else if (userPwdPattern.test(userPwd)) {
		            $("#userPwdType").text("사용할 수 있는 비밀번호 형식입니다.").removeClass('invalid').addClass('valid');
		        } else {
		            $("#userPwdType").text("비밀번호는 8~16자의 영문자, 숫자, 특수문자를 모두 포함해야합니다.").removeClass('valid').addClass('invalid');
		        }
		    }

		    // 비밀번호 확인 유효성 검사 함수
		    function validateUserPwdCheck() {
		        let userPwd = $("#userPwd").val().trim();
		        let userPwdCheck = $("#userPwdCheck").val().trim();

		        if (userPwdCheck === "") {
		            $("#userPwdCheckType").text("비밀번호 확인은 필수입니다.").removeClass('valid').addClass('invalid');
		        } else if (userPwd === userPwdCheck) {
		            $("#userPwdCheckType").text("비밀번호가 일치합니다.").removeClass('invalid').addClass('valid');
		        } else {
		            $("#userPwdCheckType").text("비밀번호가 일치하지 않습니다.").removeClass('valid').addClass('invalid');
		        }
		    }

		    // 이름 유효성 검사 함수
		    function validateUserName() {
		        let userNamePattern = /^[가-힣a-zA-Z]{2,15}$/;
		        let userName = $("#userName").val().trim();

		        if (userName === "") {
		            $("#userNameType").text("이름은 필수입니다.").removeClass('valid').addClass('invalid');
		        } else if (userNamePattern.test(userName)) {
		            $("#userNameType").text("").removeClass('invalid').addClass('valid');
		        } else {
		            $("#userNameType").text("이름은 2~15자의 한글 또는 영문자만 입력 가능합니다.").removeClass('valid').addClass('invalid');
		        }
		    }

		    // 닉네임 유효성 검사 함수
		    function validateUserNickname() {
		        let userNicknamePattern = /^[가-힣a-zA-Z0-9]{2,15}$/;
		        let userNickname = $("#userNickname").val().trim();

		        if (userNickname === "") {
		            $("#userNicknameType").text("닉네임은 필수입니다.").removeClass('valid').addClass('invalid');
		        } else if (userNicknamePattern.test(userNickname)) {
		            dupCheckUserNickname(userNickname);
		        } else {
		            $("#userNicknameType").text("닉네임은 2~15자의 한글, 영문자, 숫자만 사용 가능합니다.").removeClass('valid').addClass('invalid');
		        }
		    }
		    
		 	// 닉네임 중복 체크 함수
		    function dupCheckUserNickname(userNickname) {
		        $.ajax({
		            url: "${ pageContext.servletContext.contextPath }/user/check-nickname",
		            type: "post",
		            data: {userNickname: userNickname},
		            success: function(data) {
		                if (data.trim() === 'pass') {
		                    $("#userNicknameType").text("사용 가능한 닉네임입니다.").removeClass('invalid').addClass('valid');
		                } else {
		                    $("#userNicknameType").text("이미 사용 중인 닉네임입니다.").removeClass('valid').addClass('invalid');
		                }
		            },
		            error: function(error) {
		                $("#userNicknameType").text("닉네임 확인 중 오류가 발생하였습니다.").removeClass('valid').addClass('invalid');
		            }
		        });
		    }

		    // 이메일 유효성 검사 함수
		    function validateUserEmail() {
		    	// ([-_.]?) 하나가 있을 수도 있고 없을 수도 있음
		    	// * 이 패턴이 0번 이상 반복될 수 있음
		        let userEmailPattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
		        let userEmail = $("#userEmail").val().trim();

		        if (userEmail === "") {
		            $("#userEmailType").text("이메일은 필수입니다.").removeClass('valid').addClass('invalid');
		        } else if (userEmailPattern.test(userEmail)) {
		            dupCheckUserEmail(userEmail);
		        } else {
		            $("#userEmailType").text("유효하지 않은 이메일 형식입니다.").removeClass('valid').addClass('invalid');
		        }
		    }
		    
		 	// 이메일 중복 체크 함수
		    function dupCheckUserEmail(userEmail) {
		        $.ajax({
		            url: "${ pageContext.servletContext.contextPath }/user/check-email",
		            type: "post",
		            data: {userEmail: userEmail},
		            success: function(data) {
		                if (data.trim() === 'pass') {
		                    $("#userEmailType").text("사용 가능한 이메일입니다.").removeClass('invalid').addClass('valid');
		                } else {
		                    $("#userEmailType").text("이미 사용 중인 이메일입니다.").removeClass('valid').addClass('invalid');
		                }
		            },
		            error: function(error) {
		                $("#userEmailType").text("이메일 확인 중 오류가 발생하였습니다.").removeClass('valid').addClass('invalid');
		            }
		        });
		    }

		    // 이용약관 동의 유효성 검사 함수
		    function validateAgreeTerms() {
		        if (!$("#agreeTerms").is(":checked")) {
		            $("#agreeTermsType").text("이용약관에 동의해야 합니다.").removeClass('valid').addClass('invalid');
		        } else {
		            $("#agreeTermsType").text("").removeClass('invalid')
		        }
		    }
		});
		
	</script>
</body>
</html>