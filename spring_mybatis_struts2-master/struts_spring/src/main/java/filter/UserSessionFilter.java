package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.TimechoUser;

public class UserSessionFilter implements Filter  {
	private static String LOGIN_PAGE = "/index.jsp";  
	
	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		  HttpServletRequest req = (HttpServletRequest)request;  
		    HttpServletResponse res = (HttpServletResponse)response;  
		  
		    String currentUrl = req.getServletPath();  
		  
		    HttpSession session = req.getSession();  
		  
		    System.out.println("UserSessionFilter");  
		    if (currentUrl.equals("")) currentUrl = currentUrl + "/";  
		    if ((currentUrl.startsWith("/")) && (!currentUrl.startsWith("index.jsp"))) {  
		    	TimechoUser user = (TimechoUser) session.getAttribute("currentUser");  
		    	if (user == null) {  
		    		System.out.println(req.getContextPath() + LOGIN_PAGE);
			        res.sendRedirect(req.getContextPath() + LOGIN_PAGE);  
			        return;  
		    	}
		    }  
		    chain.doFilter(request, response);  
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}
}
