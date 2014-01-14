package fra.project.mn.beans.muser;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import fra.project.mn.facade.CUserFacade;
import fra.project.mn.facade.MUserFacade;
import fra.project.mn.model.CUser;
import fra.project.mn.model.MUser;

@ManagedBean	 
@ViewScoped
public class MRegisterMB implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{name}")
	String name;		
	@ManagedProperty(value = "#{mail}")
	String mail;
	@ManagedProperty(value = "#{password}")
	String password;
	
	private MUserFacade mUserFacade;
	
	public String createMUser(){
		MUser muser=new MUser();
		fillMUserFromProperties(muser);
		getCUserFacade().createCUser(muser);
		//TODO
		return "CUserLoggedIn";
	}
	 
	private void fillMUserFromProperties(MUser muser) {
		muser.setName(name);
		muser.setMail(mail);
		muser.setPassword(password);
	}

	public MUserFacade getCUserFacade() {
		if(mUserFacade==null){
			mUserFacade = new MUserFacade();
		}
		return mUserFacade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
