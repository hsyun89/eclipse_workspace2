<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.vo.NewsVO, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
td {
	border-bottom: 1px dotted black;
}
tr:hover {
	background-color: lightgrey;
	font-weight: bold;
}
td:nth-child(1){
	width: 50px;
}
td:nth-child(2){
	width: 400px;
}
td:nth-child(3){
	width: 100px;
}
td:nth-child(4){
	width: 100px;
}
td:nth-child(5){
	width: 50px;
}
</style>
</head>
<body>
	<%
 		ArrayList<NewsVO> list = (ArrayList<NewsVO>) request.getAttribute("list");
		if (list != null) {
	%>
	<h2>뉴스 게시판</h2><hr>
	<table>
	<tr>
	<td>번호</td>
	<td>제목</td>
	<td>작성자</td>
	<td>작성일</td>
	<td>조회수</td>
	</tr>
		<%
			for (NewsVO vo : list) {
		%>
		<tr>
			<td><%=vo.getId()%></td>
			<td class='<%=vo.getId() %>'><a href='/mvc/news?action=read&newsid=<%=vo.getId()%>'><%=vo.getTitle()%></a></td>
			<td class='<%=vo.getId() %>'><%=vo.getWriter()%></td>
			<td class='<%=vo.getId() %>'><%=vo.getWritedate()%></td>
			<td class='<%=vo.getId() %>'><%=vo.getCnt()%></td>

		</tr>
		<%
			}
		%>
	</table>
	<button onclick="displayDiv(1);">뉴스 작성</button>
		<div id="write" style="display:none">
		<form method="post" action="/mvc/news">
		<input type="hidden" name="action" value="insert">
		
		<input id="m_writer"type="text" name="writer" placeholder="작성자명을 입력하라"><br>
		<input id="m_title"type="text" name="title"placeholder="제목을 입력하라"><br>
		<textarea id="m_content"name = "content" rows="20" cols="50"placeholder="내용을 입력하라"></textarea><br>

		<input type="submit" value="저장">
		<input type="reset"value="재작성">
		<input type="button" onclick="displayDiv(2);"value=취소>
		<br>
	</form>
	</div>
	
	<script>
	function displayDiv(type) {
		if(type==1){
			document.getElementById("write").style.display='block';
		}else if(type==2){
			document.getElementById("write").style.display='none';
		}
	}
	</script>
	<%
		}else {
			NewsVO listOne = (NewsVO) request.getAttribute("listOne");
			%>
			<h1>뉴스 내용</h1>
					<form method="post" action="/mvc/news">
		<input type="hidden" name="action" value="insert">
		
		<input id="m_writer"type="text" name="writer" placeholder="작성자명을 입력하라"><br>
		<input id="m_title"type="text" name="title"placeholder="제목을 입력하라"><br>
		<textarea id="m_content"name = "content" rows="20" cols="50"placeholder="내용을 입력하라"></textarea><br>

		<input type="submit" value="저장">
		<input type="reset"value="재작성">
		<input type="button" onclick="displayDiv(2);"value=취소>
		<br>
			
			
			
			<%
		}
	%>
	

</body>
</html>