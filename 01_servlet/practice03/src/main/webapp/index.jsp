<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Page</title>
</head>
<body>
	<h1>Order Page</h1>
	<form action="order" method="post">
	<label>제품명 : </label>
	<select name="product">
		<option value="apple">사과</option>
		<option value="mango">망고</option>
	</select><br>
	<label>수량 : </label><input type="number" name="number"><br> 
	<input type="submit" value="주문하기">
	</form>

</body>
</html>