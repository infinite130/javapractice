<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신고페이지</title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/report/reportregistmain.css">
<style>
    #report-form-container {
        flex-direction: column;
        align-items: center;
        margin: 0;
        padding-top: 150px; /* 메뉴바 높이만큼 패딩 추가 */
        background-color: #f0f0f0;
    }

    #report-form-container .container {
        background-color: white;
        padding: 40px 150px; /* 위아래 패딩을 줄이고 좌우 패딩을 설정 */
        border-radius: 10px;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        text-align: center;
    }

    #report-form-container .container h1 {
        margin-bottom: 20px;
        color: #1E90FF;
    }

    #report-form-container .container form {
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    #report-form-container .container form label {
        display: flex;
        align-items: center;
        justify-content: flex-start;
        width: 100%;
        margin: 10px 0;
    }

    #report-form-container .container form label input[type="radio"] {
        margin-right: 10px;
    }

    #report-form-container .button-container {
        display: flex;
        justify-content: center;
        gap: 10px;
        width: 100%;
        margin-top: 20px;
    }

    #report-form-container .button-container input[type="submit"],
    #report-form-container .button-container input[type="button"] {
        margin: 5px;
        padding: 5px 10px;
        background-color: #1E90FF;
        color: white;
        border: none;
        border-radius: 5px;
        text-align: center;
    }

    #report-form-container .button-container input[type="submit"]:hover,
    #report-form-container .button-container input[type="button"]:hover {
        background-color: #1C86EE;
    }

    .hidden {
        display: none;
    }
</style>
<script>
    function toggleTextbox() {
        var textbox = document.getElementById("additionalText");
        var otherRadio = document.getElementById("otherRadio");
        if (otherRadio.checked) {
            textbox.classList.remove("hidden");
        } else {
            textbox.classList.add("hidden");
            textbox.value = ""; // 체크 해제 시 텍스트박스 내용 초기화
        }
    }

    function validateForm() {
        var checkboxes = document.getElementsByName("check1");
        var isChecked = false;
        var otherRadio = document.getElementById("otherRadio");
        var textbox = document.getElementById("additionalText");

        for (var i = 0; i < checkboxes.length; i++) {
            if (checkboxes[i].checked) {
                isChecked = true;
                break;
            }
        }

        if (!isChecked) {
            alert("체크박스 1개를 선택해주세요");
            return false; // 폼 제출을 막음
        }

        if (otherRadio.checked && textbox.value.trim() === "") {
            alert("기타 내용을 입력해주세요");
            return false; // 폼 제출을 막음
        }

        return true; // 폼 제출을 허용
    }

    function prepareFormSubmission() {
        var otherRadio = document.getElementById("otherRadio");
        var textbox = document.getElementById("additionalText");
        if (otherRadio.checked) {
            document.getElementById("actualCheck1").value = textbox.value;
        } else {
            var checkedRadio = document.querySelector('input[name="check1"]:checked');
            if (checkedRadio) {
                document.getElementById("actualCheck1").value = checkedRadio.value;
            }
        }
    }
</script>
</head>
<body>
<jsp:include page="../common/menubar.jsp"/>

<div id="report-form-container">
    <div class="container">
        <h1>신고페이지</h1><br>
        <form method="get" action="RegistReport" onsubmit="prepareFormSubmission(); return validateForm();">
            <!-- 로그인된 사용자 정보 확인 -->
            <c:if test="${not empty sessionScope.loginUser}">
                <input type="hidden" name="userId" value="${sessionScope.loginUser.userId}">
            </c:if>
            <input type="hidden" name="communityNo" value="${param.communityNo}">
            <input type="hidden" name="reportedUserId" value="${param.reportedUserId}">
            <input type="hidden" id="actualCheck1" name="actualCheck1" value="">
            <label>
                <input type="radio" name="check1" value="글 도배" onclick="toggleTextbox()"> 글 도배
            </label><br>
            <label>
                <input type="radio" name="check1" value="모욕적인 글 작성" onclick="toggleTextbox()"> 모욕적인 글 작성
            </label><br>
            <label>
                <input type="radio" name="check1" value="공지사항 위반" onclick="toggleTextbox()"> 공지사항 위반
            </label><br>
            <label>
                <input type="radio" name="check1" value="기타" id="otherRadio" onclick="toggleTextbox()"> 기타
            </label><br>
            <input type="text" id="additionalText" name="additionalText" class="hidden" placeholder="기타 내용을 입력하세요"><br>
            <div class="button-container">
                <input type="submit" value="신고">
                <input type="button" value="취소" onclick="location.href='${pageContext.servletContext.contextPath}/CancelReportServlet'">
            </div>
        </form>
    </div>
</div>
</body>
</html>
