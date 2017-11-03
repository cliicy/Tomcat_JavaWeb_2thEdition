package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;


public class RequestInfoServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html;charset=GB2312");
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>RequestInfo</title></head>");
		out.println("<body>");
		
		out.println("<br>LocalAddr: "+request.getLocalAddr());
		out.println("<br>LocalName: "+request.getLocalName());
		out.println("<br>LocalPort: "+request.getLocalPort());
		out.println("<br>Protocol: "+request.getProtocol());
		out.println("<br>RemoteAddr: "+request.getRemoteAddr());
		
		out.println("<br>RemoteHost: "+request.getRemoteHost());
		out.println("<br>RemotePort: "+request.getRemotePort());
		
		out.println("<br>Method: "+request.getMethod());
		out.println("<br>URI: "+request.getRequestURI());
		out.println("<br>ContextPath: "+request.getContextPath());
		out.println("<br>QueryString: "+request.getQueryString());
	    
		out.println("<br>***Print HTTP request Head");
		Enumeration eu=request.getHeaderNames();
		
		while(eu.hasMoreElements()) {
			String headerName=(String)eu.nextElement();
			out.println("<br>"+headerName+": "+request.getHeader(headerName));
			
		}
		out.println("<br>***Print HTTP request Head ending***</br>");
		out.println("<br>username: "+request.getParameter("username"));
		out.println("</body></html>");
		
		out.close();
	}
}