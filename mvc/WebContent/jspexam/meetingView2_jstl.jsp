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
td:nth-child(3){
	width: 400px;
}
</style>
</head>
<body>
	<c:if test="${!empty list }">
	<h2>미팅 정보 리스트(2)</h2><hr>
	<table>
<c:forEach var="vo" items="${list }">
		<tr>
			<td>${vo.id }</td>
			<td class='${vo.id}'>${vo.name}</td>
			<td class='${vo.id}'>${vo.title}</td>
			<td class='${vo.id}'>${vo.meetingDate}</td>
			<td><a href='/mvc/meeting?action=delete&id=${vo.id}'><img src="/mvc/images/delete.png" width="30"></a></td>
			<td><img onclick="displayUpdateForm('${vo.id}')" src="/mvc/images/edit.png" width="30"></td>
		</tr>
</c:forEach>
	</table>
	</c:if>
	<c:if test="${!empty msg }">
	<script>
	alert("${msg}");
	</script>
</c:if>
	<hr>
	<button onclick="displayDiv(1);">미팅 정보 작성</button>
	<button onclick="displayDiv(2);">미팅 정보 검색</button>
	<script>
	function displayDiv(type) {
		if(type==1){
			document.getElementById("search").style.display='none';
			document.getElementById("write").style.display='block';
		}else if(type==2){
			document.getElementById("write").style.display='none';
			document.getElementById("search").style.display='block';
		}
	}
	function displayUpdateForm(cv){
		var doms = document.getElementsByClassName(cv)
		document.getElementById("write").style.display='block';
		document.getElementById("m_name").value=doms[0].textContent;
		document.getElementById("m_title").value=doms[1].textContent;
		var str =doms[2].textContent;
		var ary=str.split(/\D+/g)
		var meeting_dt=ary[0]+"-"+ary[1]+"-"+ary[2]+"T"+ary[3]+":"+ary[4];
		document.getElementById("m_dt").value=meeting_dt;
		document.getElementById("divT").textContent="미팅정보 수정";
		document.querySelector("#write [type=submit]").value="수정";
		document.querySelector("#write [type=hidden]").value=cv;
	}
	</script>
	<div id="write" style="display:none">
	<hr><h2 id="divT">미팅정보 작성</h2>
		<form method="post" action="/mvc/meeting">
		<input type="hidden" name="action" value="insert">
		미팅 대상 이름 : <input id="m_name"type="text" name="name">
		<br> 
		미팅 목적 : 
		<br>
		<textarea id="m_title"name = "title" rows="20" cols="50"></textarea>
		<br>
		날짜와 시간 : 
		<input id="m_dt"type="datetime-local" name="meetingDate">
		<br>
		<input type="submit" value="등록">
		<input type="reset"value="재작성">
		<br>
	</form>
	</div>
	<div id="search" style="display:none">
		<form method="get" action="/mvc/meeting">
		<input type="button" onclick="link()"value="미팅 전체 리스트"><br>
검색어 : <input type="search" name="keyword">
<input type="submit" value="검색">
</form>
	</div>
	
	<script>
	function link(){
		 location.href="/mvc/meeting";
	}
</script>
</body>
</html>