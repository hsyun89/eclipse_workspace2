<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.TrainVO, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o" crossorigin="anonymous"></script>
 
 <title>TRAIN TOGETHER</title>
  <style>
 img{
 	vertical-align: top;
 }
      body {
        background: #f8f8f8;
/*         background: #f8f8f8; */
        padding-bottom: 60px 0;
    }
 a{
	text-decoration:none;
	color: #000000;
}
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
table{
	margin: auto;
}
tr:hover {
	background-color: lightgrey;
	font-weight: bold;
}
body{
	font-size: 20px;
}
/* td:nth-child(1) {
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
	width: 500px;
}
td:nth-child(6) {
	width: 50px;
} */
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
	<hr>&nbsp;&nbsp;&nbsp;&nbsp;
	<img src="/springtrain/resources/images/list.png"  width="35">
	<span class="menu">&nbsp;&nbsp;<a href="/springtrain/trainmain">TRAINING LOG</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
	<span class="menu"><a href="/springtrain/partymain">TRAIN TOGETHER</a></span>
	<span style="float: right;">
	<form action="/springtrain/logout" method="post">
		<input class="btn btn-secondary btn-sm pull-right" id="logout" type="submit" value="로그아웃">
	</form>&nbsp;&nbsp;&nbsp;&nbsp;
	</span>
	<hr>
<div class="container">
	<h5 class="middle">TRAINING LOG</h5>
	<div style="margin:0 auto" align="center">
	<a class="btn btn-secondary btn-sm" href="/springtrain/trainmain?action=expandAll">모두펼치기</a>
	<a class="btn btn-secondary btn-sm" href="/springtrain/trainmain?action=collapseAll">모두접기</a>
	</div>
		<%
		ArrayList<TrainVO> list = (ArrayList<TrainVO>) request.getAttribute("list");
	%>

	<table>
		<tr>
 			<td>code</td>
			<td>originNo</td>
			<td>groupOrd</td>
			<td>groupLayer</td>
			<td>flag</td>
			<td>collapse</td>
			<td width="900px"><a href="/springtrain/trainmain?action=plusMaster&user_id=test"><img src="/springtrain/resources/images/plus.png"  width=25 align="right"></a></td>
<!-- 			<td>user_id</td> -->
		</tr>
		<%
			for (TrainVO vo : list) {
		%>
			<!-- 플래그가 0이면 안보이기, 1이면 보이기 -->
			<% String para = "";
				if(vo.getFlag()==1){
					para="";
				}else{
					para="none";
				}
			%>
<!-- 		collapse가 1인 상태에서 누르면 접기쿼리, 0인 상태에서 클릭하면 펼치기쿼리-->
			<% String collPara="";
			if(vo.getCollapse()==1){
				collPara="collapse";
			}else{
				collPara="expand";
			}
			%>		
		<tr style="display:<%=para%>">
<!-- 			<tr> -->
 			<td><%=vo.getCode()%></td>
			<td><%=vo.getOriginNo()%></td>
			<td><%=vo.getGroupOrd()%></td>
			<td><%=vo.getGroupLayer()%></td>
			<td><%=vo.getFlag() %></td>
			<td><%=vo.getCollapse() %></td>
			<td><% for(int i=0;i<vo.getGroupLayer();i++){%>&nbsp;&nbsp;&nbsp;&nbsp;<%}%><a href="/springtrain/trainmain?action=<%=collPara%>&code=<%=vo.getCode()%>&originNo=<%=vo.getOriginNo()%>&groupOrd=<%=vo.getGroupOrd()%>&groupLayer=<%=vo.getGroupLayer()%>"><img src="/springtrain/resources/images/image<%=vo.getGroupLayer() %>.png"  width=25></a>&nbsp;<a onclick="displayDiv(<%=vo.getCode()%>)" class=<%=vo.getCode()%> style="display:"><%=vo.getTitle()%></a>
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
			<a href="/springtrain/trainmain?action=delete&code=<%=vo.getCode()%>&originNo=<%=vo.getOriginNo()%>&groupOrd=<%=vo.getGroupOrd()%>&groupLayer=<%=vo.getGroupLayer()%>"><img src="/springtrain/resources/images/trash.png"  width=25 align="right"></a>
			<!-- 추가버튼 클릭 -->
			<a  href="/springtrain/trainmain?action=plus2&code=<%=vo.getCode()%>&originNo=<%=vo.getOriginNo()%>&groupOrd=<%=vo.getGroupOrd()%>&groupLayer=<%=vo.getGroupLayer()%>&user_id=<%=vo.getUser_id()%>"><img src="/springtrain/resources/images/plus.png"  width=25 align="right"></a>
			</td>
<%-- 			<td><%=vo.getUser_id()%></td> --%>
		</tr>
		<%
			}
		%>
	</table>
	</div>
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
<!-- Footer -->
<footer class="page-footer font-small blue">

  <!-- Copyright -->
  <div class="footer-copyright text-center py-3">© 2019 Copyright:
    <a href="https://mdbootstrap.com/education/bootstrap/"> goblins.com</a>
  </div>
  <!-- Copyright -->

</footer>
<!-- Footer -->
</body>
</html>