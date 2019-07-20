<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="vo.MemberVO, java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css" rel="stylesheet">
<title>TRAIN TOGETHER</title>
<style>
    body {
        background: #f8f8f8;
		padding: 300px 0;
    }
    #login-form > div {
        margin: 15px 0;
    }
	div{
 		margin: auto;
		text-align: center;
	}

</style>
</head>
<body>

<div class="container">
    <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-success">
            <div class="panel-heading">
                <div class="panel-title"><h1>TRAIN TOGETHER</h1><br></div>
            </div>
            <div class="panel-body">
                <form id="login-form" action="/springtrain/registerInsert" method="post">
                		<input type="hidden" name="action" value="register">
                    <div>
                        <input type="text" class="form-control" name="user_id" placeholder="Username" required="required" autofocus>
                    </div>
                    <div>
                        <input type="email" class="form-control" name="email" placeholder="Email" autofocus>
                    </div>
                    <div>
                        <input type="password" class="form-control" name="passwd" placeholder="Password" required="required">
                    </div>
                    <div>
                        <button type="submit" class="form-control btn btn-primary">회원가입</button>
                    </div>
                    <div>
							<a href="login">돌아가기</a>
					</div>
                </form>
            </div>
        </div>
    </div>
</div>


<!-- 	<h1>어서와 운동 하고갈래?</h1>
	<form id="registerForm" Action="/springtrain/registerInsert" method="post">
		<input type="hidden" name="action" value="register">
		이름 : <input id="username" type="text" name="user_id" placeholder="아이디를 입력해주세요" required> <br> <br>
		E-MAIL : <input id="email" type="email" name="email" placeholder="이메일을 입력해주세요" required> <br><br> 
		패스워드 : <input id="passwd" type="password" name="passwd" placeholder="비밀번호를 입력해주세요" required> <br> <br>
			<input id="send" type="submit" value="회원가입"> 
			<input id="cancel" type="reset" value="다시 쓰기">
			<br>
			<br>
			<br>
		<button>
			<a href="login">로그인 페이지로 돌아가기</a>
		</button> -->
	</form>
	<%
		if (request.getAttribute("msg") != null) {
	%>
	<script>
		alert('${msg}')
	</script>
	<%
		}
	%>
</body>
</html>