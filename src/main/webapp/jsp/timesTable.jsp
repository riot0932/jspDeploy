<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>	
	td {
		border : 1px solid blue;
		text-align : center;
	}
</style>
</head>
<body>
	<table>
	<% for (int i = 1; i < 10; i++) { %>
		<tr>
		<% for (int j = 2; j < 10; j++) { %>
		<!-- html -->
			<td>
				<%=j %>*<%=i %>=<%=i*j %>
			</td>
		<% } %>
		</tr>
	<%}%>
	</table>
</body>
</html>


<!--
	localhost:8180/jsp/timesTable.jsp
 -->