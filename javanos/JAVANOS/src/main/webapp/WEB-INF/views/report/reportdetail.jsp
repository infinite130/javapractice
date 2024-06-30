<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.javanos.project.report.model.dto.ReportDTO" %>

<%
    ReportDTO report = (ReportDTO) request.getAttribute("report");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신고 내역 상세보기</title>
<style>
    table {
        width: 50%;
        border-collapse: collapse;
        margin: 60px auto;
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
    <h1>신고 내역 상세보기</h1>
    <table>
        <tr>
            <th>신고한 회원</th>
            <td><%= report.getReportUser() != null ? report.getReportUser().getUserId() : "N/A" %></td>
        </tr>
<%--        <tr>
            <th>신고 게시글</th>
            <td><a href="${pageContext.servletContext.contextPath}/community/detail?communityNo=<%= report.getCommunityNo() != null ? report.getCommunityNo().getCommunityNo() : "N/A" %>">게시글 보기</a></td>
        </tr> --%>
        <tr>
            <th>신고일</th>
            <td><%= report.getReportDate() %></td>
        </tr>
        <tr>
            <th>신고사유</th>
            <td><%= report.getReportReason() %></td>
        </tr>
        <tr>
            <th>신고당한 회원</th>
            <td><%= report.getReportedUser() != null ? report.getReportedUser().getUserId() : "N/A" %></td>
        </tr>
    </table>
    <form method="post" action="${pageContext.servletContext.contextPath}/confirmReport">
        <input type="hidden" name="reportId" value="<%= report.getReportNo() %>">
        <input type="hidden" name="action" value="confirm">
        <button class="button" type="submit">계정정지</button>
    </form>
</div>

</body>
</html>