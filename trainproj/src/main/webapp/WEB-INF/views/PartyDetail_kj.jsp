<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.PartyVO, vo.ParticipantVO, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

tr.a {
	background-color: pink;
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
	<!-- user -->
	<%
		if (request.getAttribute("vo") != null) {
			PartyVO vo = (PartyVO) request.getAttribute("vo");
	%>
	<!-------------------------------- 글 수정 -------------------------------->
	<h1>모임 내용</h1>
	<br>
	<section>
		<h3><%=vo.getTitle()%></h3>
		<%=vo.getUser_id()%><br>
		<hr>
		<%=vo.getLocation()%><br> 인원
		<%=vo.getParty_size()%>명 <br> 현재
		<%=vo.getParticipant_size()%>명 참가 중
		<button>멤버보기</button>
		<br>
		<div id="showMember">
			<%
			ArrayList<ParticipantVO> parlist = (ArrayList<ParticipantVO>) request.getAttribute("parlist");
			int listsize = 0;
			if (parlist != null)
				listsize = parlist.size();
				if (parlist != null) {
						for (ParticipantVO parvo : parlist) {
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

		<br> <br>

		<div>
		<%
			String user = vo.getUser_id(); 
		%>
			<button onclick="location.href='/springtrain/partymain'">뒤로가기</button>

			<form id="joinform" method="get" action="/springtrain/partymain">
				<input type="hidden" name="action" value="join"> <input
					type="hidden" name="user" value=<%=user%>> <input
					type="hidden" name="post_number" value=<%=vo.getPost_number()%>>
			</form>
			<button onclick="document.getElementById('joinform').submit();"
				style="color: green">참가하기</button>
			
			<form id="cancelform" method="get" action="/springtrain/partymain">
				<input type="hidden" name="action" value="cancel"> <input
					type="hidden" name="user" value=<%=user%>> <input
					type="hidden" name="post_number" value=<%=vo.getPost_number()%>>
			</form>
			<button onclick="document.getElementById('cancelform').submit();"
				style="color: green">참가 취소</button>
		</div>

	</section>
	<script>
		function displayDiv(type) {
			if (type == 1) {
				document.getElementById("showMember").style.display = 'block';
			}
		}
	</script>

	<%
		}
	%>

	<%
		if (request.getAttribute("msg") != null) {
	%>
	<script>
		alert('${ msg }');
	</script>
	<%
		}
	%>

</body>
</html>