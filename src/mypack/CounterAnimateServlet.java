package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class CounterAnimateServlet extends HttpServlet {
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
		String imageLink="<img src='image?count="+counter.getCount()+"'/>";
		out.println("<h1>Welcome! You are the "+imageLink+" th visitor.</h1>");
		out.println("Welcome! You are the "+imageLink+" th visitor.");
		out.println("</body></html>");
		
		counter.add(1);
		out.close();
	}
}