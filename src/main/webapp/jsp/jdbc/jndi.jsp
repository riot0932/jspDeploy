<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- db connection 얻는 방법 3가지
		1. jdbc
		2. application connection pool
		3. WAS connection pool (jndi)
		
		각 방법별로 커넥션 생성하는 시간 profiling
	 -->
	 
 <%
 	Context context = new InitialContext();
 	
	DataSource datasource = (DataSource) context.lookup("java:comp/env/jdbc/oracleDB");
 	
	//커넥션을 30번 얻고 해제한다.
	Connection conn = null;
 	int i = 0;
 	try {
	 	long startTime = System.currentTimeMillis();
	 	
	 	for(; i < 30; i++) {
		 	conn = datasource.getConnection();
		 	out.write("schema : " + conn.getSchema() + "<br>");
		 	conn.close();
	 	}
	 	long endTime = System.currentTimeMillis();
	 	
	 	out.write("during : " + (endTime - startTime) + "ms");	 	
 	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		if(conn!=null) try { conn.close(); } catch (SQLException e2) { e2.printStackTrace(); }
	}
 	
 %>
</body>
</html>