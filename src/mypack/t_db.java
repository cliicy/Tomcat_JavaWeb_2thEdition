
import java.io.*;
import java.util.*;

import java.sql.*;

public class t_db {

		Connection con;
		Statement stmt=null;
		Statement stmt2=null;
	       
		Class.forName("com.mysql.jdbc.Driver");
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		String dbUrl="jdbc:mysql://localhost:3306/BookDB?useUnicode=true&characterEncoding=GB2312";
		String dbUser="dbuser";
		String dbPwd="1234";
	try{
			con=java.sql.DriverManager.getConnection(dbUrl,dbUser,dbPwd);
			stmt2=stmt=con.createStatement();
			stmt.executeUpdate("insert into BOOKS (ID,NAME,TITLE,PRICE) value('999','Tom','Tomcat Bible',44.5)");
			//rs=smtm.executeQuery("select ID,NAME,TITLE,PRICE from BOOKS");
			 String query = "select ID, NAME, TITLE, " +
		                   "PRICE " +
		                   "from " + "BOOKS";
			ResultSet rs=smtm2.executeQuery(query);
			
			System.out.println("<table border=1 width=400>");
			while (rs.next()) {
				String col1=rs.getString(1);
				String col2=rs.getString(2);
				String col3=rs.getString(3);
				float col4=rs.getFloat(4);
				
				System.out.println("<tr><td>"+col1+"</td><td>"+col2+"</td><td>"
				+col3+"</td><td>"+col4+"</td><tr>");
			}
			System.out.println("</table>");
			
			//stmt.executeUpdate("delete from BOOKS where ID='999'");
			
			rs.close();
			stmt.close();
			con.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
}
