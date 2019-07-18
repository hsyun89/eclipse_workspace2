<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.TrainVO, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>train list</title>
  <style>
.middle{
		text-align: center;
}
.left{
	text-align: left;
}
.right{
 text-align: right;
}
<style>
td {
	border-bottom: 1px dotted black;
}

tr:hover {
	background-color: lightgrey;
	font-weight: bold;
}

td:nth-child(1) {
	width: 50px;
}

td:nth-child(2) {
	width: 50px;
}

td:nth-child(3) {
	width: 50px;
}

td:nth-child(4) {
	width: 50px;
}

td:nth-child(5) {
	width: 400px;
}
td:nth-child(6) {
	width: 50px;
}
form {
	display: inline;
}
</style>
</head>
<body>
<br>
	<h1 class="middle">TRAIN TOGETHER</h1>
	<h5 class="middle">KOREA</h5>
	<br>
	<hr>
	<span class="menu">TRAINING LOG&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
	<span class="menu">TRAIN TOGETHER</span><hr>
	TRAINING LOG<br>
		<%
		ArrayList<TrainVO> list = (ArrayList<TrainVO>) request.getAttribute("list");
	%>
	<table>
		<tr>
			<td>code</td>
			<td>originNo</td>
			<td>groupOrd</td>
			<td>groupLayer</td>
			<td>title<a href="/springtrain/trainmain?action=plusMaster&user_id=test"><img src="/springtrain/resources/images/plus.png"  width=17 align="right"></a></td>
			<td>user_id</td>
		</tr>
		<%
			for (TrainVO vo : list) {
		%>
		<tr>
			<td><%=vo.getCode()%></td>
			<td><%=vo.getOriginNo()%></td>
			<td><%=vo.getGroupOrd()%></td>
			<td><%=vo.getGroupLayer()%></td>
			<td><% for(int i=0;i<vo.getGroupLayer();i++){%>&nbsp;&nbsp;&nbsp;&nbsp;<%}%><a onclick="displayDiv(<%=vo.getCode()%>)" class=<%=vo.getCode()%> style="display:"><%=vo.getTitle()%></a>
			<!-- 수정버튼 클릭 -->
<%-- 			<img  onclick="displayDiv(<%=vo.getCode()%>)" src="/springtrain/resources/images/edit.png"  width=17 align="right"> --%>
			<span class=<%=vo.getCode()%> style="display:none">
			<form method="get">
			<input name="action" type="hidden" value="edit">
			<input name="code" type="hidden" value=<%=vo.getCode() %>>
			<input name="title" type="text" value="<%=vo.getTitle()%>">
			<input type = "submit" value = "확인">
			</form>
			</span>
			<!-- 삭제버튼 클릭 -->
			<a href="/springtrain/trainmain?action=delete&code=<%=vo.getCode()%>&originNo=<%=vo.getOriginNo()%>&groupOrd=<%=vo.getGroupOrd()%>&groupLayer=<%=vo.getGroupLayer()%>"><img src="/springtrain/resources/images/trash.png"  width=20 align="right"></a>
			<!-- 추가버튼 클릭 -->
			<a href="/springtrain/trainmain?action=plus2&code=<%=vo.getCode()%>&originNo=<%=vo.getOriginNo()%>&groupOrd=<%=vo.getGroupOrd()%>&groupLayer=<%=vo.getGroupLayer()%>&user_id=<%=vo.getUser_id()%>"><img src="/springtrain/resources/images/plus.png"  width=17 align="right"></a>
			</td>
			<td><%=vo.getUser_id()%></td>
		</tr>
		<%
			}
		%>
	</table>
  <script> 
	function displayDiv(code) {
		if(document.getElementsByClassName(code)[0].style.display == 'none'){
			document.getElementsByClassName(code)[0].style.display = '';
		}
		else{
			document.getElementsByClassName(code)[0].style.display = 'none';
		}
		if(document.getElementsByClassName(code)[1].style.display == 'none'){
			document.getElementsByClassName(code)[1].style.display = '';
		}
		else{
			document.getElementsByClassName(code)[1].style.display = 'none';
		}
	}
  </script>
</body>
</html>