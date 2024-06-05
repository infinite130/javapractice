<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Page</title>
</head>
<body>
<h1>주문하기</h1>

		<form action="order" method="post">
		<label>제품명 : </label>
		<select name="product">
			<option value="apple">사과</option>
			<option value="mango">망고</option>
			<option value="watermelon">수박</option>
		</select><br>
		<label>수량 : </label><input type="number" name="수량"><br>
		<label>배송지 : </label><input type="text" name="주소"><br>
		<input type="submit" value="주문하기">
	</form>
</body>
</html>