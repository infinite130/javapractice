<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/down/downEnrollForm.css">
</head>
<body>
    <jsp:include page="../common/menubar.jsp"/>
    <br>
    <form action="${ pageContext.servletContext.contextPath }/down/enroll" method="post">
       <div class="container">
        <div class="down-enroll">
            <div class="label-below">
                <label for="inStationNo">승차해 있는 역</label>
                <span><select name="inStationNo">
                 <option selected>(승차역)</option>
                    <option value="1">가락시장</option>
                    <option value="2">천호</option>
              
                </select></span>
            </div>
            <div class="label-below">
                <label for="downStationNo">하차 할 역 이름</label>
                <span><select name="downStationNo">
                 <option selected>(하차역)</option>
                    <option value="1">가락시장</option>
                    <option value="2">천호</option>
                 
                </select></span>
            </div>
            <div class="label-below">
                <label for="downRoom">칸 번호</label>
                <span><select name="downRoom" >
                <option selected>(칸번호)</option>
                    <option value="1-1칸">1-1</option>
                    <option value="1-2칸">1-2</option>
                    <option value="1-3칸">1-3</option>
                    <option>2-1</option>
                    <option>2-2</option>
                    <option>3-1</option>
                    <option>3-2</option>
                    <option>3-3</option>
                    <option>4-1</option>
                    <option>4-2</option>
                    <option>4-3</option>
                    <option>5-1</option>
                    <option>5-2</option>
                    <option>5-3</option>
                </select></span>
            </div>
            <div class="label-below">
                <label>혼잡도</label>
                <div class="radio-group">
                    <input type="radio" name="downFull" value="상" ><label for="fullHigh">상</label>
                    <input type="radio" name="downFull" value="중" ><label for="fullMedium">중</label>
                    <input type="radio" name="downFull" value="하" ><label for="fullLow">하</label>
                </div>
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
    </form>   
               <br> <br>
                  <!--dto=down  -->
        <div class="container">
        <div class="down-enroll">
            <c:forEach var="down" items="${ requestScope.downList }">
                <div class="label-below">
                    <label>승차해 있는 역</label>         
                    <span><div class="box"><c:out value="${ down.downStation.staName }"/></div></span>
                </div>
                
                <div class="label-below">
                    <label>하차 할 역 이름</label>     
                    <span><div class="box"><c:out value="${ down.inStation.staName }"/></div></span>
                </div>
                
                <div class="label-below">
                    <label>칸번호</label>
                    <span><div class="box"><c:out value="${ down.downRoom }"/></div></span>
                </div>
                
                <div class="label-below">
                    <label>혼잡도</label>
                    <span><div class="box"><c:out value="${ down.downFull}"/></div></span>
                </div>
                
               <label style="position: absolute; top: 5px; right: 30px; font-size: 12px;">(등록자)</label>
                <span class="nickname"><c:out value="${ down.user.userNickname}"/></span></lable>
                 
                <span class="date"><c:out value="${ down.downEnrollDate}"/></span>
                
                 <div class="submit-button">
                <c:if test="${ sessionScope.loginUser.userNo eq down.user.userNo }">
                    <span><button onclick="deleteDown(${down.downNo})">삭제</button></span>
                </c:if></div>
                
            </c:forEach>
        </div>
    </div>
    
	<br>		
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
