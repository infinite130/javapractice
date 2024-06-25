<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신고페이지</title>
<style>

</style>
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

    function redirectToCommunity() {
        window.location.href = "${pageContext.servletContext.contextPath}/community/list";
    }
</script>
</head>
<body>

     <%-- <jsp:include page="../common/menubar.jsp"/> --%> 
      
    <div class="container">

        <h1>신고페이지</h1><br>
        <form method="get" action="RegistReport">
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
                <input type="button" onclick="redirectToCommunity()" value="취소">
            </div>
        </form>
    </div>
</body>
</html>
