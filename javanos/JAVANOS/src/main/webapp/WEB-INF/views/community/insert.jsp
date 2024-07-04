<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티 게시글 작성</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/community/communityList.css">
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	<div id="wrap">
	<section>
		<h2 align="center">커뮤니티 게시글 작성</h2>
			<form action="${pageContext.servletContext.contextPath}/community/insert" method="post" enctype="multipart/form-data">
				<div class="thumbnail-insert-area">
					<table>
							<tr>
								<td data-label="제목">제목</td>
								<td colspan="1" data-label="제목 내용 입력 칸">
									<input type="text" name="communityTitle" id="communityTitle">
								</td>
							</tr>



							<tr>
								<td data-label="썸네일 사진">썸네일 사진</td>
								<td colspan="2">
									<div class="title-img-area" id="titleImgArea">
										<img id="titleImgView">
									</div>
									<input type="file" id="thumbnailImg" name="thumbnailImg">
								</td>
							</tr>
							
							
							<tr>
								<td data-label="내용 사진">내용 사진</td>
								<td data-label="내용 사진 선택 칸" colspan="3">
									<div id="img-container">
							            <img id="bodyImgView-1" class="imgView">
							            <img id="bodyImgView-2" class="imgView">
							            <img id="bodyImgView-3" class="imgView">
							        </div>
										<input type="file" id="bodyImg" name="bodyImg" multiple>
								</td>
							<tr>
								<td data-label="내용">내용</td>
								<td>
									<textarea name="communityBody" id="communityBody" rows="5" cols="50" style="resize:none;"></textarea>
								</td>
							</tr>
						</table>
				</div>
				<div class="button-area">
					<button type="submit" id="submitBtn">등록</button>
					<button type="button" id="cancel">취소</button>
				</div>
			</form>
			</section>
			</div>
			<jsp:include page="../common/footer.jsp"/>
			
			
	<script>
	document.addEventListener('DOMContentLoaded', () => {
	    const maxFiles = 3;
	    const input = document.getElementById('bodyImg');
	    const message = document.getElementById('fileLimitMessage');
	    const imgElements = document.querySelectorAll('.imgView');

	    input.addEventListener('change', function(event) {
	        const files = event.target.files;
	        
	        if (files.length > maxFiles) {
	            message.style.display = 'inline';
	            input.value = ''; // 파일 선택 초기화
	            imgElements.forEach(img => {
	                img.style.display = 'none';
	                img.src = '';
	            });
	        } else {
	            message.style.display = 'none';

	            // 모든 이미지 요소 숨기기 및 src 초기화
	            imgElements.forEach(img => {
	                img.style.display = 'none';
	                img.src = '';
	            });

	            // 선택된 파일을 이미지로 표시
	            Array.from(files).forEach((file, index) => {
	                if (index < imgElements.length) {
	                    const reader = new FileReader();
	                    reader.onload = function(e) {
	                        imgElements[index].src = e.target.result;
	                        imgElements[index].style.display = 'block';
	                    };
	                    reader.readAsDataURL(file);
	                }
	            });
	        }
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
	
       document.getElementById('bodyImg').addEventListener('change', function(event) {
           const files = event.target.files;
           const imgElements = document.querySelectorAll('.imgView');

           //이미지가 선택되었다가 다시 선택할 수 있으니까
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

		document.querySelector('#cancel').addEventListener('click',function(e){
			window.location.replace('${pageContext.servletContext.contextPath}/community/list');
		})
		
		
		
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
