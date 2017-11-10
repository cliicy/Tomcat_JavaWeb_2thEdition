package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class HelloPlusServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String username=request.getParameter("username");
		
		if(username!=null)
			username=new String(username.getBytes("ISO-8859-1"),"GB2312");
			
		if (username==null){
			response.sendError(response.SC_FORBIDDEN);
			return;
		}
		
		response.setContentType("text/html;charset=GB2312");
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>HelloServlet</title></head>>");
		out.println("<body>");
		out.println("<b>您好! HMMM, "+username+"</b>");
		out.println("</body></html>");
		
		System.out.println("aaa before close():"+response.isCommitted());
		out.close();
		System.out.println("aaaa after close():"+response.isCommitted());
	}
}