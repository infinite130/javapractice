<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계정 관리 게시판</title>
<style>
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 60px;
    }
    table, th, td {
        border: 1px solid black;
    }
    th, td {
        padding: 10px;
        text-align: left;
    }
    th {
        background-color: #f2f2f2;
    }
</style>
</head>
<body>
<jsp:include page="../common/menubar.jsp"/>

<h1>신고 내역</h1>

<table>
    <tr>
        <th>#</th>
        <th>신고한 회원</th>
        <th>신고당한 회원</th>
        <th>신고 내용</th>
        <th>등록일</th>
    </tr>
    <%
        Object reportsObj = application.getAttribute("reports");
        if (reportsObj instanceof List) {
            List<?> reportsList = (List<?>) reportsObj;
            int index = 1;
            for (Object reportObj : reportsList) {
                if (reportObj instanceof String[]) {
                    String[] report = (String[]) reportObj;
                    String userId = report[0]; // 신고한 회원 ID
                    String reportedUserId = report[1]; // 신고당한 회원 ID
                    String check1 = report[2];
                    String additionalText = report[3];
                    String currentDate = report[4];
                    String communityNo = report[5];
    %>
    <tr>
        <td><%= index++ %></td>
        <td><%= userId %></td>
        <td><%= reportedUserId %></td>
        <td><a href="${pageContext.servletContext.contextPath}/reportdetail?userId=<%= userId %>&reportedUserId=<%= reportedUserId %>&check1=<%= check1 %>&additionalText=<%= additionalText %>&currentDate=<%= currentDate %>"><%= check1 %></a></td>
        <td><%= currentDate %></td>
    </tr>
    <%
                }
            }
        }
    %>
</table>

</body>
</html>
