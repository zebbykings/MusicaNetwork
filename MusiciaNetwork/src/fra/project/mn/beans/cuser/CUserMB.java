package fra.project.mn.beans.cuser;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fra.project.mn.beans.UserMb;
import fra.project.mn.model.CUser;

@ManagedBean(name="cusermb")
@SessionScoped
public class CUserMB extends UserMb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String INJECTION_NAME = "#{cusermb}";
			
	private CUser cuser;

	public boolean isLoggedIn(){
		return cuser!=null;
	}
	public void setCuser(CUser cuser) {
		this.cuser = cuser;
	}

	public CUser getCuser() {
		return cuser;
	}

	

	
}
