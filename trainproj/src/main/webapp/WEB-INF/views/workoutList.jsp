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
			<td>title</td>
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
			<td><%=vo.getTitle()%></td>
			<td><%=vo.getUser_id()%></td>

		</tr>
		<%
			}
		%>
	</table>
  <script>
	
  </script>
</body>
</html>