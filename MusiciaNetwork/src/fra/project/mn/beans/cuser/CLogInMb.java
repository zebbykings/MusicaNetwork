package fra.project.mn.beans.cuser;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import fra.project.mn.facade.CUserFacade;
import fra.project.mn.model.CUser;

@RequestScoped
@ManagedBean
public class CLogInMb {
	@ManagedProperty(value = CUserMB.INJECTION_NAME)
	private CUserMB cusermb;

	private String username;
	private String password;

	public String logIn() {
		CUserFacade userFacade = new CUserFacade();
		CUser cuser = userFacade.isValidLogin(username, password);
		System.out.println("login: "+username+", "+password);
		if (cuser != null) {
			cusermb.setCuser(cuser);

			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletRequest request = (HttpServletRequest) context
					.getExternalContext().getRequest();
			request.getSession().setAttribute("cuser", cuser);
			System.out.println("login: ok ");
			return "/pages/protected/cuser/cuser_home.xhtml";
		}
		// TODO
		System.out.println("login: ko");
		return "";
	}

	public void setCusermb(CUserMB cusermb) {
		this.cusermb = cusermb;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
