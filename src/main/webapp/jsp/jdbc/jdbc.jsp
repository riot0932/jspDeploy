<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
		1. jdbc   ==> 많은 loop가 적용되면 느려진다.
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
 	
 	Class.forName(driverClassName);
 	//커넥션을 30번 얻고 해제한다.
 	Connection conn = null;
 	try {
	 	long startTime = System.currentTimeMillis();
	 	
	 	for(int i = 0; i < 30; i++) {
		 	conn = DriverManager.getConnection(url, username, password);
		 	out.write("schema : " + conn.getSchema() + "<br>");
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