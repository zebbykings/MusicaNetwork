package fra.project.mn.beans.muser;

import java.io.Serializable;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fra.project.mn.beans.UserMb;
import fra.project.mn.model.MUser;
import fra.project.mn.model.genericdata.MuserCertificate;
import fra.project.mn.model.genericdata.Sector;

@ManagedBean(name="musermb")
@SessionScoped
public class MUserMB extends UserMb implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String INJECTION_NAME = "#{musermb}";
			
	private MUser muser;

	public String logOut(){
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.invalidate();
		return "home";
	}
	
	public boolean isLoggedIn(){
		return muser!=null;
	}
	
	public MUser getMuser() {
		return muser;
	}
	
	public void setMuser(MUser muser) {
		this.muser = muser;
	}

}
