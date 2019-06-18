<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.util.GregorianCalendar"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name = request.getParameter("name");
		String[] weekDay = { "일", "월", "화", "수", "목", "금", "토" };
		GregorianCalendar cal = new GregorianCalendar();
		int num = cal.get(Calendar.DAY_OF_WEEK) - 1;
		String today = weekDay[num];
		out.print("<h2>" + name + "님 반가워요.. 오늘은 " + today + "요일입니다.</h2>");
	%>
	<h2></h2>
</body>
</html>