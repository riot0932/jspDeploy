<%@tag import="java.sql.SQLException"%>
<%@tag import="java.sql.DriverManager"%>
<%@tag import="java.sql.ResultSet"%>
<%@tag import="java.sql.PreparedStatement"%>
<%@tag import="java.sql.Statement"%>
<%@tag import="java.sql.Connection"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String user = "pc152";
String pass = "java";

Connection conn =null;
Statement  stmt = null;
PreparedStatement pstmt = null;
ResultSet rs =null;

try {
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	conn = DriverManager.getConnection(url, user, pass);
	stmt = conn.createStatement();
	pstmt = conn.prepareStatement("SELECT prod_id, prod_name FROM prod WHERE prod_lgu='P101'");
	rs=pstmt.executeQuery();
	
	while(rs.next()) {%>
		<select>
			<option value="<%=rs.toString()%>"></option>
		</select>
<% 	}
	conn.close();
	
}catch (SQLException e) {
	e.printStackTrace();		
}finally {
	if(rs!=null) try {rs.close();} catch (SQLException e) {}
	if(stmt!=null) try {stmt.close();} catch (SQLException e) {}
	if(conn!=null) try {conn.close();} catch (SQLException e) {}
}

%>

