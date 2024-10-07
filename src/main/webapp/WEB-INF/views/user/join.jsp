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
	<input type="text" id="uiName" placeholder="이름">
	<br>
	<input type="text" id="uiId" placeholder="아이디">
	<br>
	<input type="password" id="uiPwd" placeholder="비밀번호">
	<br>
	<button onclick="addUser()">가입</button>

	<script>
		function addUser() {
			const uiName = document.querySelector('#uiName').value;
			const uiId = document.querySelector('#uiId').value;
			const uiPwd = document.querySelector('#uiPwd').value;

			// input이 공백일 때 
			if (!uiName) {
				alert('이름을 입력해주세요!');
				return;
			}
			if (!uiId) {
				alert('아이디를 입력해주세요!');
				return;
			}
			if (!uiPwd) {
				alert('비밀번호를 입력해주세요!');
				return;
			}

			// 아이디 중복 확인
			const confCheckId = {
				url : '/checkId?uiId=' + encodeURIComponent(uiId), //특수문자를 %+16진수로 변환!!!!
				method : 'GET',
				callback : function(res) { //아이디가 중복일 때
					if (res === "아이디가 이미 존재합니다.") {
						alert(res);
					} else { // 중복이 아닐 경우 가입 진행
						const param = new FormData();
						param.append('uiName', uiName);
						param.append('uiId', uiId);
						param.append('uiPwd', uiPwd);

						const confAddUser = {
							url : '/user',
							method : 'POST',
							param : param,
							callback : function(res) {
								if (res === '1') {
									alert(uiName + '님, 성공적으로 가입을 완료했습니다.');
									location.href = '/views/user/login';
								} else {
									alert('가입 실패. 다시 시도해주세요.');
								}
							}
						};

						ajax(confAddUser);
					}
				}
			};

			ajax(confCheckId);
		}
	</script>
</body>
</html>