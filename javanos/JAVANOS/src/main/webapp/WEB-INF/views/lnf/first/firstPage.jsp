<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>분실물 게시판</title>
    <style>
        body {
            line-height: 1.6;
            margin: 0;
            padding: 0;
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
            text-align: center; /* 가운데 정렬 */
        }
        .section {
            display: inline-block;
            width: 45%; /* 섹션 너비 조정 */
            margin: 10px;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #f9f9f9;
            text-align: center;
            vertical-align: top; /* 세로 정렬 위로 설정 */
        }
        h2 {
            margin-top: 0;
            padding-bottom: 10px;
            border-bottom: 1px solid #ccc;
        }
        form {
            margin-top: 10px;
        }
        button {
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            background-color: #007bff; /* 메뉴바 색상 대신 예시로 파란색 사용 */
            color: white;
            border: none;
            border-radius: 5px;
        }
        button:hover {
            background-color: #0056b3; /* 메뉴바 색상 대신 예시로 진한 파란색 사용 */
        }

        @media (max-width: 600px) {
            .section {
                width: 100%; /* 화면이 작을 때 섹션을 한 줄로 배치 */
            }
        }
    </style>
</head>
<body>

    <jsp:include page="../../common/menubar.jsp" />

    <div id = "wrap">
    <section>
    <div class="container">
        <div class="section">
            <h2>분실물 찾기</h2>
            <form action="${pageContext.servletContext.contextPath}/lnf/main" method="get">
                <button type="submit">찾기</button>
            </form>
        </div>

        <div class="section">
            <h2>분실물 등록하기</h2>
            <form action="${pageContext.servletContext.contextPath}/lnf/insert" method="get">
                <button type="submit">글쓰기</button>
            </form>
        </div>
    </div>
    </section>
    </div>

    <jsp:include page="../../common/footer.jsp"/>

</body>
</html>
