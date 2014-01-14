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

import fra.project.mn.beans.cuser.CUserMB;
import fra.project.mn.filter.AbstractFilter;

public class CUserFilter extends AbstractFilter implements Filter {
	private static List<String> allowedURIs;

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// if(allowedURIs == null){
		// allowedURIs = new ArrayList<String>();
		// allowedURIs.add(fConfig.getInitParameter('loginActionURI'));
		// allowedURIs.add('/JSFCrudApp/javax.faces.resource/main.css.xhtml');
		// allowedURIs.add('/JSFCrudApp/javax.faces.resource/theme.css.xhtml');
		// allowedURIs.add('/JSFCrudApp/javax.faces.resource/primefaces.js.xhtml');
		// allowedURIs.add('/JSFCrudApp/javax.faces.resource/primefaces.css.xhtml');
		// allowedURIs.add('/JSFCrudApp/javax.faces.resource/jquery/jquery.js.xhtml');
		// allowedURIs.add('/JSFCrudApp/javax.faces.resource/messages/messages.png.xhtml');
		// allowedURIs.add('/JSFCrudApp/javax.faces.resource/images/ui-icons_2e83ff_256x240.png.xhtml');
		// allowedURIs.add('/JSFCrudApp/javax.faces.resource/images/ui-icons_38667f_256x240.png.xhtml');
		// }
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		CUserMB umb=null;
		if(!isLoggedIn(req, "cusermb",umb)){
			goTo(request, response, req, "/pages/public/cuser_index.xhtml");
			return;
		}
		chain.doFilter(request, response);
	}
}
