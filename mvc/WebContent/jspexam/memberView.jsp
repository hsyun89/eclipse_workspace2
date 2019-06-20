<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="vo.MemberVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원 정보</h1><hr>
<ul><%MemberVO vo = (MemberVO)request.getAttribute("data"); %>
	<li>회원 이름 : <%=vo.getName() %></li>
	<li>회원 계정 : <%=vo.getId() %></li>
	<li>회원 암호 : <%=vo.getPass()%></li>
	<li>회원 전화번호 : <%=vo.getPhone() %></li>
</ul>
</body>
</html>