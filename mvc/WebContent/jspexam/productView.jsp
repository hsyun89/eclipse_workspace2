<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.ProductVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		ProductVO vo = (ProductVO) request.getAttribute("data");
	%>
	<h1>선택된 상품 정보는 다음과 같습니다.(스크립트 태그)</h1>
	<hr>
	선택된 사과의 갯수 :
	<%=vo.getApple()%><br> 선택된 바나나의 갯수 :
	<%=vo.getBanana()%><br> 선택된 한라봉의 갯수 :
	<%=vo.getHalabong()%><hr>
	<a href="<%=request.getHeader("referer")%>"
		style="background: linear-gradient(yellow, green); text-decoration: none">상품
		선택화면</a>

	<hr>
	<jsp:useBean id="data" class="vo.ProductVO" scope="session"></jsp:useBean>
	<h1>선택된 상품 정보는 다음과 같습니다.(액션 태그)</h1>
	<hr>
	선택된 사과의 갯수 :
	<jsp:getProperty property="apple" name="data"/><br> 선택된 바나나의 갯수 :
	<jsp:getProperty property="banana" name="data"/><br> 선택된 한라봉의 갯수 :
	<jsp:getProperty property="halabong" name="data"/><hr>
	<a href="<%=request.getHeader("referer")%>"
		style="background: linear-gradient(yellow, green); text-decoration: none">상품
		선택화면</a>
		
		<hr>
		
	<h1>선택된 상품 정보는 다음과 같습니다.(EL)</h1>
	<hr>
	선택된 사과의 갯수 :
	${data.apple }<br> 선택된 바나나의 갯수 :
	${sessionScope.data.banana }<br> 선택된 한라봉의 갯수 :
	${sessionScope.data.halabong }<hr>
	<a href="<%=request.getHeader("referer")%>"
		style="background: linear-gradient(yellow, green); text-decoration: none">상품
		선택화면</a>
</body>
</html>