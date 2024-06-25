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
        <th>작성자</th>
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
                    String userId = report[0];
                    String check1 = report[1];
                    String additionalText = report[2];
                    String currentDate = report[3];
    %>
    <tr>
        <td><%= index++ %></td>
        <td><%= userId %></td>
        <td><%= check1 %></td>
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
