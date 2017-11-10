package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class CounterServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		ServletContext context = getServletContext();
		
		Counter counter = (Counter)context.getAttribute("counter");
			
		if (counter==null){
			counter=new Counter(1);
			context.setAttribute("counter",counter);
		}
		
		response.setContentType("text/html;charset=GB2312");
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>HelloServlet</title></head>>");
		out.println("<body>");
		out.println("<h1>Welcome! You are the "+counter.getCount()+" th visitor.</h1>");
		out.println("</body></html>");
		
		counter.add(1);
		out.close();
	}
}