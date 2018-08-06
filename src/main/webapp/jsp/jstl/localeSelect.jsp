<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="/localeSelect">
$("select[name=locale]").val("${param.locale}").prop("selected", true);
		<select id="locale" name="locale">
			<option value=""> </option>
			<option value="ko">한국어</option>
			<option value="ja">日本の語</option>
			<option value="en">English</option>
		</select>
		<button type="submit">전송</button>

	</form>

	<c:set var="Id" value="brown"></c:set>

	<fmt:setLocale value="${param.locale}" />
	<fmt:bundle basename="kr.or.ddit.msg.msg">
		<fmt:message key="hello"></fmt:message>
		<fmt:message key="visitor">
		</fmt:message>
	</fmt:bundle>

</body>
</html>