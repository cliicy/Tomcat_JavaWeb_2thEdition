package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class FontServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String word=request.getParameter("word");
		
		if (word==null){
			word="Hello";
		}
		
		String color=getInitParameter("color");
		String size=getInitParameter("size");
		System.out.println("servletName: "+getServletName());

		response.setContentType("text/html;charset=GB2312");
		
		PrintWriter out = response.getWriter();
		out.println("<html<head><title>FontServlet</title></head>>");
		out.println("<body>");
		out.println("<font size='"+size+"' color='"+color+"'>"+word+"</font>");
		out.println("</body></html>");
		
		System.out.println("font before close():"+response.isCommitted());
		out.close();
		System.out.println("font after close():"+response.isCommitted());
	}
}