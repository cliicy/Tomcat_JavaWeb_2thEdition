package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class CounterClearServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		ServletContext context = getServletContext();
		context.removeAttribute("counter");
		
		PrintWriter out = response.getWriter();
		
		out.println("The counter is removed");
		out.close();
	}
}