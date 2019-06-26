<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
td {
	border-bottom: 1px dotted red;
}

tr:hover {
	background-color: pink;
	font-weight: bold;
}

td:nth-child(3) {
	width: 400px;
}
</style>
</head>
<body>
	<c:if test="${!empty list }">
		<h2>방명록 글 리스트-JSTL</h2>
		<hr>
		<table>
			<c:forEach var="vo" items="${list }">
				<tr>
					<td>${vo.name }</td>
					<td>${vo.writeDate }</td>
					<td>${vo.memo}</td>
					<td><a href='/mvc/visitor?id=${vo.id }'><img
							src="/mvc/images/delete.png" width="30"></a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${!empty msg }">
		<h2>${msg}</h2>
	</c:if>
	<hr>
	<a href='  ${header.referer}'>방명록 홈 화면으로 가기</a>
</body>
</html>