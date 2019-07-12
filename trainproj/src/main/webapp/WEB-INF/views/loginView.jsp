<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.LoginVO, java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TT 로그인 페이지</title>
<style>
*{
		text-align: center;
}
</style>
</head>
<body>
<br>
	<h1>TRAIN TOGETHER</h1>
	<h5>KOREA</h5>
	<br>
	<hr>
	<h3>Log in to Your Account</h3>
	<form id="loginForm" action="/springtrain/loginmain" method="post">
<%-- 		<input type="hidden" name="login" value="${getLogin.getUser_id}"> --%>
		<input type="hidden" name="action" value="login">
		<input id="username" type="text" name="user_id" placeholder="아이디를 입력해주세요" required> 
		<br> 
		<br>
		<input id="passwd" type="password" name="passwd"placeholder="비밀번호를 입력해주세요" required>
		 <br> 
		 <br> 
		 <input id="send" type="submit" value="로그인"> 
		<button>
			<a href="register.jsp">회원가입</a>
		</button>
		<%
			if (request.getAttribute("msg") != null) {
		%>
		<script>
			alert('${msg}')
		</script>
		<%
			}
		%>
	</form>
</body>
</html>