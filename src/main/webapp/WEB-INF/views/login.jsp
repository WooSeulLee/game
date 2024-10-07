<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="text" id="uiId" placeholder="아이디"><br>
<input type="password" id="uiPwd" placeholder="비밀번호"><br>
<button onclick="login()">로그인</button>

<script>
function login(){
	const param = {
			uiId : document.querySelector('#uiId').value,
			uiPwd : document.querySelector('#uiPwd').value
	}
	const conf = {
			url : '/login',
			method : 'POST',
			param : JSON.stringify(param),
			json : true,
			callback : function(res){
				if(!res){
					alert('아이디 비밀번호를 확인해주세요!');
				}else{
					const user = JSON.parse(res);
					alert(user.uiName + '님 안녕하세요');
					location.href='/';
				}
			}
	}
	ajax(conf);
}
</script>


</body>
</html>