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

	<form action="/member/login" method="post" name="form1">
		<b> ID: <input type="text" name="userId" id="userId" /> <br><br>
		<b> PASS: <input type="password" name="userPw" id="userPw"/> <br><br>
		<button type="button" id="btnLogin" >login</button>
		<br><br>
	</form>

	<form action="member/join_form">
		<input type="submit" value="join" />
	</form>
</body>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script>
    $(document).ready(function() {
        $("#btnLogin").click(function() {
            var userId = $("#userId").val();
            var userPw = $("#userPw").val();
            if (userId === "") {
                alert("아이디를 입력하세요");
                $("#userId").focus();
                return;
            }
            if (userPw === "") {
                alert("비밀번호를 입력하세요");
                $("#userPw").focus();
                return;
            }            
        
            document.form1.submit();
        });
    });
</script>
</html>