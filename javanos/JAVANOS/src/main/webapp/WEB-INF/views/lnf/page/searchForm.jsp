<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>분실물 게시판</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            margin: 0;
            padding: 20px;
            background-color: #f0f0f0;
        }
        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        table, th, td {
            border: 1px solid #ddd;
            text-align: center;
        }
        th, td {
            padding: 10px;
        }
        th {
            background-color: #f2f2f2;
            color: #333;
        }
        .search-area {
            text-align: center;
            margin-bottom: 20px;
        }
        .search-area select, .search-area input[type="search"], .search-area button {
            padding: 10px;
            font-size: 16px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }
        .search-area button {
            cursor: pointer;
            background-color: #007bff;
            color: white;
            border: none;
            margin-left: 10px;
        }
        .search-area button:hover {
            background-color: #0056b3;
        }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

<jsp:include page="../../common/menubar.jsp"/>

<div id = "wrap">
<section>
<div class="container">
    <!-- 게시글 출력할 것 -->
    <h2 style="text-align: center;">분실물 게시판</h2>
    <table>
        <thead>
            <tr>
                <th>#</th>
                <th>습득 호선</th>
                <th>습득 역</th>
                <th>분실 품목</th>
                <th>등록일</th>
                <th>발견일</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${boardList}" var="lnfBoard">
                <tr style="cursor: pointer;">
                    <td>${lnfBoard.lnfNo}</td>
                    <td>${lnfBoard.lnfStaLine}</td> <!-- 습득 호선 -->
                    <td>${lnfBoard.lnfStaName}</td> <!-- 습득 역 -->
                    <td>${lnfBoard.missing}</td> <!-- 분실 품목 -->
                    <td>${lnfBoard.enrollDate}</td> 
                    <td>${lnfBoard.findDate}</td> 
                </tr>
            </c:forEach>
            <c:if test="${empty boardList}">
                <tr>
                    <td colspan="6" align="center">게시글이 없습니다.</td>
                </tr>
            </c:if>
        </tbody>
    </table>

    <!-- 검색 -->
    <div class="search-area">
        <form id="searchForm" action="${pageContext.servletContext.contextPath}/lnf/search" method="get">		
            <input type="hidden" name="currentPage" value="1">
            <select id="searchCondition" name="searchCondition">
                <option value="missing">분실 품목</option>
                <option value="staLine">습득 호선</option>
                <option value="staName">습득 역</option>
            </select>
            <input type="search" id="searchValue" name="keyword">
            <button type="submit">검색하기</button>
        </form>
    </div>
</div>
<%-- <jsp:include page="../../common/paging/jsp" flush="false">
	<jsp:param value="lnf/search" name="link"/>
</jsp:include> --%>
</section>
</div>

<script>
    $(document).ready(function() {
        $('table tbody tr').click(function() {
            const no = $(this).find('td:first').text();
            location.href = "${pageContext.servletContext.contextPath}/lnf/detail?no=" + no;
        });
    });
</script>

</body>
</html>
