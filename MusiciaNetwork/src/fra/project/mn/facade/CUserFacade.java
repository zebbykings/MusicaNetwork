package fra.project.mn.facade;

import java.io.Serializable;

import fra.project.mn.dao.CUserDao;
import fra.project.mn.model.CUser;

public class CUserFacade implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CUserDao cuserDao = new CUserDao();
	
	public void createCUser(CUser cuser) {

		cuserDao.beginTransaction();
		cuserDao.save(cuser);
		cuserDao.commitAndCloseTransaction();
	}

	public CUser isValidLogin(String username, String password) {
		cuserDao.beginTransaction();
		CUser cuser = cuserDao.isValidLogIn(username, password);
		cuserDao.closeTransaction();	
		return cuser;
	}

}
