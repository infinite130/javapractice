<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .down-enroll {
        display: flex;
        width: 1200px;
        flex-wrap: wrap;
          border: 2px solid #000; 
        padding: 20px; 
        border-radius:10px; 
        max-width: 800px; 
      
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
        justify-content: flex-end; /* 오른쪽 정렬 */
        margin-top: 20px;
    }
    .submit-button button {
        width: 150px;
        height: 50px;
        font-size: 18px;
        border-radius: 30px;
        cursor: pointer;
    }
    table {
        width: 500%;
    }
</style>
</head>
<body>
        <jsp:include page="../common/menubar.jsp"/>
			<form action="${ pageContext.servletContext.contextPath }/down/enroll" method="post">
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
                    <input type="radio" name=downFull  value="1">상
                    <input type="radio" name=downFull value="2">중
                    <input type="radio" name=downFull value="3">하
                </span>
            </div>
        <div class="submit-button">
            <button type="submit" >등록</button>
        </div>
    </form>
    
    
    
</body>
</html>