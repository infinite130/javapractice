<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    body {
        font-family: Arial, sans-serif;
        background-color: #e8f5e9;
        color: #333;
    }
    table {
        width: 50%;
        border-collapse: collapse;
        margin: 60px auto;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }
    table, th, td {
        border: 1px solid #a5d6a7;
    }
    th, td {
        padding: 15px;
        text-align: left;
    }
    th {
        background-color: #81c784;
        color: white;
    }
    tr {
        background-color: white;
        transition: box-shadow 0.3s;
    }
    tr:hover {
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    }
    .container {
        text-align: center;
    }
    .button {
        margin-top: 20px;
        padding: 10px 20px;
        background-color: #4caf50;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        display: inline-block;
    }
    .button:hover {
        background-color: #388e3c;
    }
    .button-container {
        text-align: center;
        margin-top: 20px;
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
<tr>
    <th>신고된 글</th>
    <td>
        <% 
            if(report.getCommunityNo() != null) {
                int communityNo = report.getCommunityNo().getCommunityNo();
                String communityLink = request.getContextPath() + "/community/detail?communityNo=" + communityNo;
        %>
        <a href="<%= communityLink %>">신고된 글 보러가기</a>
        <% } else { %>
        N/A
        <% } %>
    </td>
</tr>

        <tr>
            <th>신고 처리 상태</th>
            <td><%= report.getReportStatus() %></td>
        </tr>
    </table>
    <div class="button-container">
        <form method="post" action="${pageContext.servletContext.contextPath}/banUser" style="display:inline;">
            <input type="hidden" name="reportNo" value="<%= report.getReportNo() %>">
            <input type="hidden" name="reportedUserNo" value="<%= report.getReportedUser() != null ? report.getReportedUser().getUserNo() : "" %>">
            <button class="button" type="submit">계정정지</button>
        </form>
        <form method="post" action="${pageContext.servletContext.contextPath}/reportdetail" style="display:inline;">
            <input type="hidden" name="reportId" value="<%= report.getReportNo() %>">
            <input type="hidden" name="action" value="delete">
            <button class="button" type="submit">삭제</button>
        </form>
    </div>
</div>

</body>
</html>
