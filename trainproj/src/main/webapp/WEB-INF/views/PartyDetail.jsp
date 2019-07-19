<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.PartyVO, vo.ParticipantVO, java.util.ArrayList"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.7.js"></script>
<link rel="stylesheet" href="https://unpkg.com/leaflet@1.5.1/dist/leaflet.css"
   integrity="sha512-xwE/Az9zrjBIphAcBb3F6JVqxf46+CDLwfLMHloNu6KEQCAWi6HcDUbeOfBIptF7tcCzusKFjFw2yuvEpDL9wQ=="
   crossorigin=""/>
<script src="https://unpkg.com/leaflet@1.5.1/dist/leaflet.js"
   integrity="sha512-GffPMF3RvMeYyc1LWMHtK8EbPv0iNZ8/oTtHPx9/cc2ILxQ+u905qIwdpULaqDkyBKgOaB57QTMg7ztg8Jm2Og=="
   crossorigin=""></script>
</head>
<style>
section {
	text-align: center;
}

h1 {
	text-align: center;
}

table {
	margin: 10px auto;
	text-align: center;
}

td {
	border-bottom: 1px dotted green;
}

tr:hover {
	background-color: pink;
	font-weight: bold;
}

td:nth-child(1) {
	width: 300px;
}
</style>

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
		ArrayList<ParticipantVO> list = (ArrayList<ParticipantVO>) request.getAttribute("parlist");
		if (request.getAttribute("vo") != null) {
			PartyVO vo = (PartyVO) request.getAttribute("vo");
	%>
	<!-------------------------------- 글 보기 -------------------------------->
	<h1>모임 내용</h1>
	<br>
	<section>
		<h3><%=vo.getTitle()%></h3>
		<%=vo.getUser_id()%><br>
		<hr>
		<%=vo.getLocation()%><br> 인원
		<%=vo.getParty_size()%>명 <br> 현재
		<%=list.size()%>명 참가 중
		<button>멤버보기</button>
		<br>
		<div id="showMember">
			<%
			
/* 			int listsize = 0; */
				/* if (list != null) */
				/* listsize = parlist.size(); */
				if (list != null) {
						for (ParticipantVO parvo : list) {
			%>
			<table>
				<tr>
					<td>ID</td>
					<td><%=parvo.getUser_id()%></td>
				</tr>
			</table>
			<%
				}
					}
			%>
		</div>
		<hr>
		<%=vo.getContents()%>
		<h4><%=vo.getLocation() %></h4>
		<div id="mapid" style="width: 300px; height: 300px;"></div>
		
		<br> <br>

		<div>
			<button onclick="location.href='/springtrain/partymain'">뒤로가기</button>


			<a href="/springtrain/partymain?select=join&action=read&user=<%=session.getAttribute("user_id") %>&post_number=<%=vo.getPost_number() %>">참가하기</a>
			<a href="/springtrain/partymain?select=cancel&action=read&user=<%=session.getAttribute("user_id") %>&post_number=<%=vo.getPost_number() %>">참가취소</a>
			<%-- <form id="joinform" method="get" action="/springtrain/partymain">
				<input type="hidden" name="action" value="join">
				<input type="hidden" name="user" value=<%=vo.getUser_id()%>> 
				<input type="hidden" name="post_number" value=<%=vo.getPost_number()%>>
			</form>
			<form id="cancelform" method="get" action="/springtrain/partymain">
				<input type="hidden" name="action" value="cancel"> 
				<input type="hidden" name="user" value=<%=vo.getUser_id()%>> 
				<input type="hidden" name="post_number" value=<%=vo.getPost_number()%>>
			</form> --%>
<!-- 			<button onclick="document.getElementById('joinform').submit();"
				style="color: green">참가하기</button>
			<button onclick="document.getElementById('cancelform').submit();"
				style="color: green">참가 취소</button> -->
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
	


</body>
</html>