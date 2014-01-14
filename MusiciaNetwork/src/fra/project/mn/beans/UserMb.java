package fra.project.mn.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
@ManagedBean	 
@SessionScoped
public abstract class UserMb {
	public abstract boolean isLoggedIn();
	
	public String logOut(){
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.invalidate();
		System.out.println("logout");
		return "home";
	}
}
