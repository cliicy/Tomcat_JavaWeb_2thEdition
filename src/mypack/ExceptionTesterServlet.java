package mypack;

import javax.servlet.*;
//import javax.servlet.http.*;
import java.io.*;
//import java.util.*;

public class ExceptionTesterServlet extends GenericServlet {
	
	public void service (ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		String condition=request.getParameter("condition");
		
		if(condition==null) condition="ok";
	
		if(condition.equals("1")) {
			throw new ServletException("condition1");
		} else if(condition.equals("2")){
			throw new UnavailableException("condition2",2);
		} else if(condition.equals("3")){
			throw new UnavailableException("condition3");
		}
		
		PrintWriter out=response.getWriter();
		out.println("It's ok.");
		out.close();
	}
}