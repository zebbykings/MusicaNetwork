package fra.project.mn.filter.cuser;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fra.project.mn.beans.cuser.CUserMB;
import fra.project.mn.filter.AbstractFilter;
import fra.project.mn.model.CUser;

public class HomeCUserFilter extends AbstractFilter implements Filter {
	private static List<String> allowedURIs;

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		CUserMB cmb=null;
//		==
//		HttpSession session = req.getSession();
//		CUser c = new CUser();
//		c.setIdCUser(1);
//		c.setName("c");
//		c.setUsername("c");
//		c.setPassword("c");		
//		session.setAttribute("cuser", c);
//		==
		if(isLoggedIn(req, "cusermb", cmb)){
			goTo(request, response, req, "/pages/protected/cuser/myAdvices/myAdvices.xhtml");
			return;
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
