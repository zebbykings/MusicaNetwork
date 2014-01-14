package fra.project.mn.filter;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fra.project.mn.beans.UserMb;

public class AbstractFilter {


	public AbstractFilter() {
		super();
	}

	protected void goTo(ServletRequest request, ServletResponse response,
			HttpServletRequest req, String page) throws ServletException, IOException {
		RequestDispatcher rd = req
				.getRequestDispatcher(page);
		rd.forward(request, response);
	}
	
	protected <T extends UserMb>boolean isLoggedIn(HttpServletRequest req, String attribute_name, T t){
		HttpSession session = req.getSession();
		T cusermb = (T) session.getAttribute(attribute_name);
		if (cusermb == null || !cusermb.isLoggedIn()) {
			return false;
		}
		return true;
	}
	
	
	protected void accessDenied(ServletRequest request,
			ServletResponse response, HttpServletRequest req)
			throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/accessDenied.xhtml");
		rd.forward(request, response);
	}

}