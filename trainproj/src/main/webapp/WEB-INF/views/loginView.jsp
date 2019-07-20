<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.MemberVO, java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o" crossorigin="anonymous"></script>
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
<!-- 부트스트랩 -->
<div class="container">
    <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-success">
            <div class="panel-heading">
                <div class="panel-title"><h1>TRAIN TOGETHER</h1><br></div>
            </div>
            <div class="panel-body">
                <form id="login-form" action="/springtrain/login" method="post">
                		<input type="hidden" name="action" value="login">
                    <div>
                        <input type="text" class="form-control" name="user_id" placeholder="Username" autofocus>
                    </div>
                    <div>
                        <input type="password" class="form-control" name="passwd" placeholder="Password">
                    </div>
                    <div>
                        <button type="submit" class="form-control btn btn-primary">로그인</button>
                    </div>
                    <div>
							<a href="register">회원가입</a>
					</div>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- 형님구현 -->
<!-- 	<h1>운동 가즈아!!!!!!!!!!</h1>
	<form id="loginForm" action="/springtrain/login" method="post">
		<input type="hidden" name="action" value="login">
		이름 : <input id="username" type="text" name="user_id" placeholder="아이디를 입력해주세요"> <br> <br> 
		패스워드 : <input id="passwd" type="password" name="passwd" placeholder="비밀번호를 입력해주세요"> <br> <br> 
		<input id="send" type="submit" value="로그인"> 
		<input id="cancel" type="reset" value="취소">
		<button>
			<a href="register">회원가입</a>
		</button>
	</form> -->
	
	
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