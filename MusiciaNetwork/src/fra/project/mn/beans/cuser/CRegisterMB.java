package fra.project.mn.beans.cuser;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import fra.project.mn.facade.CUserFacade;
import fra.project.mn.model.CUser;

@ManagedBean	 
@ViewScoped
public class CRegisterMB implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{name}")
	String name;		
	@ManagedProperty(value = "#{username}")
	String username;
	@ManagedProperty(value = "#{password}")
	String password;
	
	private CUserFacade cUserFacade;
	
	public String createCUser(){
		CUser cuser=new CUser();
		fillCUserFromProperties(cuser);
		getCUserFacade().createCUser(cuser);
		//TODO
		return "CUserLoggedIn";
	}
	 
	private void fillCUserFromProperties(CUser cuser) {
		cuser.setName(name);
		cuser.setUsername(username);
		cuser.setPassword(password);
	}

	private CUserFacade getCUserFacade() {
		if(cUserFacade==null){
			cUserFacade = new CUserFacade();
		}
		return cUserFacade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
