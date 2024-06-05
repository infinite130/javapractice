<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Make Simple Order Board</title>
</head>
<body>
<h1>Order here</h1>
	<form action="order" method="post">
	<label>product : </label>
	<select name="product">
		<option value="apple">Apple</option>
		<option value="mango">Mango</option>
		<option value="banana">Banana</option>
	</select><br>
	<label>address : </label><input type="text" name="address"><br>
	<input type="submit" value="order start">
	</form>

</body>
</html>