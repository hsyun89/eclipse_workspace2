<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty param.home}">
			<h1>위도 경도를 받아보잣!</h1>
			<form method="get" action="/sedu/jspexam/latlng.jsp">
				<input type="text" name="home" placeholder="주소를 입력해"> 
				<input type="submit">
			</form>
		</c:when>
		<c:otherwise>
			<h1>위도경도는!!</h1>
			<c:catch var="err">  
			  <c:import var="data" 
 url="https://maps.googleapis.com/maps/api/geocode/xml?language=ko&key=AIzaSyCymy5ucS__gaVvSVE_udW4SSO2fLn8MnE" charEncoding="UTF-8">
   <c:param name="address" value="${param.home}"/>
  </c:import>
  <x:parse varDom="wrss" xml="${data}"></x:parse>
				주소: <x:out select="$wrss/GeocodeResponse/result/formatted_address"/> <br>
				위도: <x:out select="$wrss/GeocodeResponse/result/geometry/location/lat"/><br>
				경도: <x:out select="$wrss/GeocodeResponse/result/geometry/location/lng"/>
			</c:catch>
			<c:if test="${!empty err}">
  			 	<h2>오류 발생!!${param.home}</h2>
  				 ${err}
			</c:if> 
		</c:otherwise>
	</c:choose>
</body>
</html>