<%@page import="java.text.SimpleDateFormat"%>
<%@page import="kr.or.ddit.board.model.BoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%List<BoardVo> boardlist = (List)session.getAttribute("boardList"); %>
	List :<br> <%=boardlist	%> 
<table>
	<% SimpleDateFormat sdf = new SimpleDateFormat("yyyy-DD-mm"); %>
	
	<thead>
		<tr>
			<th>제목</th>
			<th>사용자 아이디</th>
			<th>별명</th>
			<th>등록일 (yyyy-mm-dd)</th>
		</tr>
	</thead>
	
		

</table>

</body>
</html>