package filter;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import DAO.loginDAO;
import VO.loginVO;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/asdasd")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		
		HttpSession session = ((HttpServletRequest) request).getSession();
		RequestDispatcher requestDispatcher;
		String flag = request.getParameter("flag");
		
		String uri = ((HttpServletRequest) request).getRequestURI();
		
		if(uri.contains("register")||uri.contains("/css") ||uri.contains("/js") &&!uri.contains(".jsp") ||uri.contains("/img") ||uri.contains("/fonts") ||uri.contains("/regi.jsp") ||uri.contains("/registration"))
		
		{
			chain.doFilter(request, response);
		}
		else if (flag!= null && flag.equals("logout")){
			
			session.invalidate();
			requestDispatcher = request.getRequestDispatcher("/admin/login.jsp");
			requestDispatcher.forward(request, response);
		}
		else if (flag!= null && flag.equals("login"))
		{
          String uname = request.getParameter("uname");
          String pass = request.getParameter("pass");
          
          System.out.println(uname+""+pass);
          
          loginVO LoginVO = new loginVO();
          LoginVO.setUname(uname);
          LoginVO.setPass(pass);
          
          loginDAO loginDAO=new loginDAO();
          
			List list =  loginDAO.authentication(LoginVO);
			
			if(list != null && list.size()>=1){
				
				//Iterator itr = list.iterator();
				
				//while(itr.hasNext()){
				loginVO user=(loginVO) list.get(0);
				
				long y = user.getLoginId();
				session.setAttribute("userID",y);
				
				System.out.println(user.getRadio());
			//	System.out.println(session.getAttribute("userId"));
				String type = user.getRadio();
				session.setAttribute("radio",type);
				System.out.println(y);
				if(type.equalsIgnoreCase("admin"))
				{
					requestDispatcher = request.getRequestDispatcher("/admin/index.jsp");  
					requestDispatcher.forward(request,response);
				}
				else if(type.equalsIgnoreCase("staff"))
				{
					requestDispatcher = request.getRequestDispatcher("/staff/k4.jsp");  
					requestDispatcher.forward(request,response);
				}
				
				else
				{
					requestDispatcher = request.getRequestDispatcher("/admin/login.jsp");  
					requestDispatcher.forward(request,response);  
				}
			}
			else
			{
				requestDispatcher = request.getRequestDispatcher("/admin/login.jsp");
				requestDispatcher.forward(request,response);  		
			}	
		}
		else if(session.getAttribute("userID") != null)
		{
			String h = (String)session.getAttribute("radio");
			//System.out.println("type = = = " + h);
			
			if(h!=null && h.equals("admin")){
				
			//System.out.println("chain");
			chain.doFilter(request,response);
			}
			
			else if(h!=null && h.equals("staff"))
			{
				//System.out.println("chain");
				chain.doFilter(request, response);
			}
			
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("/admin/error.jsp");  
				rd.forward(request,response);
			}
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("/admin/login.jsp");  
			rd.forward(request,response);  
			
		}
	}


          
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
