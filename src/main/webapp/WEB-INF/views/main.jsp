<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String userId = (String) session.getAttribute("userId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	if( userId == null) {
%>
		<input type='button' value='로그인' onclick="javascript:location.href='/loginform'">
<%
	}else {
%>
<h1><%= userId %>님아 왜 이제옴</h1>
		<input type="submit" value="로그아웃" onclick="location.href='/member/logout'">
<%	
	}
%>
<input type='button' value='게시판' onclick="javascript:location.href='/bbs/bbs_list'">

</body>
</html>