<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.example.board.model.BbsModel" %>

<%
	List<BbsModel> bbsList = (List<BbsModel>) request.getAttribute("boardlist");
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
	<%
	
		for(int i=0;i<bbsList.size();i++){
			BbsModel bb=(BbsModel)bbsList.get(i);
	%>
	<tr align="center" valign="middle">
		<td height="23">
			<%=bb.getBoardNo()%>
		</td>
		
		<td>
			<div align="center">
				<%=bb.getTitle() %>
			</div>
		</td>
		<td>
			<div align="center">
				<a href="/bbs/read?bbsno=<%=bb.getBoardNo()%>"><%=bb.getContent()%></a>
			</div>
		</td>	
		<td>
			<div align="center">
				<%=bb.getUserId()%>
			</div>
		</td>
		<td>
			<div align="center">
				<%=bb.getRegDate()%>
			</div>
		</td>
	</tr>
	<%} %>
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
</body>
</html>