<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="java.util.List"%>
<%@ page import="com.javanos.project.lnf.model.dto.StationDTO"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>분실물 게시판</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>
	$(document).ready(function() {
		$('#staLine').change(function() {
			var selectedLine = $(this).val();
			$.ajax({
				type : 'POST',
				url : '${pageContext.request.contextPath}/getStations', // 비동기 요청을 처리할 서블릿 URL
				data : { staLine : selectedLine },
				dataType : 'json', // 서버로부터 받을 데이터 타입 지정
				success : function(data) {
					$('#staName').empty(); // 기존 옵션을 모두 제거
					$('#staName').append($('<option>').val('').text('Select a Station'));
					$.each(data, function(index, station) {
						$('#staName').append($('<option>').val(station.staName).text(station.staName));
					});
				},
				error : function(xhr, status, error) {
					console.error('Error while fetching stations:', status, error);
				}
			});
		});
	});
</script>
</head>
<body>

	<jsp:include page="../../common/menubar.jsp" />

	<div>
		<h2>분실물 찾기</h2>
		<br>

		<form action="${ pageContext.servletContext.contextPath }/board/list"
			method="post">
			<table>
				<!-- 호선 선택 -->
				<tr>
					<td>호선</td>
					<td><select name="staLine">
							<option value="">호선을 선택해 주세요</option>
							<%
							List<StationDTO> stationLines = (List<StationDTO>) request.getAttribute("staLine");
							if (stationLines != null) {
								for (StationDTO dto : stationLines) {
							%>
							<option value="<%=dto.getStaLine()%>"><%=dto.getStaLine()%></option>
							<%
							}
							}
							%>
					</select></td>
				</tr>

				<!-- 호선 필터링해서 역 선택; 비동기 통신으로 가지고 오기 -->
				<tr>
					<td>역</td>
					<td><select name="staName">
							<option value=""></option>

					</select></td>
				</tr>

				<!-- 날짜 범위 설정 -->
				<tr>
					<td>기간</td>
					<td><input type="date" name="startDate" /> ~ <input
						type="date" name="endDate" /></td>
				</tr>

			</table>
			<br>

			<div align="center">
				<button type="submit">찾기</button>
			</div>

		</form>
	</div>

	<!-- Ajax 스크립트 -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		$(document).ready(function() {
			$('#staLine').change(function() {
				var selectedLine = $(this).val();
				$.ajax({
					type : 'POST',										
					url : '${pageContext.request.contextPath}/getStations', // 서블릿 URL
					data : { staLine : selectedLine },
					dataType : 'json',
					success : function(data) {
						$('#staName').empty(); // 기존 옵션을 모두 제거
						$('#staName').append($('<option>').val('').text('역을 선택해 주세요'));
						$.each(data,function(index,	station) {
							$('#staName').append($('<option>').val(station.staName).text(station.staName));
						});
					},
					error : function(xhr, status, error) {
						console.error('Error while fetching stations:', status, error);
					}
				});
			});
		});
	</script>

	<div>
		<h2>분실물 등록하기</h2>
		<br>
		<form
			action="${ pageContext.servletContext.contextPath }/board/insert"
			method="post">
			<table>
				<!-- 호선 선택 -->
				<tr>
					<td>호선</td>
					<td><select name="staLine">
							<option value="line1">1호선</option>
							<option value="line2">2호선</option>
					</select></td>
				</tr>

				<!-- 호선 필터링해서 역 선택 -->
				<tr>
					<td>역</td>
					<td><select name="staName">
							<option value="what">아몰라</option>
							<option value=""></option>
					</select></td>
				</tr>

				<!-- 발견 일 등록 -->
				<tr>
					<td>발견일</td>
					<td><input type="date" name="findDate" /></td>
				</tr>
			</table>
			<br>
			<div align="center">
				<button type="submit">글쓰기</button>
			</div>
		</form>
	</div>

</body>
</html>