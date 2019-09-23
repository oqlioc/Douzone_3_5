<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.example.board.model.BbsModel" %>
<%
	String userId = (String) session.getAttribute("userId");
%>
<html>
<head>
	<title>MVC 게시판</title>
</head>

<body>
<!-- 게시판 리스트 -->
<table border="1" align="center">
	<tr align="center" valign="middle">
		<td colspan="5">MVC 게시판</td>
	</tr>
	
	<tr align="center" valign="middle">
		<td  height="26">
			<div align="center">번호</div>
		</td>
		<td >
			<div align="center">제목</div>
		</td>
		<td >
			<div align="center">내용</div>
		</td>
		<td >
			<div align="center">작성자</div>
		</td>
		<td >
			<div align="center">날짜</div>
		</td>
	</tr>
	<c:forEach items="${articles}" var="article">
	<tr align="center" valign="middle">
		<td height="23">
			${article.boardNo}
		</td>
		
		<td>
			<div align="center">
				${article.title}
			</div>
		</td>
		<td>
			<div align="center">
				<a href="/bbs/read?bbsno=${article.boardNo}">${article.content}</a>
			</div>
		</td>	
		<td>
			<div align="center">
				${article.userId}
			</div>
		</td>
		<td>
			<div align="center">
				${article.regDate}
			</div>
		</td>
	</tr>
	</c:forEach>
	<%
		if(userId != null) {
	%>
	<tr align="right">
		<td colspan="5">
	   		<a href="/bbs_write_form">[글쓰기]</a>
		</td>
	</tr>
	<%		
		}
	%>
</table>
<div style="background-color:red; margin-left: auto; margin-right: auto;">
	<c:if test="${pageMaker.prev}">
		<a href="/bbs/listPaging?page=${pageMaker.startPage - 1}">이전</a>
	</c:if>
	<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
		<a href="/bbs/listPaging?page=${idx}">${idx}</a>
	</c:forEach>
	<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
		<a href="/bbs/listPaging?page=${pageMaker.endPage + 1}">다음</a>
	</c:if>
</div>
</body>
</html>