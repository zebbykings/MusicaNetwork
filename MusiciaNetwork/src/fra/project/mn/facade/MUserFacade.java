package fra.project.mn.facade;

import java.io.Serializable;

import fra.project.mn.dao.MUserDao;
import fra.project.mn.model.MUser;

public class MUserFacade implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MUserDao muserDao = new MUserDao();
	
	public void createCUser(MUser cuser) {

		muserDao.beginTransaction();
		muserDao.save(cuser);
		muserDao.commitAndCloseTransaction();
	}

	public MUser isValidLogin(String mail, String password) {
		muserDao.beginTransaction();
		MUser muser = muserDao.isValidLogIn(mail, password);
		muserDao.closeTransaction();	
		return muser;
	}
	
	public MUser getMuserById(long entityID) {
		muserDao.beginTransaction();
		MUser muser = muserDao.find(entityID);
		muserDao.closeTransaction();	
		return muser;
	}
	

}

