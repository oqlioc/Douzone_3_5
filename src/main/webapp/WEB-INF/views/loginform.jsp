<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login</h1>
	<hr>

	<form action="/member/login" method="post">
		<b> ID: <input type="text" name="userId" /> <br><br>
		<b> PASS: <input type="password" name="userPw" /> <br><br>
		<input type="submit" value="login" /> <br><br>
	</form>

	<form action="join_form">
		<input type="submit" value="join" />
	</form>
</body>
</html>