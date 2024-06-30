<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <select name="stationsearch" onchange="filterStations(this)">
                    <option value="" selected>호선검색 필터</option>
                    <option value="2호선" ${ requestScope.selectCriteria.searchValue eq "2호선"? "selected": "" }>2호선</option>
                    <option value="3호선" ${ requestScope.selectCriteria.searchValue eq "3호선"? "selected": "" }>3호선</option>
                    <option value="4호선" ${ requestScope.selectCriteria.searchValue eq "4호선"? "selected": "" }>4호선</option>
                    <script>
                       function filterStations(selectElement) {
                             var selectedValue = selectElement.value;
                             if (selectedValue) {
                 // 필터링 기능 수행 
             window.location.href = '${ pageContext.servletContext.contextPath }/down/enroll?searchCondition=line&searchValue=' + selectedValue;
                     }
                    }
                </script>
                </select>
            </div>
        </div>
    </form>                 <!--dto=down  -->
             <c:forEach var="down" items="${ requestScope.downList }">
			<div>
				<span><c:out value="${ down.downStation.staName }"/></span>
				<span><c:out value="${ down.inStation.staName }"/></span>
				<span><c:out value="${ down.downRoom }"/></span>
				<span><c:out value="${ down.downFull}"/></span>
				<span><c:out value="${ down.downEnrollDate}"/></span>
				<span><c:out value="${ down.user.userNickname}"/></span>
					<%-- <span><c:out value="${ sessionScope.loginUser.userNo}"/></span>
					<span><c:out value="${ down.user.userNo}"/></span> --%>
				
				 <c:if test="${ sessionScope.loginUser.userNo eq down.user.userNo }">
				<span><button onclick="deleteDown(${down.downNo})">삭제</button></span>
					    </c:if>
			</div>
			</c:forEach>
			
			
			<!-- 페이징 처리  -->
			<div class="pagingArea" align="center">
		<!-- 맨 앞으로 이동 버튼 -->
	    <button id="startPage"><<</button>
		
		<!-- 이전 페이지 버튼 -->
		<c:if test="${ requestScope.selectCriteria.pageNo <= 1 }">
			<button disabled><</button>
		</c:if>
		<c:if test="${ requestScope.selectCriteria.pageNo > 1 }">
			<button id="prevPage"><</button>
		</c:if>
		
		<!-- 숫자 버튼 -->
		<c:forEach var="p" begin="${ requestScope.selectCriteria.startPage }" end="${ requestScope.selectCriteria.endPage }" step="1">
			<c:if test="${ requestScope.selectCriteria.pageNo eq p }">
				<button disabled><c:out value="${ p }"/></button>
			</c:if>
			<c:if test="${ requestScope.selectCriteria.pageNo ne p }">
				<button onclick="pageButtonAction(this.innerText);"><c:out value="${ p }"/></button>
			</c:if>
		</c:forEach>
		
		<!-- 다음 페이지 버튼 -->
		<c:if test="${ requestScope.selectCriteria.pageNo >= requestScope.selectCriteria.maxPage }">
			<button disabled>></button>
		</c:if>
		<c:if test="${ requestScope.selectCriteria.pageNo < requestScope.selectCriteria.maxPage }">
			<button id="nextPage">></button>
		</c:if>
		
		<!-- 마지막 페이지로 이동 버튼 -->
		<button id="maxPage">>></button> 
	</div>
	
	<script>
	  //삭제버튼 클릭시 적용되는 함수 
		function deleteDown(downNo) {
			location.href="${pageContext.servletContext.contextPath}/down/delete?downNo="+ downNo;
		}
	  
	  //페이징 처리 함수 
		const link = "${ pageContext.servletContext.contextPath }/down/enroll";
		let searchText = "";
		
		if(${ !empty requestScope.selectCriteria.searchCondition? true: false }) {
			searchText += "&searchCondition=${ requestScope.selectCriteria.searchCondition }";
		}
		
		if(${ !empty requestScope.selectCriteria.searchValue? true: false }) {
			searchText += "&searchValue=${ requestScope.selectCriteria.searchValue }";
		}
			
		if(document.getElementById("startPage")) {
			const $startPage = document.getElementById("startPage");
			$startPage.onclick = function() {
				location.href = link + "?currentPage=1" + searchText;
			}
		}
		
		if(document.getElementById("prevPage")) {
			const $prevPage = document.getElementById("prevPage");
			$prevPage.onclick = function() {
				location.href = link + "?currentPage=${ requestScope.selectCriteria.pageNo - 1 }" + searchText;
			}
		}
		
		if(document.getElementById("nextPage")) {
			const $nextPage = document.getElementById("nextPage");
			$nextPage.onclick = function() {
				location.href = link + "?currentPage=${ requestScope.selectCriteria.pageNo + 1 }" + searchText;
			}
		}
		
		if(document.getElementById("maxPage")) {
			const $maxPage = document.getElementById("maxPage");
			$maxPage.onclick = function() {
				location.href = link + "?currentPage=${ requestScope.selectCriteria.maxPage }" + searchText;
			}
		}
		
		function pageButtonAction(text) {
			location.href = link + "?currentPage=" + text + searchText;
		}
	</script>
</body>
</html>
