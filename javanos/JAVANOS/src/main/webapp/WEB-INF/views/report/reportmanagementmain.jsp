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
            background-color: #f9f9f9;
            color: #333;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 1200px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }
        h1 {
            text-align: center;
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
            text-align: center; /* Center align text in table cells */
        }
        th {
            background-color: #f4f4f4;
            color: #555;
        }
        tr {
            transition: background-color 0.3s;
            cursor: pointer;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        .pagination {
            display: flex;
            justify-content: center;
            padding: 10px 0;
        }
        .pagination a {
            margin: 0 5px;
            padding: 8px 16px;
            border: 1px solid #ddd;
            text-decoration: none;
            color: #333;
            transition: background-color 0.3s, color 0.3s;
        }
        .pagination a.active {
            background-color: #333;
            color: #fff;
        }
        .pagination a:hover:not(.active) {
            background-color: #ddd;
        }
    </style>
    <script>
        function goToDetail(reportNo) {
            location.href = '${pageContext.servletContext.contextPath}/reportdetail?reportNo=' + reportNo;
        }
    </script>
</head>
<body>
<jsp:include page="../common/menubar.jsp"/>
<div id="wrap">
<section>

<div class="content">
    <div class="container">
        <h1>신고 관리 페이지</h1>
        <table>
            <tr>
                <th>신고 번호</th>
                <th>신고 사유</th>
                <th>신고한 회원</th>
                <th>신고당한 회원</th>
                <th>신고 날짜</th>
            </tr>
            <c:forEach var="report" items="${reports}">
                <tr onclick="goToDetail('${report.reportNo}')">
                    <td>${report.reportNo}</td>
                    <td>${report.reportReason}</td>
                    <td><c:out value="${report.reportUser.userId}" /></td>
                    <td><c:out value="${report.reportedUser.userId}" /></td>
                    <td>${report.reportDate}</td>
                </tr>
            </c:forEach>
        </table>
        
        <jsp:include page="../common/paging.jsp">
            <jsp:param name="link" value="/CheckBoard" />
        </jsp:include>
        
    </div>
</div>
</section>
</div>

<jsp:include page="../common/footer.jsp" flush="false" />

</body>
</html>