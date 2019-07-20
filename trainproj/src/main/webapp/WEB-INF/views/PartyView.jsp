<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.PartyVO, java.util.ArrayList"%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o" crossorigin="anonymous"></script>
<title>TRAIN TOGETHER</title>
<script src="http://code.jquery.com/jquery-1.7.js"></script>
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
:mymap{
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
/* .tableTitle:hover {
	background-color: lightgrey;
	font-weight: bold;
} */
tr{
	border-bottom:1px solid lightgrey;
}
table{
	margin : auto;
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
	width: 400px;
}
td:nth-child(6) {
	width: 50px;
} */
form {
	display: inline;
}
</style>
<body>
<br>
	<h1 class="middle">TRAIN TOGETHER</h1>
	<h5 class="middle">KOREA</h5>
	<br>
	<hr>
		<img src="/springtrain/resources/images/list.png"  width="25">
	<span class="menu">&nbsp;&nbsp;<a href="/springtrain/trainmain">TRAINING LOG</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
	<span class="menu"><a href="/springtrain/partymain">TRAIN TOGETHER</a></span>
		<span style="float: right;">
	<form action="/springtrain/logout" method="post">
		<input class="btn btn-default btn-sm pull-right" id="logout" type="submit" value="로그아웃   ">
	</form>
	</span><hr>
<div class="container">
	<%
if(request.getAttribute("vo") != null) {
	  PartyVO vo = (PartyVO)request.getAttribute("vo");
%>
	<!-------------------------------- 글 수정 -------------------------------->
	<section>
<div>
	<form id="updateform" method="post" action="/springtrain/partymain">
		<input type="hidden" name="action" value="update">
		<input type="hidden" name="post_number" value="<%= vo.getPost_number() %>">
		<table class="table">
		<tr>
		<td>Title</td><td><input type="text" size="40"  name="title" value="<%= vo.getTitle() %>"></td>
		</tr>
		<tr>
		<td>ID</td><td><%=vo.getUser_id()%></td>
		<tr>
		</tr>
		<tr>
		<td>장소</td><td><%=vo.getLocation() %></td>
		</tr>
		<tr>			
		<td>인원</td><td><input type="int" size="40"  name="party_size" value="<%= vo.getParty_size() %>"></td>
		<tr>	
		<td>현재</td>
		<td><%=vo.getParticipant_size()%>명 참가 중</td>
		</tr>
		<tr>
		<td>내용</td><td><textarea  cols="100"  rows="10" name="contents"><%= vo.getContents() %></textarea></td>
		</tr>		
	</table>
		<input type ="text" id ="address_revise" name="location" value = "<%=vo.getLocation() %>">
		<button type="button" onclick="showMap();">위치보기</button>
		<div id="mapid_revise" style="width: 300px; height: 300px;"></div>
	</form>	
	<button onclick="location.href='/springtrain/partymain'">확인</button>
	<button onclick="document.getElementById('updateform').submit();">수정</button>
	<button onclick="location.href='/springtrain/partymain?action=delete&post_number=<%= vo.getPost_number() %>'">삭제</button>
</div>

<script>
	var mymap;
	var address = $('#address_revise').val();
		if (address) {		
			$.getJSON("https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyD-nx_y7aBlJgfgVZRaIwMbnShQJsxpryY&address="+encodeURIComponent(address), function(data) {
				lat = data.results[0].geometry.location.lat;
				lng = data.results[0].geometry.location.lng;
				mymap = L.map('mapid_revise').setView([lat, lng], 16)
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
function showMap() {
	var lat;
	var lng;
	var address = $('#address_revise').val();
	if (address) {		
		$.getJSON("https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyD-nx_y7aBlJgfgVZRaIwMbnShQJsxpryY&address="+encodeURIComponent(address), function(data) {
			lat = data.results[0].geometry.location.lat;
			lng = data.results[0].geometry.location.lng;
			if(mymap) {
				mymap.remove();
			}
			mymap = L.map('mapid_revise').setView([lat, lng], 16)
			L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpejY4NXVycTA2emYycXBndHRqcmZ3N3gifQ.rJcFIG214AriISLbB6B5aw', {
				maxZoom: 18,
				attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, ' +
					'<a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
					'Imagery <a href="https://www.mapbox.com/">Mapbox</a>',
				id: 'mapbox.streets'
			}).addTo(mymap);


			L.marker([lat, lng]).addTo(mymap)
				.bindPopup("<b>여기...").openPopup();   
		});
	}
	else{
		alert("주소없음");
	}
}
</script>

</section>
<%
} else {
	ArrayList<PartyVO> list = (ArrayList<PartyVO>) request.getAttribute("list");
	int listsize = 0;
	if(list!=null) listsize =list.size();
%>
	<!-------------------------------- 글 목록 -------------------------------->

	<section>
	<h5 class="middle">Train-Together</h5>
	<table class = "table table-hover">
	<tr >
		<td style="text-align:center;" >번호</td>
		<td style="text-align:center;" >제목</td>
		<td style="text-align:center;" >장소</td>
		<td style="text-align:center;" >인원</td>
		<td style="text-align:center;" >작성일</td>
		<td style="text-align:center;" >작성자</td>
	</tr>
		<%
		if(list != null) {
			for (PartyVO vo : list) {
		%>
		<tr>
			<td width="50px" style="text-align:center;"><%=vo.getPost_number()%></td>
			<td width="400px"><a href="/springtrain/partymain?action=read&post_number=<%=vo.getPost_number()%>"><%=vo.getTitle()%></a></td>
			<td width="200px"><%=vo.getLocation()%></td>
			<td width="50px" style="text-align:center;"><%=vo.getParticipant_size()%>/<%=vo.getParty_size()%></td>
			<td width="200px" style="text-align:center;"><%=vo.getWrite_date()%></td>		
			<td width="100px" style="text-align:center;"><%=vo.getUser_id() %></td>
		</tr>
		<%
			}
		}
		%>
	</table>

	<FORM name="search" method="get" action="/springtrain/partymain">
 <input type="hidden" name="action" value="search">
     <SELECT name='col' style="width: 85px; height: 30px;" >
       <OPTION value="contents">내용</OPTION>
       <OPTION value="location">장소</OPTION>
       <OPTION value="title">제목</OPTION>
       <OPTION value="user_id">작성자</OPTION>
     </SELECT>
     <input id="search" type="text" name="keyword" style="height: 20px;">
     <button type='submit'>검색</button>
 </FORM>

	
	<!-------------------------------- 글 작성 -------------------------------->
	<button class="btn" onclick="displayDiv(1);">글쓰기</button>
	<script>
	function displayDiv(type) {
			if (type == 1) {
				document.getElementById("insertform").style.display='block';
			}
	}
	</script>
	<div id="insertform" style="display:none">
		<form method="post" action="/springtrain/partymain">
		<input type="hidden" name = "action" value ="insert">
			<table>
				<tr>
					<td>제목</td>
					<td><input type="text" id="m_title" name="title"  placeholer="제목을 입력하세요"></td>
					<tr>
					<td>인원</td>
					<td><input  type="int" id="m_size" name="party_size" placeholer="최대인원을 입력하세요"></td>
				<tr>
					<td>내용</td>
					<td><textarea   cols="30"  rows="5" name="contents" placeholder="내용을 입력하세요" ></textarea></td>
				</tr>
				
			</table>
			<input type ="text" id ="address" name="location" placeholer="장소를 입력하세요"><button type="button" onclick="showPosition();">위치보기</button>
	

			<div id="mapid" style="width: 300px; height: 300px;"></div>
			<br> <input type="submit" value="등록"> <input type="reset" value="재작성">
		</form>

		<script>
			var mymap;
		function showPosition() {
			var address = $('#address').val();
			if (address) {		
				$.getJSON("https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyD-nx_y7aBlJgfgVZRaIwMbnShQJsxpryY&address="+encodeURIComponent(address), function(data) {
					lat = data.results[0].geometry.location.lat;
					lng = data.results[0].geometry.location.lng;
					if(mymap)
						mymap.remove();
					mymap = L.map('mapid').setView([lat, lng], 16)
					L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpejY4NXVycTA2emYycXBndHRqcmZ3N3gifQ.rJcFIG214AriISLbB6B5aw', {
						maxZoom: 18,
						attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, ' +
							'<a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
							'Imagery <a href="https://www.mapbox.com/">Mapbox</a>',
						id: 'mapbox.streets'
					}).addTo(mymap);


					L.marker([lat, lng]).addTo(mymap)
						.bindPopup("<b>여기...").openPopup();   
				});
			}
			else{
				alert("주소없음");
			}
		}
		
		
	</script>
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
	}
	%>
	</div>
</body>
</html>