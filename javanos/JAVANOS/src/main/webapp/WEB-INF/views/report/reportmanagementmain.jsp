<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List" %>
<%@ page import="com.javanos.project.report.model.dto.ReportDTO" %>
<%@ page import="com.javanos.project.user.model.dto.UserDTO" %>

<%
    List<ReportDTO> reports = (List<ReportDTO>) request.getAttribute("reports");
    if (reports != null) {
        for (ReportDTO report : reports) {
            System.out.println("Report No: " + report.getReportNo());
            System.out.println("Report User ID: " + (report.getReportUser() != null ? report.getReportUser().getUserId() : "null"));
            System.out.println("Reported User ID: " + (report.getReportedUser() != null ? report.getReportedUser().getUserId() : "null"));
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>신고 관리 페이지</title>
    <style>
        table {
            width: 80%;
            border-collapse: collapse;
            margin: 20px auto;
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
        .container {
            text-align: center;
        }
        .button {
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #1E90FF;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<jsp:include page="../common/menubar.jsp"/>

<div class="container">
    <h1>신고 관리 페이지</h1>
    <table>
        <tr>
            <th>신고 번호</th>
            <th>신고 사유</th>
            <th>신고 날짜</th>
            <th>신고자</th>
            <th>신고당한 회원</th>
            <th>상세 보기</th>
        </tr>
        <c:forEach var="report" items="${reports}">
            <tr>
                <td>${report.reportNo}</td>
                <td>${report.reportReason}</td>
                <td>${report.reportDate}</td>
                <td><c:out value="${report.reportUser.userId}" /></td>
                <td><c:out value="${report.reportedUser.userId}" /></td>
                <td><a href="reportdetail?reportNo=${report.reportNo}">상세 보기</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>