<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>습득 글 수정 - 분실물 게시판</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 20px;
        }
        .table-area {
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
            background-color: #f2f2f2; /* 밝은 회색 배경 */
            color: #333; /* 검은색 글자 */
        }
        input[type="text"], select, textarea {
            padding: 10px;
            font-size: 16px;
            border-radius: 5px;
            border: 1px solid #ccc;
            width: 100%;
            box-sizing: border-box; /* 내용 박스 크기를 포함한 전체 상자 크기 설정 */
        }
        input[type="date"], input[type="time"] {
            padding: 10px;
            font-size: 16px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }
        button {
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            cursor: pointer;
            margin-right: 10px;
            border-radius: 5px;
        }
        button:hover {
            background-color: #0056b3;
        }
        button[type="reset"] {
            background-color: #6c757d; /* 회색으로 변경 */
        }
        button[type="reset"]:hover {
            background-color: #5a6268; /* hover 시 더 짙은 회색으로 변경 */
        }
    </style>
    <script>
        function cancelAction() {
            window.location.href = "${pageContext.servletContext.contextPath}/lnf/first";
        }
    </script>
</head>
<body>

    <jsp:include page="../../common/menubar.jsp"/>

<div id="wrap">
    <section>
    <div>
        <br>
        <h2 align="center">게시판 수정</h2>
        <div class="table-area">
            <form action="${pageContext.servletContext.contextPath}/lnf/modify" method="post">
                <table>
                    <tr>
                        <td>호선</td>
                        <td>
                            <select name="staLine">
                                <option value="1호선">1호선</option>
                                <option value="2호선">2호선</option>
                                <option value="3호선">3호선</option>
                                <option value="4호선">4호선</option>
                                <option value="5호선">5호선</option>
                                <option value="6호선">6호선</option>
                                <option value="7호선">7호선</option>
                                <option value="8호선">8호선</option>
                                <option value="9호선">9호선</option>
                                <option value="경의중앙선">경의중앙선</option>
                                <option value="공항철도">공항철도</option>
                                <option value="수인분당선">수인분당선</option>
                            </select>
                        </td>
                        <td>역</td>
                        <td>
                            <input type="text" name="staName" value="${requestScope.detail.lnfStaName}">
                        </td>
                        <td>발견일</td>
                        <td>
                            <input type="date" name="findDate" value="${requestScope.detail.findDate}">
                        </td>
                        <td>발견 시간</td>
                        <td>
                            <input type="time" name="findTime" value="${requestScope.detail.findTime}">
                        </td>
                    </tr>
                    <tr>
                        <td>분실 품목</td>
                        <td colspan="3">
                            <input type="text" name="missing" style="width: 100%;" value="${requestScope.detail.missing}">
                        </td>
                        <td>보관 장소</td>
                        <td colspan="3">
                            <input type="text" name="keep" style="width: 100%;" value="${requestScope.detail.keep}">
                        </td>
                    </tr>
                    <tr>
                        <td>상세 설명</td>
                        <td colspan="7">
                            <textarea name="description" cols="100" rows="15" style="resize: none; width: 100%;">${requestScope.detail.description}</textarea>
                        </td>
                    </tr>
                </table>
                <br>
                <div align="center">
                    <button type="button" onclick="cancelAction()">취소</button>
                    <button type="submit">수정</button>
                </div>
            </form>
        </div>
    </div>
</section>
</div>

<jsp:include page="../../common/footer.jsp"/>

</body>
</html>
