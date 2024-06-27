<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티 게시글 작성</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script></head>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	<div>
		<h2>커뮤니티 게시글 작성</h2>
			<br>
			<form action="${pageContext.servletContext.contextPath}/community/insert" method="post" enctype="multipart/form-data">
				<div class="thumbnail-insert-area">
					<table>
							<tr>
								<td>제목</td>
								<td>
									<input type="text" name="communityTitle" id="communityTitle">
								</td>
							</tr>
							<tr>
								<td>썸네일 이미지</td>
								<td>
									<div class="title-img-area" id="titleImgArea">
										<img id="titleImgView" width="350" height="200">
									</div>
								</td>
								<td>
									<input type="file" id="thumbnailImg" name="thumbnailImg" onchange="loadImg(this,1)">
								</td>
							</tr>
							
							
							<tr>
								<td>내용 사진</td>
								<td>
									<div class="body-img-area1" id="bodyImgArea1">
										<img id="bodyImgView1" width="120" height="100">
									</div>	
								</td>
								<td>
									<input type="file" id="bodyImg1" name="bodyImg1" onchange="loadImg(this,2)">
								</td>
								<td>
									<div class="body-img-area2" id="bodyImgArea2">
										<img id="bodyImgView2" width="120" height="100">
									</div>	
								</td>
								<td>
									<input type="file" id="bodyImg2" name="bodyImg2" onchange="loadImg(this,3)">
								</td>
								<td>
									<div class="body-img-area3" id="bodyImgArea3">
										<img id="bodyImgView3" width="120" height="100">
									</div>	
								</td>
								<td>
									<input type="file" id="bodyImg3" name="bodyImg3" onchange="loadImg(this,4)">
								</td>
							</tr>
							<tr>
								<td>내용</td>
								<td>
									<textarea name="communityBody" id="communityBody" rows="5" cols="50" style="resize:none;"></textarea>
								</td>
							</tr>
						</table>
				</div>
				<br>
				<div>
					<button type="submit" id="submitBtn">등록</button>
					<button onclick="goBackList()">취소</button>
				</div>
			</form>
			
			<script>
				const $titleImgArea = document.getElementById("titleImgArea");
				const $bodyImgArea1 = document.getElementById("bodyImgArea1");
				const $bodyImgArea2 = document.getElementById("bodyImgArea2");
				const $bodyImgArea3 = document.getElementById("bodyImgArea3");
				
				$titleImgArea.onclick = function() { 
					document.getElementById("thumbnailImg").click(); 
				}
				
				$bodyImgArea1.onclick = function() {
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
				/* 
					파일 입력 요소에서 파일이 입력되면, 해당 파일을 읽고 데이터  url 형식으로 변환하여 지정된 이미지 요소에 미리보기를 표시
					'num' 매개변수를 사용하여 어떤 이미지 요소에 이미지를 표시할지를 결정
					사용자는 파일 선택시 즉시 미리보기 가능
				*/
				
				
				
				/* 만약 한 input태그로 파일을 여러개 선택한다면??
				//<input type="file" multiple">
				*/
			
			
				function goBackList() {
					window.history.back();
					//혹시 모르니까
					/* location.href="${pageContext.servletContext.contextPath}/community/list";  */
				}
				
				
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
		</div>

</body>
</html>