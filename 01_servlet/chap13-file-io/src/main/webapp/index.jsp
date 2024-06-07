<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FileUpload</title>
</head>
<body>
	<h1>File Upload</h1>

	<h4>commons file upload</h4>
	
	<form action="commons" method="post" enctype="multipart/form-data">
		<input type="file" name="singlefile"><br>
		<input type="file" name="multifile" multiple><br>
		<input type="text" name="description">
		<button type="submit">파일 전송</button>
			
	</form>
	
	<h4>thumbnailator</h4>
	<button onclick="location.href='transferToThumbnail'">Thumbnail image transferation</button>
	
</body>
</html>