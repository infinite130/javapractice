<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>습득 글 작성 - 분실물 게시판</title>
</head>
<body>

	<jsp:include page="../../common/menubar.jsp"/>
	
	<div>
		<br>
		<h2 align="center">게시판 작성</h2>
		<div class="table-area" align="center">
			<form action="${ pageContext.servletContext.contextPath }/lnf/insert" method="post">
				<table>
					<tr>
						<td>호선</td>
						<td>
							<select name="staLine">
								<option value="1">1호선</option>
								<option value="2">2호선</option>
								<option value="3">3호선</option>
								<option value="4">4호선</option>
								<option value="5">5호선</option>
								<option value="6">6호선</option>
								<option value="7">7호선</option>
								<option value="8">8호선</option>
								<option value="9">9호선</option>
								<option value="경의중앙선">경의중앙선</option>
								<option value="공항철도">공항철도</option>
								<option value="수인분당선">수인분당선</option>
							</select>
						</td>
						
						<td>역 </td>
						<td>
							<input type="text" name="staName">
						</td>
					
						<td>발견일</td>
						<td>
							<input type="date" name="findDate">
						</td>
					</tr>
					<tr>
						<td>분실 품목</td>
						<td>
							<input type="text" name="missing">
						</td>

						<td>보관 장소</td>
						<td>
							<input type="text" name="keep">
						</td>
					</tr>
					<tr>
						<td>내용</td>
						<td>
							<textarea name="description" cols="100" rows="15" style="resize:none;"></textarea>
						</td>
					</tr>
				</table>
				<br>
				<div align="center">
					<!-- 취소하면 firstPage로 반환 -->
					<button type="reset">취소하기</button>
					<button type="submit">등록하기</button>
				</div>
				
			</form>
			
		</div>
	</div>

</body>
</html>