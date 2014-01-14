package fra.project.mn.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fra.project.mn.dao.CUserDao;
import fra.project.mn.model.CUser;

@ManagedBean
@ViewScoped
public class Index implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Index() {
	}

	public String getHello() {
      //read from db example
		CUserDao cd = new CUserDao();
		CUser findPersonByName = cd.findPersonByName("mike");
		return findPersonByName.getName();

	}
}