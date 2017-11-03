package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class LifeServlet extends GenericServlet {
	private int initVar=0;
	private int serviceVar=0;
	private int destroyVar=0;
	private String name;
	
	public void init(ServletConfig config)throws ServletException {
		super.init(config);
		name=config.getServletName();
		initVar++;
		System.out.println(name+"++init(): Servelet was initialized " +initVar+ " times ");
	}
	
	public void destroy() {
		destroyVar++;
		System.out.println(name+"++destroy(): Servelet was destroied " +destroyVar+ " times ");
	}
		
	public void service(ServletRequest request,ServletResponse response)
		throws IOException, ServletException {
		serviceVar++;
		System.out.println(name+"++service(): Servelet responsed " +serviceVar+ " times ");
		String content1="the times of initialize: "+initVar;
		String content2="the times of service responsing: "+serviceVar;
		String content3="the times of destroy: "+destroyVar;
		
		//response.setContentType("text/html;charset=GB2312");
		
		PrintWriter out = response.getWriter();
		out.println("<html<head><title>LifeServlet</title></head>>");
		out.println("<body>");
		out.println("<h1>"+content1+"</h1>");
		out.println("<h1>"+content2+"</h1>");
		out.println("<h1>"+content3+"</h1>");
		out.println("</body></html>");
		
		out.close();
	}
}