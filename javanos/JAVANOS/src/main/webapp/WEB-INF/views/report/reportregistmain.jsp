<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신고페이지</title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/report/reportregistmain.css">

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
        <form method="post" action="${pageContext.servletContext.contextPath}/RegistReport" onsubmit="prepareFormSubmission(); return validateForm();">
            <c:if test="${not empty sessionScope.loginUser}">
                <input type="hidden" name="userId" value="${sessionScope.loginUser.userId}">
            </c:if>
            <input type="hidden" name="communityNo" value="${param.communityNo}">
            <input type="hidden" name="reportedUserNo" value="${param.reportedUserNo}">
            <input type="hidden" id="actualCheck1" name="actualCheck1" value="">

            <label for="reportedUserId">신고하려는 ID:</label>
            <c:choose>
                <c:when test="${not empty requestScope.reportedUserNickname}">
                    <span id="reportedUserId">${requestScope.reportedUserNickname}</span><br> <!-- reportedUserNickname 값을 텍스트로 출력 -->
                </c:when>
                <c:otherwise>
                    <span id="reportedUserId">${param.reportedUserNo}</span><br> <!-- 초기에는 reportedUserNo 값을 텍스트로 출력 -->
                </c:otherwise>
            </c:choose>

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
