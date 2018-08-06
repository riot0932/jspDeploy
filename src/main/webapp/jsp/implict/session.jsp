<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	sumResult : <%=request.getAttribute("sumResult") %> <br>
	
	<%
		HttpSession sess = request.getSession();
	%>
	
	<!-- 기본객체 session -->
	기본객체 sumResult : <%=session.getAttribute("sumResult") %> <br>
	
	<!-- request 객체 session -->
	request 객체 sumResult : <%=sess.getAttribute("sumResult") %> <br>
	
	<!-- localhost:8280/jsp/implict/session.jsp -->

</body>
</html>