<!-- first import some necessary packages -->

<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>

<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=GB2312" %>

<html>
<head>
<title>dbaccess.jsp</title>
</head>
<body>
<%
try{
	Connection con;
	Statement stmt=null;
	
    
	Class.forName("com.mysql.jdbc.Driver");
	DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	String dbUrl="jdbc:mysql://localhost:3306/BookDB?useUnicode=true&characterEncoding=GB2312";
	String dbUser="dbuser";
	String dbPwd="1234";
	con=java.sql.DriverManager.getConnection(dbUrl,dbUser,dbPwd);
	stmt=con.createStatement();
	/*
	stmt.executeUpdate("insert into BOOKS (ID,NAME,TITLE,PRICE) value('989','Tom','Tomcat Bible',44.5)");
	
	String query = "select ID, NAME, TITLE, " +
                   "PRICE " +
                   "from " + "BOOKS";
	ResultSet rs=stmt.executeQuery(query);
	*/
	ResultSet rs=stmt.executeQuery("select ID,NAME,TITLE,PRICE from BOOKS");
	out.println("<table border=1 width=800>");
	while (rs.next()) {
		String col1=rs.getString(1);
		String col2=rs.getString(2);
		String col3=rs.getString(3);
		float col4=rs.getFloat(4);
		
		out.println("<tr><td>"+col1+"</td><td>"+col2+"</td><td>"
		+col3+"</td><td>"+col4+"</td><tr>");
	}
	out.println("</table>");
	
	//stmt.executeUpdate("delete from BOOKS where ID='989'");
	
	rs.close();
	stmt.close();
	con.close();
	//System.out.println("<p>"+"aaaa"+"</p>");
}catch(Exception e) {out.println(e.getMessage());}
%>
</body>
</html>