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
<script language="javascript">
	window.onload = function () {
		if(<%=userId%> == null) {
			alert("로그인후 이용해주세요")
			location.href = "/bbs/listPaging";
		}
	}
</script>
<body>
	<!-- 게시판 등록 -->
		<table border="1">
			<tr align="center" valign="middle">
				<td colspan="2">
					MVC 게시판
				</td>
			</tr>
			<tr>
				<td>
					<div align="center">작성자</div>
				</td>
				<td>
					<input name="userId" id="userId" type="text" size="50" maxlength="100" value="<%=userId%>" readonly/>
				</td>
			</tr>
			<tr>
				<td>
					<div align="center">제 목</div>
				</td>
				<td>
					<input name="title" id="title" type="text" size="50" maxlength="100" value="" />
				</td>
			</tr>
			<tr>
				<td>
					<div align="center">내 용</div>
				</td>
				<td>
					<input name="content" id="content" type="text" size="50" maxlength="100" value="" />
				</td>
			</tr>
			<tr align="center" valign="middle">
				<td colspan="5">
					<a id="wrtie_process">[등록]</a>&nbsp;&nbsp;
					<a href="javascript:location.href = '/bbs/listPaging'">[뒤로]</a>
				</td>
			</tr>
		</table>
	<!-- 게시판 등록 -->
	
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
<script>
	$(document).ready(function(){
		$("#wrtie_process").click(function(){
 			var json = {
 				userId : $("#userId").val(),
				title : $("#title").val(),
				content : $("#content").val()
			};
 			console.log(json.userId);
 			console.log(json.title);
			$.ajax({
				type : "post",
				url : "/bbs/write",
				dataType    :   "json",
				data : json,
				contentType :   "application/x-www-form-urlencoded; charset=UTF-8",
				success : function(retVal){
					if(retVal.code == "SUCCESS") {
						alert(retVal.message);
                    	location.href = "/bbs/listPaging";
					} else {
                    	alert(retVal.message);
                    }
				},
				error: function(request, status, error){
					console.log("AJAX_ERROR");
				}
			});
		});
	});
</script>
</body>
</html>