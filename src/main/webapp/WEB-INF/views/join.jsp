<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="text" id="uiName" placeholder="이름"><br>
<input type="text" id="uiId" placeholder="아이디"><br>
<input type="password" id="uiPwd" placeholder="비밀번호"><br>
<button onclick="addUser()">가입</button>
</body>
<script>
function addUser(){
	
	const xhr = new XMLHttpRequest();
	xhr.open('POST','/user');
	xhr.onreadystatechange = function () {
		if(xhr.readyState === 4){
			if(xhr.status === 200){
				if(xhr.responseText == '1'){
					alert('가입완료');
					location.href='/views/index';
				}
			}
		}
	}
	xhr.send(param);
	
/* 	const conf = {
			url : '/user',
			method : 'POST',
			callback : function(res){
				if(!res){
					alert('이름, 아이디, 비밀번호를 입력해주세요');
				}else{
					const user = JSON.parse(res);
					alert('회원가입에 성공했습니다');
					location.href = '/views/index';
				}
			}
	}
	ajax(conf); */
}	

</script>
</html>