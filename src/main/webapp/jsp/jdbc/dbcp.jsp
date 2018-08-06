<%@page import="org.apache.commons.dbcp2.BasicDataSource"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
 	//db설정에 대한 값 설정
 	String driverClassName = "oracle.jdbc.driver.OracleDriver";
 	String url = "jdbc:oracle:thin:@localhost:1521:xe";
 	String username = "pc17";
 	String password	= "java";
	int poolSize = 10;
 	
 	BasicDataSource bds = new BasicDataSource();
 	bds.setDriverClassName(driverClassName);
 	bds.setUrl(url);
 	bds.setUsername(username);
 	bds.setPassword(password);
 	bds.setInitialSize(poolSize);
 	
 	//커넥션을 30번 얻고 해제한다.
 	Connection conn = null;
 	int i = 0;
 	try {
	 	long startTime = System.currentTimeMillis();
	 	
	 	for(; i < 30; i++) {
		 	conn = bds.getConnection();
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
	bds.close();
 %>
	
	
	
	
</body>
</html>