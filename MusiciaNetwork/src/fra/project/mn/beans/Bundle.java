package fra.project.mn.beans;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

//import fra.project.mn.dao.CUserDao;
//import fra.project.mn.model.CUser;

@ManagedBean
@ViewScoped
public class Bundle implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	transient ResourceBundle rb = ResourceBundle.getBundle("messages");
	
	public Bundle() {
	}

	public String getSingUpMessage() {
      //read from db example
		/*CUserDao cd = new CUserDao();
		CUser findPersonByName = cd.findPersonByName("mike");
		return findPersonByName.getName();*/
		return rb.getString("singUnMessage");
	}
	
	public String getTitle(){
		return rb.getString("getTitle");
	}
	public String getSubTitle(){
		return rb.getString("getSubTitle");
	}
	public String getSignIn(){
		return rb.getString("singInMessage");
	}
	public String getConservatorySectionButtonTitle(){
		return rb.getString("getConservatorySectionButtonTitle");
	}
	public String getMusicianSectionButtonTitle(){
		return rb.getString("getMusicianSectionButtonTitle");
	}
	public String getIndexWelcomeMessage(){
		return rb.getString("getIndexWelcomeMessage");
	}
	public String getRegisterFormTitle(){
		return rb.getString("getRegisterFormTitle");
	}
	public String getHowItsWorkTitle(){
		return rb.getString("howItsWorkTitle");
	}
	
	//Cuser Messages
	public String getCUserIndexWelcomeMessage(){
		return rb.getString("getCUserIndex");
	}
	public String getCUserHomeWelcomeMessage(){
		return rb.getString("getCUserHome");
	}
	//Muser Messages
	public String getMUserIndexWelcomeMessage(){
		return rb.getString("getMUserIndex");
	}
	public String getMUserHomeWelcomeMessage(){
		return rb.getString("getMUserHome");
	}
}