<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int lottoNum = (int) request.getAttribute("lottoNum");
		int rand = (int) request.getAttribute("rand");
	%>

	<%
		if (lottoNum == rand) {
	%><h1>당첨 ㅊㅋㅊㅋ</h1>
	<img src="http://70.12.113.172:8000/sedu/jspexam/t2.jpg" width="400px">
	<%
		} else {
	%>
	<h1>아쉽아쉽</h1>
	<img src="http://70.12.113.172:8000/sedu/jspexam/t1.jpg" width="400px">
	<br>
	<a href="http://70.12.113.172:8000/sedu/html/lottoForm1.html">한번 더!</a>
	<%
		}
	%>
</body>
</html>