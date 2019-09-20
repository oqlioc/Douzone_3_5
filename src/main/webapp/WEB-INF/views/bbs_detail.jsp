<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.example.board.model.BbsModel" %>
<%
	BbsModel bbsModel = (BbsModel) request.getAttribute("bbsModel");
	String userId = (String) session.getAttribute("userId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script language="javascript">
	function modifyBbs() {
		boardform.submit();
	}
</script>
<body>
	<!-- 게시판 등록 -->
	<form action="/bbs/modify" method="post" name="boardform">
		<table border="1">
			<tr align="center" valign="middle">
				<td colspan="2">
					MVC 게시판
				</td>
			</tr>
			<tr>
				<td>
					<div align="center">글번호</div>
				</td>
				<td>
					<input name="boardNo" type="text" size="50" maxlength="100" value="${bbsModel.boardNo}" readonly />
				</td>
			</tr>
			<tr>
				<td>
					<div align="center">작성자</div>
				</td>
				<td>
					<input name="userId" type="text" size="50" maxlength="100" value="${bbsModel.userId}" readonly />
				</td>
			</tr>
			<tr>
				<td>
					<div align="center">제 목</div>
				</td>
				<td>
					<input name="title" type="text" size="50" maxlength="100" value="${bbsModel.title}" />
				</td>
			</tr>
			<tr>
				<td>
					<div align="center">내 용</div>
				</td>
				<td>
					<input name="content" type="text" size="50" maxlength="100" value="${bbsModel.content}" />
				</td>
			</tr>
			<tr align="center" valign="middle">
				<td colspan="5">
					<%
						if(userId.equals(bbsModel.getUserId())) {
					%>
					<a href="javascript:modifyBbs()">[수정]</a>&nbsp;&nbsp;
					<a href="javascript:location.href = '/bbs/delete?bbsno=${bbsModel.boardNo}'">[삭제]</a>&nbsp;&nbsp;
					<%		
						}
					%>
					<a href="javascript:location.href = '/bbs/bbs_list'">[게시판메인]</a>
				</td>
			</tr>
		</table>
	</form>
	<!-- 게시판 등록 -->
</body>
</html>