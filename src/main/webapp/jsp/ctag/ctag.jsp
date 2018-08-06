<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>logging</h3>
<tags:logging></tags:logging><br>

<c:forEach items="${studentList }" var="student">
	${student.id }/${student.name }/${studnet.call_cnt } <fmt:formatDate value="${ student.REG_DT}"/><br>
</c:forEach>

<h3>colorLogging</h3>
<tags:colorLogging color="red" size="20"></tags:colorLogging><br>
<c:forEach items="${studentList }" var="student">
	${student.id }/${student.name }/${studnet.call_cnt } <fmt:formatDate value="${ student.REG_DT}"/><br>
</c:forEach>
<br><br><br>
<tags:prodSelect var="" value=""></tags:prodSelect>

</body>
</html>