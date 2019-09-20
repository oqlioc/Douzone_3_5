<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<table>
		<thead>
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${memberList}" var="member">
				<tr>
					<td>${member.userId}</td>
					<td>${member.userPw}</td>
					<td>${member.userName}</td>
					<td>${member.userAdd}</td>
					<td>${member.userAddCode}</td>
					<td>${member.isActive}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
