<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
        <%@ page import="vo.ProductVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%ProductVO vo = (ProductVO)request.getAttribute("data"); %>
<h1>선택된 상품 정보는 다음과 같습니다.</h1><hr>
선택된 사과의 갯수 : <%=vo.getApple()%><br>
선택된 바나나의 갯수 : <%=vo.getBanana()%><br>
선택된 한라봉의 갯수 : <%=vo.getHalabong()%><hr>
<!-- <a href="http://70.12.113.172:8000/mvc/html/product.html" style="background: linear-gradient(yellow, green); text-decoration: none">상품 선택화면</a> -->
<a href="<%=request.getHeader("referer") %>" style="background: linear-gradient(yellow, green); text-decoration: none">상품 선택화면</a>
</body>
</html>