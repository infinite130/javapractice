<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티 게시글 수정</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/community/communityList.css">
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
		<h2 align="center">커뮤니티 게시글 수정</h2>
			<form id="edit-post-form" action="${pageContext.servletContext.contextPath}/community/update" method="post" enctype="multipart/form-data">
				<input type="hidden" name="communityNo" value="${ community.communityNo }">
				<div class="thumbnail-update-area">
					<table>
							<tr>
								<td data-label="제목">제목</td>
								<td colspan="1" data-label="제목 내용 입력 칸">
									<input type="text" name="communityTitle" id="communityTitle" value="${ community.communityTitle }">
								</td>
							</tr>
							
							<tr>
								<td>작성자: </td>
								<td>${ community.user.userNickname }</td>
							</tr>
							
							<tr>
								<td data-label="썸네일 사진">썸네일 사진</td>
								<td>
									<label>섬네일은 1개만 선택이 가능합니다.</label>
									<c:choose>
										<c:when test="${ not empty community.pictureList }">
											<div class="title-img-area" id="titleImgArea">
												<img id="titleImgView" class="thumbnailImg" onerror="setDefaultImage(this);" src="${pageContext.servletContext.contextPath }${community.pictureList[0].thumbnailPath }">
											</div>
												<button type="button" class="remove-image-btn" data-image-id="${community.pictureList[0].picNo}">삭제</button>
										</c:when>
										<c:when test="${ empty community.pictureList }">
					            			<label>첨부한 사진이 없습니다.</label>
					            			<img class="imgView" onerror="setDefaultImage(this);">
							           </c:when>
									</c:choose>
									<input type="file" id="thumbnailImg" name="thumbnailImg">
								</td>
							</tr>
							
							<tr>
								<td data-label="내용 사진">내용 사진</td>
								<td data-label="내용 사진 선택 칸" colspan="3">
									<label>내용사진은 3개까지 선택이 가능합니다.</label>
									<div id="img-container">
									<c:choose>
							            	<c:when test="${ not empty community.pictureList }">
							            		<div class="body-img-area" id="bodyImgArea">
									                <c:forEach items="${ community.pictureList }" var="picture" begin="1">
									                        <img class="imgView" onerror="setDefaultImage(this);" src="${pageContext.servletContext.contextPath }${ picture.thumbnailPath }">
															<button type="button" class="remove-image-btn" data-image-id="${picture.picNo}">삭제</button>
									                </c:forEach>
									             </div>
							            	</c:when>
							            	<c:when test="${ empty community.pictureList }">
							            			<label>첨부한 사진이 없습니다.</label>
							            			<img class="imgView" onerror="setDefaultImage(this);">
							            			<img class="imgView" onerror="setDefaultImage(this);">
							            			<img class="imgView" onerror="setDefaultImage(this);">
							            	</c:when>
							         </c:choose>
									</div>
									<input type="file" id="bodyImg" name="bodyImg" multiple>
								</td>
							</tr>
							
							<tr>
								<td data-label="내용">내용</td>
								<td>
									<textarea name="communityBody" id="communityBody" rows="5" cols="50" style="resize:none;">${ community.communityBody }</textarea>
								</td>
							</tr>
						</table>
					</div>
				<div class="button-area">
					<button type="submit" id="submitBtn">등록</button>
					<button type="button" onclick="gobackdetail()">취소</button>
				</div>
			</form>
			
			
			
	<script>
		document.addEventListener('DOMContentLoaded', () => {
		    document.querySelectorAll('.remove-image-btn').forEach(button => {
		        button.addEventListener('click', () => {
		        	const imgElement = button.previousElementSibling;
                    imgElement.src = ''; // 이미지 태그 비우기
                    imgElement.alt = '이미지 없음'; // ALT 텍스트 설정

		            const picNo = button.getAttribute('data-image-id');
		            const hiddenInput = document.createElement('input');
		            hiddenInput.type = 'hidden';
		            hiddenInput.name = 'remove_images';
		            hiddenInput.value = picNo;
		            console.log('Appending hidden input for image ID:', picNo);
		
		            document.getElementById('edit-post-form').appendChild(hiddenInput);
		            
		            button.style.display = 'none';
		
		            console.log(`Image with ID ${picNo} marked for removal.`);
		        });
		    });
		});
		
		
		document.getElementById('thumbnailImg').addEventListener('change', (event) => {
            const files = event.target.files;
            const imgPreview = document.getElementById('titleImgView');
            if (files && files[0]) {
                const reader = new FileReader();
                reader.onload = (e) => {
                    imgPreview.src = e.target.result;
                };
                reader.readAsDataURL(files[0]);
            }
        });
		
		document.addEventListener('DOMContentLoaded', () => {
			document.getElementById('bodyImg').addEventListener('change', function(event) {
		           const files = event.target.files;
		           const imgElements = document.querySelectorAll('.imgView');
	
		           imgElements.forEach(img => {
		               img.src = '';
		           });
	
		           Array.from(files).forEach((file, index) => {
		               if (index < imgElements.length) { 
		                   const reader = new FileReader();
		                   reader.onload = function(e) {
		                       imgElements[index].src = e.target.result;
		                   };
		                   reader.readAsDataURL(file);
		               }
		           });
		       });
		});
		
	
		
		function setDefaultImage(img) {
			console.log("파일을 등록하지 않았거나 파일의 경로를 찾을 수 없습니다.");
			img.onerror = null;
			img.src ='${pageContext.servletContext.contextPath}/resources/image/community/basicImage.png';
		};
    
		
		
		function gobackdetail() {
			window.history.back();
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