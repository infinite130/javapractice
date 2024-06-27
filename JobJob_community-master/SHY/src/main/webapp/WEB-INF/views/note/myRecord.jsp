<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/admin_board.css">
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css" integrity="sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc" crossorigin="anonymous">
        
    <title>나의 활동(쪽지)</title>
    
    <style>

        h2 {
            text-align: left;
            margin-left: 270px;
            margin-top: 50px;
        }

        /* 4개 종류 분류 */
        .record_list {
            margin-top: 20px;
            margin-left: 270px;
        }

        .record_list_1 {
            margin-right: 15px;
        }

        .record_list_2 {
            margin-right: 15px;
        }

        .record_list_3 {
            margin-right: 15px;
        }

        .record_list_1:hover{
            color: gray;
        }

        .record_list_2:hover{
            color: gray;
        }

        .record_list_3:hover{
            color: gray;
        }

        .record_list_4:hover{
            color: gray;
        }

        /* 테이블 */
        table {
            border-collapse: collapse;
        }

        .myRecord_wrap{
            margin: 0 auto;
            border-top: 1px solid #666;
            border-bottom: 1px solid #f2f2f2;
            width: 1000px;
            text-align: center;
        }
        
        .myRecord_head {
            margin-top: 40px;
            border-bottom: 1px solid #f2f2f2;
            
        }

        .myRecord_content {
            padding: 10px 0;
            border-bottom: 1px solid #f2f2f2;
        }

        .myRecord_head_nm {
            padding: 5px;
            font-size: 15px;
            padding-right: 85px;
        }

        .myRecord_content_nm {
            padding: 3px;
            font-size: 13px;
            padding-right: 85px;
        }    

    </style>

</head>

<body>
   
     <%@include file = "../include/header.jsp" %>

    <section>
        <h2>
            나의 활동(쪽지)
        </h2>

    </section>
        <div class="record_list">
            <a href="<c:url value='/board/myRecord?board_writer=${login.userId}' />" class="record_list_1">작성글</a>
            <a href="<c:url value='/comment/myRecord?com_writer=${login.userId}' />" class="record_list_2">작성댓글</a>
            <a href="<c:url value='/scrap/myRecord?uses_Id=${login.userId}' />" class="record_list_3">스크랩</a>
            <a href="<c:url value='/note/myRecord?note_to=${login.userId}' />" class="record_list_4">받은 쪽지</a>
        </div>
        
    <section style="padding-top: 10px; padding-bottom: 100px;">
        <table class="myRecord_wrap">
            <thead class="myRecord_head">
                <tr> 
                    <th class="myRecord_head_nm">보낸이</th>
                    <th class="myRecord_head_nm">내용</th>
                    <!-- <th class="myRecord_head_nm">제목</th> -->
                    <!--  <th class="myRecord_head_nm">작성자</th>-->
                    <!-- <th class="myRecord_head_nm">조회</th> -->
                </tr>
            </thead>
			
            <tbody>
					      <c:forEach var="list" items="${note}">
			              <tr class="myRecord_content">
			                    <td class="myRecord_content_nm">
			                     ${list.note_from}
			                  	</td> 
			                    
			                    <td class="myRecord_content_nm">${list.note_content}</td>
			                
			              </tr>
				
               			</c:forEach>
            </tbody>
        </table>

    </section>

     <%@include file = "../include/footer.jsp" %>      
</body>
</html>