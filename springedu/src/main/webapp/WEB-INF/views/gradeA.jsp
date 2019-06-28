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
		String grade = (String)request.getAttribute("grade");
	  	String name = request.getParameter("name");
	%>
	<h1><%= name %>님은 <%= grade%>등급입니다. 우수한 성적이네요^^</h1>
	
	<hr>
	
	<h1>${param.name }님은 ${grade }등급입니다. 우수한 성적이네요^^</h1>
</body>
</html>