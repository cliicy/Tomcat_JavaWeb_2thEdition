package mypack;
import java.io.*;
import javax.servlet.*;

public class QuestionServlet extends GenericServlet{
	public void init (ServletConfig config) throws ServletException{
		System.out.println("Servlet is initialized");
	}
	
	public void service(ServletRequest request,ServletResponse response) throws IOException, ServletException{
		ServletContext context=getServletContext();
		PrintWriter out = response.getWriter();
		out.println(context.getServerInfo());
		out.close();
	}
}
