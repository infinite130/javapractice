<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON String</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
</head>
<body>
	<h1>AJAX 요청 후 stream 을 이용한 JSON 응답</h1>
	
	<h3>1. 데이터 전송 없이 JSON 반환</h3>
	<button id="send-get-1">SEND</button>
	<script>
		$("#send-get-1").click(function(){
			$.ajax({
				url: "/chap02/receive/json",
				type: "get",
				success: function(data) {
					console.log(data);
					
					/* JSON.parse(): json 형태의 문자열을 Object 타입의 객체로 파싱하여 반환하는 메소드 */
					let jsonObject = JSON.parse(data);
					console.log(jsonObject);
					console.table(jsonObject);
				},
				error: function(error) {
					console.log(error);
				}
			});
		});
	</script>
	
	<h3>2. 데이터 전송 없이 JSONArray 반환</h3>
	<button id="send-get-2">SEND</button>
	<script>
		$("#send-get-2").click(function(){
			$.ajax({
				url: "/chap02/receive/array",
				type: "get",
				success: function(data) {
					console.table(data);
					
					let jsonObject = JSON.parse(data);
					console.table(data);
					
				},
				error: function(error) {
					console.log(error);
				}
			});
		});
	</script>
	
	<h3>3. 데이터 전송 없이 응답 헤더 설정 후 JSONArray 반환</h3>
	<button id="send-get-3">SEND</button>
	<script>
		$("#send-get-3").click(function(){
			$.ajax({
				url: "/chap02/receive/jsonarray",
				type: "get",
				success: function(data) {
					console.table(data);
				},
				error: function(error) {
					console.table(error);
				}
			});
		});
	</script>
</body>
</html>