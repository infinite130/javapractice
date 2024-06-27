<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티 게시글 수정</title>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
		<h2>커뮤니티 게시글 작성</h2>
			<br>
			<form action="${pageContext.servletContext.contextPath}/community/update" method="post" enctype="multipart/form-data">
					<table>
							<tr>
								<td>제목</td>
								<td>
									<input type="text" name="communityTitle" id="communityTitle" value="${ community.communityTitle }">
								</td>
							</tr>
							
							<tr>
								<td>작성자: </td>
								<td>${ community.user.userNickname }<input type="hidden" name="communityNo" value="${ community.communityNo }"></td>
							</tr>
							
							<tr>
								<td>대표 이미지</td>
								<td>대표 이미지는 한 장만 선택이 가능합니다.</td>
							</tr>
							
							<tr>
								<td>
									<div class="title-img-area" id="titleImgArea">
										<img id="titleImgView" class="thumbnailImg" width="350" height="200" src="${pageContext.servletContext.contextPath }${picture.thumbnailPath }">
									</div>
								</td>
								<td>						
									<input type="file" id="thumbnailImg" name="thumbnailImg" onchange="loadImg(this)">
								</td>
							</tr>
							
							
							
							<tr>
								<td>내용 이미지</td>
								<td>내용 이미지는 다중 선택이 가능합니다.</td>
								<td>
									<div id="img-insert-area">
											<c:forEach items="${community.pictureList}" var="picture" begin="1">
												<div class="body-img-area" id="bodyImgArea">
													<img id="imgView" class="imgView" width="350" height="200" src="${pageContext.servletContext.contextPath }${picture.thumbnailPath }">
												</div>
											</c:forEach>
									</div>
								</td>
								<td>
									<input type="file" id="bodyImg" name="bodyImg" onchange="loadImg(this)" multiple>
								</td>
							</tr>
							
							<tr>
								<td>내용</td>
								<td>
									<textarea name="communityBody" id="communityBody" rows="5" cols="50" style="resize:none;">${ community.communityBody }</textarea>
								</td>
							</tr>
						</table>
				<br>
				<div>
					<button type="submit" id="submitBtn">등록</button>
					<button onclick="gobackdetail()">취소</button>
				</div>
			</form>
	<script>
/* 	function loadImg(input) {
 		const files = input.files;
	    const imgArea = document.getElementById('imgArea');
	    imgArea.innerHTML = ''; // 기존 이미지를 모두 지움
	
	    for (let i = 0; i < files.length; i++) {
	        const reader = new FileReader();
	        reader.onload = function(e) {
	            const newImgDiv = document.createElement('div');
	            newImgDiv.classList.add('img-sub-area');
	            newImgDiv.innerHTML = `<img width="350" height="200" src="${e.target.result}">`;
	            imgArea.appendChild(newImgDiv);
	        }
	        reader.readAsDataURL(files[i]);
	    	}
		} */
		// 파일을 읽고, 결과를 데이터 url형식으로 반환
		// 반환된 결과는 reader.onload 이벤트 핸들러에서 처리됨
		
		
		//classname으로 해야할 듯??
		const $titleImgArea = document.getElementById("titleImgArea");
		const $bodyImgArea = document.getElementById("bodyImgArea");
		
		$titleImgArea.onclick = function() { 
			document.getElementById("thumbnailImg").click(); 
		}
		
		$bodyImgArea.onclick = function() {
			document.getElementById("bodyImg1").click();
		}
		
		$bodyImgArea2.onclick = function() {
			document.getElementById("bodyImg2").click();
		}
		
		$bodyImgArea3.onclick = function() {
			document.getElementById("bodyImg3").click();
		}
		
		 function loadImg(value, num) {
			if (value.files && value.files[0]) {
				//파일 입력 요소에서 선택된 파일 리스트/ 그 중 첫번재 파일
				const reader = new FileReader();
				reader.onload = function(e) {
					switch(num){
					case 1:
						document.getElementById("titleImgView").src = e.target.result;//파일의 데이터 url, 이미지 소스로 설정되어 브라우저에 이미지 표시
						break;
					case 2:
						document.getElementById("bodyImgView1").src = e.target.result;
						break;
					case 3:
						document.getElementById("bodyImgView2").src = e.target.result;
						break;
					case 4:
						document.getElementById("bodyImgView3").src = e.target.result;
						break;
					}
				}
				reader.readAsDataURL(value.files[0]);
				// 파일을 읽고, 결과를 데이터 url형식으로 반환
				// 반환된 결과는 reader.onload 이벤트 핸들러에서 처리됨
			}
		}
	
	
	
	
		function gobackdetail() {
			window.history.back();
			//혹시 모르니까
	/* 		let communityNo = ${ community.communityNo }
			location.href="${pageContext.servletContext.contextPath}/community/detail?communityNo="+ communityNo;  */
		};
		
		
		document.querySelector('#submitBtn').addEventListener('click',function(e){
			if(document.querySelector('#communityTitle').value==''){
				e.preventDefault()//폼 전송을 막는다.
				alert('제목이 비어있습니다!!')
			}else if(document.querySelector('#communityBody').value==''){
				e.preventDefault()//폼 전송을 막는다.
				alert('내용이 비어있습니다!!')
			}
		})
	</script>
</body>
</html>