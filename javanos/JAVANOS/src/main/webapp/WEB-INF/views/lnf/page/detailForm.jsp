<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 조회 - 분실물 게시판</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 80%;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        table, th, td {
            border: 1px solid #ccc;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        button {
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            cursor: pointer;
            margin-right: 10px;
            border-radius: 5px;
        }

        button:hover {
            background-color: #0056b3;
        }

        button.delete {
            background-color: #dc3545;
        }

        button.delete:hover {
            background-color: #bd2130;
        }

        .center {
            text-align: center;
        }
    </style>
</head>
<body>

    <jsp:include page="../../common/menubar.jsp"/>

    <div class="container">
        <h2>게시글 조회</h2>

        <table>
            <tr>
                <td>호선</td>
                <td><c:out value="${requestScope.detail.lnfStaLine}"/></td>
            </tr>
            <tr>
                <td>역</td>
                <td><c:out value="${requestScope.detail.lnfStaName}"/></td>
            </tr>
            <tr>
                <td>발견일</td>
                <td><c:out value="${requestScope.detail.findDate}"/></td>
            </tr>
            <tr>
                <td>발견 시간</td>
                <td><c:out value="${requestScope.detail.findTime}"/></td>
            </tr>
            <tr>
                <td>분실 품목</td>
                <td><c:out value="${requestScope.detail.missing}"/></td>
            </tr>
            <tr>
                <td>보관 장소</td>
                <td><c:out value="${requestScope.detail.keep}"/></td>
            </tr>
            <tr>
                <td>상세 설명</td>
                <td><c:out value="${requestScope.detail.description}"/></td>
            </tr>
        </table>

        <div class="center">
            <button onclick="location.href='${pageContext.servletContext.contextPath}/lnf/main'">목록</button>

            <c:if test="${sessionScope.loginUser.userRole eq 'ROLE_USER' || sessionScope.loginUser.userRole eq 'ROLE_ADMIN'}">
    			<button onclick="location.href='${pageContext.servletContext.contextPath}/lnf/modify?no=${requestScope.detail.lnfNo}'">수정</button>
    			<button class="delete" onclick="deleteBoard(${requestScope.detail.lnfNo})">삭제</button>
			</c:if>
        </div>
    </div>

    <script>
        function deleteBoard(lnfNo) {
            if (confirm("정말로 삭제하시겠습니까?")) {
                location.href = "${pageContext.servletContext.contextPath}/lnf/delete?no=" + lnfNo;
            }
        }
    </script>
</body>
</html>
