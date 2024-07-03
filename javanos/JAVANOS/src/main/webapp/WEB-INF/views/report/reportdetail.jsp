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
        background-color: #f9f9f9;
        color: #333;
        margin: 0;
        padding: 0;
    }
    .container {
        max-width: 800px;
        margin: 40px auto;
        padding: 20px;
        background-color: #fff;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
        text-align: center;
    }
    h1 {
        margin-bottom: 20px;
        color: #333;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 20px;
    }
    table, th, td {
        border: 1px solid #ddd;
    }
    th, td {
        padding: 12px;
         text-align: center;
    }
    th {
        background-color: #f4f4f4;
        color: #555;
    }
    tr {
        transition: background-color 0.3s;
    }
    tr:hover {
        background-color: #f1f1f1;
    }
 .button-container {
        margin-top: 20px;
    }
    .button {
        padding: 10px 20px;
       /*  margin: 5px;
        border: 1px solid #ddd;
        background-color: #f1f1f1;
        cursor: pointer;
        transition: background-color 0.3s, color 0.3s; */
    }
    .button:hover {
        /* background-color: #ddd; */
    }
    .button:focus {
        outline: none;
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
        <input type="button" value="목록" class="button" onclick="location.href='${pageContext.servletContext.contextPath}/CheckBoard'">
    </div>
</div>

</body>
</html>
