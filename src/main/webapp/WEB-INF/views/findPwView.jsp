<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>

<script>

	 $(document).ready(function(){
	    $('input#idDuplicateCheck').on('click',function(event){
	        var id=$('input[name=userId]').val();
	        $.ajax({
	            url: 'joinIdCheckJson',
	            data: {userId: id},  // userid=id입력값
	            success: function (isDup) {
	                if (isDup) {// id중복
	                    $('span#dupCheck').html('존재하는 아이디 입니다.').css('color', 'green');
	                } else { // id중복아님
	                    $('span#dupCheck').html('존재하지 않는 아이디 입니다.').css('color', 'red');
	                }
	            }
	        });
	    });
	});
</script>
</head>
<body>
	<h2>비밀번호 찾기</h2>
	<form  action="findPw" method="post" id="findPw" name="frm" >
		<input type="text" name="userId" id="userId" placeholder="아이디" required="required">
		&nbsp;&nbsp;<input type="button" value="ID 존재 확인" id="idDuplicateCheck">
		&nbsp;&nbsp;<span id="dupCheck"></span><br>
		 
	    <input type="submit" value="비밀번호 찾기"/> 
	    <input type="button" value="취소" onclick="history.back(-1)" />
    </form>
</body>
</html>