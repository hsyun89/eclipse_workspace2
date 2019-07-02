<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>연산 요청 결과(스크립트 태그)</h1><hr>
결과 : <%=request.getAttribute("result") %><br>
<a href="<%=request.getHeader("referer") %>">입력화면</a>
<hr>
<h1>연산 요청 결과(EL)</h1><hr>
결과 : ${result }<br>
<a href="<%=request.getHeader("referer") %>">입력화면</a>
</body>
</html>