<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .container {
        display: flex;
        flex-wrap: wrap;
    }

    .down-enroll {
        display: flex;
        flex-wrap: wrap;
        border: 2px solid #000;
        padding: 20px;
        border-radius: 10px;
        max-width: 800px;
        width: 100%;
    }

    .label-below {
        display: flex;
        flex-direction: column;
        width: 130px;
        margin-bottom: 20px;
    }

    .submit-button {
        width: 100%;
        display: flex;
        justify-content: flex-end;
        margin-top: 20px;
    }
    
    .submit-button button {
        width: 150px;
        height: 50px;
        font-size: 18px;
        border-radius: 30px;
        cursor: pointer;
    }

    .search {
        margin-left: 20px;
    }

    .search select {
        width: 200px; 
        font-size: 16px; 
        padding: 5px; 
        text-align: center; 
        text-align-last: center;
    }

</style>
</head>
<body>
    <jsp:include page="../common/menubar.jsp"/>
    <form action="${ pageContext.servletContext.contextPath }/down/enroll" method="post">
        <div class="container">
            <div class="down-enroll">
                <div class="label-below">
                    승차해 있는 역
                    <span><select name="inStationNo">
                        <option value="1">잠실역 </option>
                        <option value="2">잠실나루 </option>
                        <option value="3"> 잠실새내</option>
                    </select></span>
                </div>
                <div class="label-below">
                    하차 할 역이름
                    <span><select name="downStationNo">
                        <option value="1">잠실역 </option>
                        <option value="2">잠실나루 </option>
                        <option value="3"> 잠실새내</option>
                    </select></span>
                </div>
                <div class="label-below">
                    칸번호
                    <span><select name="downRoom">
                        <option>1-1</option>
                        <option>1-2</option>
                        <option>2-1</option>
                    </select></span>
                </div>
                <div class="label-below">
                    혼잡도
                    <span>
                        <input type="radio" name="downFull" value="상">상
                        <input type="radio" name="downFull" value="중">중
                        <input type="radio" name="downFull" value="하">하
                    </span>
                </div>
                <div class="submit-button">
                    <button type="submit">등록</button>
                </div>
            </div>
            <div class="search">
                <select name="stationsearch">
                    <option value="" selected>호선검색 필터</option>
                    <option value="1">2호선</option>
                    <option value="2">3호선</option>
                    <option value="3">4호선</option>
                </select>
            </div>
        </div>
        
        <%-- <c:forEach var="down" items="${ requestScope.downList }">
			<tr>
				<td><c:out value="${ down.downStationNo }"/></td>
				<td><c:out value="${ down.inStationNo }"/></td>
				<td><c:out value="${ down.downRoom }"/></td>
				<td><c:out value="${ down.downFull}"/></td>
				<td><c:out value="${ down.downEnrollDate}"/></td>
				<td><c:out value="${ down.user.userNickname}"/></td>
				
			</tr>
			</c:forEach>
				<jsp:include page="../common/paging.jsp"/> --%>
    </form>
    
</body>
</html>
