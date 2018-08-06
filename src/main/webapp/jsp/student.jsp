<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	#std_table {
		background-color : #ddd;
		text-align : center;
	}
</style>
	
</head>
<body>

<!-- oracle db의 student 테이블을 조회하여 화면에 출력 -->
<%
	/* try-catch문을 작성하지 않아도 되는 이유 :  
		하지만 사용했던 자원은 반납하는것이 좋다. */	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "pc17";
	String pass = "java";
	Connection conn =null;
	Statement  stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs =null;
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, user, pass);
		stmt = conn.createStatement();
		pstmt = conn.prepareStatement("select * from student");
		rs=pstmt.executeQuery();
		out.println("<table border=\"1\" id=\"std_table\">");
		out.println("<thead>");
		out.println("<th>학번<th>이름</th><th>국어</th><th>영어</th><th>수학</th></th>");
		out.println("</thead>");
		out.println("<tbody>");
		while(rs.next()) {
			out.println("<tr>");
			out.println("<td>" + rs.getString("std_num" + "") + "</td>");
			out.println("<td>" + rs.getString("std_name") + "</td>");
			out.println("<td>" + rs.getString("std_kor" + "") + "</td>");
			out.println("<td>" + rs.getString("std_eng" + "") + "</td>");
			out.println("<td>" + rs.getString("std_mat" + "") + "</td>");
			out.println("</tr>");
		}
		out.println("</tbody>");
		out.println("</table>");
		
		conn.close();
	
	} catch (SQLException e) {
		e.printStackTrace();		
	} finally {
		if(rs!=null) try {rs.close();} catch (SQLException e) {}
		if(stmt!=null) try {stmt.close();} catch (SQLException e) {}
		if(conn!=null) try {conn.close();} catch (SQLException e) {}
	}
	
	
%>

</body>
</html>