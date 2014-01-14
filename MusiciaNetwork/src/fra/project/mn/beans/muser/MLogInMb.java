package fra.project.mn.beans.muser;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import fra.project.mn.facade.CUserFacade;
import fra.project.mn.facade.MUserFacade;
import fra.project.mn.model.CUser;
import fra.project.mn.model.MUser;

@RequestScoped
@ManagedBean
public class MLogInMb {
	@ManagedProperty(value = MUserMB.INJECTION_NAME)
	private MUserMB musermb;

	private String username;
	private String password;

	public String logIn() {
		MUserFacade userFacade = new MUserFacade();
		MUser muser = userFacade.isValidLogin(username, password);
		System.out.println("login: "+username+", "+password);
		if (muser != null) {
			musermb.setMuser(muser);

			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletRequest request = (HttpServletRequest) context
					.getExternalContext().getRequest();
			request.getSession().setAttribute("muser", muser);
			System.out.println("login: ok ");
			return "/pages/protected/muser/muser_home.xhtml";
		}
		// TODO
		System.out.println("login: ko");
		return "";
	}

	public void setMusermb(MUserMB cusermb) {
		this.musermb = cusermb;
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
