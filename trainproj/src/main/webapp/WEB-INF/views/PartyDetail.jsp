<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.PartyVO, vo.ParticipantVO, java.util.ArrayList"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" 
	integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" 
	crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<title>TRAIN TOGETHER</title>
<link rel="stylesheet" href="https://unpkg.com/leaflet@1.5.1/dist/leaflet.css"
   integrity="sha512-xwE/Az9zrjBIphAcBb3F6JVqxf46+CDLwfLMHloNu6KEQCAWi6HcDUbeOfBIptF7tcCzusKFjFw2yuvEpDL9wQ=="
   crossorigin=""/>
<script src="https://unpkg.com/leaflet@1.5.1/dist/leaflet.js"
   integrity="sha512-GffPMF3RvMeYyc1LWMHtK8EbPv0iNZ8/oTtHPx9/cc2ILxQ+u905qIwdpULaqDkyBKgOaB57QTMg7ztg8Jm2Og=="
   crossorigin=""></script>
</head>
<style>
 img{
 	vertical-align: top;
 }
 a{
	text-decoration:none;
	color: #000000;
}
.middle{
		text-align: center;
}
table {
	margin: auto;
}
tr {
	border-bottom: 1px solid lightgrey;
}
td:nth-child(0) {
	width: 100px;
}
td:nth-child(1) {
	width: 100px;
}
body{
	font-size: 20px;
}
</style>

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
		<input class="btn btn-secondary btn-sm id="logout" type="submit" value="로그아웃">
	</form>&nbsp;&nbsp;&nbsp;&nbsp;
	</span><hr>
	<div class="container">
	<%
		ArrayList<ParticipantVO> list = (ArrayList<ParticipantVO>) request.getAttribute("parlist");
		if (request.getAttribute("vo") != null) {
			PartyVO vo = (PartyVO) request.getAttribute("vo");
	%>
	<!-------------------------------- 글 보기 -------------------------------->
	<br>
	<section name="article">
	<table class="table">
	<tr>
	<td>Title</td>
	<td><%=vo.getTitle()%></td>
	</tr>
	<tr>
	<td>ID</td>
	<td><%=vo.getUser_id()%></td>
	</tr>
	<tr>
	<td>인원</td>
	<td><%=vo.getParty_size()%>명</td>
	<tr>
	<td>현재</td><td><%=list.size()%>명 참가 중
		<div id="showMember">
			<%
				if (list != null) {
						for (ParticipantVO parvo : list) {
			%>
			<table style="float: left;", frame=void>
				<tr>
					<td><img src="/springtrain/resources/images/고블린.png" width=60></td>
					<td>					<!-- Button trigger modal -->
						<button type="button" class="btn btn-secondary btn-lg" data-toggle="modal" data-target="#<%=parvo.getUser_id()%>">
						<%=parvo.getUser_id()%>
						</button>
					</td>
<!-- Modal -->
<div class="modal fade" id="<%=parvo.getUser_id()%>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title" id="myModalLabel">EMAIL</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
      </div>
      <div class="modal-body">
       <%=parvo.getEmail()%>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">확인</button>
      </div>
    </div>
  </div>
</div>
				</tr>
			</table>
			<%
				}
					}
			%>
			</td>
		</tr>
		</div>
		<tr>
		<td>내용</td>
		<td><%=vo.getContents()%></td>
		</tr>
		<tr>
			<td>위치</td>
		<td><%=vo.getLocation() %>
		<div id="mapid" style="width: 725px; height: 500px;margin:20px 0px"></div></td>
		</tr>
		</table>

		<div style="margin:0 auto" align="center">
			<button class="btn btn-secondary  btn-sm" onclick="location.href='/springtrain/partymain'">뒤로가기</button>
			<a class="btn btn-secondary  btn-sm" href="/springtrain/partymain?select=join&action=read&user=<%=session.getAttribute("user_id") %>&post_number=<%=vo.getPost_number() %>">참가하기</a>
			<a class="btn btn-secondary  btn-sm" href="/springtrain/partymain?select=cancel&action=read&user=<%=session.getAttribute("user_id") %>&post_number=<%=vo.getPost_number() %>">참가취소</a>
		</div>

	</section>
	
	<%
		if (request.getAttribute("msg") != null) {
	%>
	<script>
		alert('${ msg }');
	</script>
	<%
		}
	%>
	
	<script>
		function displayDiv(type) {
			if (type == 1) {
				document.getElementById("showMember").style.display = 'block';
			}
		}
			var mymap;
			var address = "<%=vo.getLocation()%>";
			if (address) {		
				$.getJSON("https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyD-nx_y7aBlJgfgVZRaIwMbnShQJsxpryY&address="+encodeURIComponent(address), function(data) {
					lat = data.results[0].geometry.location.lat;
					lng = data.results[0].geometry.location.lng;
					mymap = L.map('mapid').setView([lat, lng], 16)
					L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpejY4NXVycTA2emYycXBndHRqcmZ3N3gifQ.rJcFIG214AriISLbB6B5aw', {
						maxZoom: 18,
						attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, ' +
							'<a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
							'Imagery <a href="https://www.mapbox.com/">Mapbox</a>',
						id: 'mapbox.streets'
					}).addTo(mymap);

					L.marker([lat, lng]).addTo(mymap);   
				});
			}
		showPosition("<%=vo.getLocation()%>");
	</script>

	<%
		}
	%>
	

</div>
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