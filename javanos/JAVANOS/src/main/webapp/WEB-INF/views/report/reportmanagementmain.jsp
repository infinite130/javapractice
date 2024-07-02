<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List" %>
<%@ page import="com.javanos.project.report.model.dto.ReportDTO" %>
<%@ page import="com.javanos.project.common.paging.SelectCriteria" %>

<%
    List<ReportDTO> reports = (List<ReportDTO>) request.getAttribute("reports");
    SelectCriteria selectCriteria = (SelectCriteria) request.getAttribute("selectCriteria");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>신고 관리 페이지</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #e8f5e9;
            color: #333;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
            margin: 0;
        }
        .content {
            flex: 1;
        }
        table {
            width: 80%;
            border-collapse: collapse;
            margin: 20px auto;
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
        }
        .button:hover {
            background-color: #388e3c;
        }
        .pagination {
            text-align: center;
            margin-top: 20px;
        }
        .pagination a {
            margin: 0 5px;
            text-decoration: none;
            padding: 5px 10px;
            color: #4caf50;
            border: 1px solid #4caf50;
            border-radius: 3px;
        }
        .pagination a.active {
            background-color: #4caf50;
            color: white;
        }
        .pagination a:hover {
            background-color: #388e3c;
            border-color: #388e3c;
            color: white;
        }
        footer {
            background-color: #4caf50;
            color: white;
            text-align: center;
            padding: 10px 0;
            position: relative;
            bottom: 0;
            width: 100%;
        }
    </style>
</head>
<body>
<jsp:include page="../common/menubar.jsp"/>

<div class="content">
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
        
        <div class="pagination">
            <c:forEach begin="${selectCriteria.startPage}" end="${selectCriteria.endPage}" var="i">
                <a href="CheckBoard?currentPage=${i}" class="${i == selectCriteria.pageNo ? 'active' : ''}">${i}</a>
            </c:forEach>
        </div>
    </div>
</div>

<footer>
    <jsp:include page="../common/footer.jsp"/>
</footer>
</body>
</html>
