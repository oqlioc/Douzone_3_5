<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>

<script>

function formCheck() {
    if (frm.userId.value.length < 3 || frm.userId.value.length > 20) {
        alert('ID는 4글자 이상 20자 이하로 입력해야 합니다.');
        frm.userId.focus();
        return false;
    }

    if (frm.userPw.value.length < 3 || frm.userPw.value.length > 20) {
        alert('비밀번호는 4글자 이상 20자 이하로 입력해야 합니다.');
        frm.userPw.focus();
        return false;
    }

    if (frm.userAddCode.value.length == 0) {
        alert('우편번호를 입력해야 한다.');
        frm.userAddCode.focus();
        return false;
    }
    
    return true;
    
}
</script>


<script>
	 $(document).ready(function(){
	    $('input#idDuplicateCheck').on('click',function(event){
	        var id=$('input[name=userId]').val();
	        $.ajax({
	            url: 'joinIdCheckJson',
	            data: {userId: id},  // userid=id입력값
	            success: function (isDup) {
	                if (isDup) {// id중복
	                    $('span#dupCheck').html('이미 존재하는 아이디입니다.').css('color', 'red');
	                } else { // id중복아님
	                    $('span#dupCheck').html('사용 가능한 아이디입니다.').css('color', 'green');
	                }
	            }
	        });
	    });
	});
	function Postcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
						// 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var roadAddr = data.roadAddress; // 도로명 주소 변수
						var extraRoadAddr = ''; // 참고 항목 변수
						// 법정동명이 있을 경우 추가한다. (법정리는 제외)
						// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
						if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
							extraRoadAddr += data.bname;
						}
						// 건물명이 있고, 공동주택일 경우 추가한다.
						if (data.buildingName !== '' && data.apartment === 'Y') {
							extraRoadAddr += (extraRoadAddr !== '' ? ', '
									+ data.buildingName : data.buildingName);
						}
						// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
						if (extraRoadAddr !== '') {
							extraRoadAddr = ' (' + extraRoadAddr + ')';
						}
						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('userAddCode').value = data.zonecode;
						document.getElementById("userAdd1").value = roadAddr;
						document.getElementById("userAdd2").value = data.jibunAddress;
						// 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
						if (roadAddr !== '') {
							document.getElementById("userAdd3").value = extraRoadAddr;
						} else {
							document.getElementById("userAdd3").value = '';
						}
						var guideTextBox = document.getElementById("guide");
						// 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
						if (data.autoRoadAddress) {
							var expRoadAddr = data.autoRoadAddress
									+ extraRoadAddr;
							guideTextBox.innerHTML = '(예상 도로명 주소 : '
									+ expRoadAddr + ')';
							guideTextBox.style.display = 'block';
						} else if (data.autoJibunAddress) {
							var expJibunAddr = data.autoJibunAddress;
							guideTextBox.innerHTML = '(예상 지번 주소 : '
									+ expJibunAddr + ')';
							guideTextBox.style.display = 'block';
						} else {
							guideTextBox.innerHTML = '';
							guideTextBox.style.display = 'none';
						}
					}
				}).open();
	}
</script>
</head>
<body>
	<h2>회원가입</h2>
	<form  action="joinPro" method="post" id="join" name="frm" onsubmit="return formCheck();" >
	<input type="text" name="userId" id="userId" placeholder="아이디" required="required">&nbsp;&nbsp;<input type="button" value="ID 중복검사" id="idDuplicateCheck">&nbsp;&nbsp;<span id="dupCheck"></span><br>
	<input type="text" name="userPw" id="userPw" placeholder="비밀번호" required="required"><br>
	<input type="text" name="userName" id="userName" placeholder="이름" required="required"><br>
	<input type="text" name = "userAddCode" id="userAddCode" placeholder="우편번호" readonly>
        <input type="button" onclick="Postcode()" value="우편번호 찾기" > <br>
        <input type="text" name="userAdd1" id="userAdd1" placeholder="도로명주소" readonly >
        <input type="text" name="userAdd2" id="userAdd2" placeholder="지번주소" readonly>
        <span id="guide" style="color: #999; display: none"></span> <input
            type="text" name="userAdd4" id="userAdd4" placeholder="상세주소"> <input
            type="text" name="userAdd3" id="userAdd3" placeholder="참고항목"> <br /> 
            <input type="submit" value="회원가입"/> 
            <input type="button" value="취소" onclick="history.back(-1)" />
    </form>
</body>
</html>