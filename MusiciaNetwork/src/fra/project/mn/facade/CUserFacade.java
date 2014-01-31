package fra.project.mn.facade;

import java.io.Serializable;
import java.util.List;

import fra.project.mn.dao.AdviceDao;
import fra.project.mn.dao.CUserDao;
import fra.project.mn.model.Advice;
import fra.project.mn.model.CUser;

public class CUserFacade implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CUserDao cuserDao;
	private AdviceDao adviceDao;
	
	private AdviceDao getAdviceDao(){
		if(adviceDao==null){
			this.adviceDao = new AdviceDao();
		}
		return adviceDao;
	}
	private CUserDao getCuserDao(){
		if(cuserDao==null){
			this.cuserDao = new CUserDao();
		}
		return cuserDao;
	}
	
	public void createCUser(CUser cuser) {
		getCuserDao().beginTransaction();
		getCuserDao().save(cuser);
		getCuserDao().commitAndCloseTransaction();
	}
	
	public List<Advice> getMyAdvice(CUser c){
		getAdviceDao().beginTransaction();
		List<Advice> myAdvice = getAdviceDao().getMyAdvice(c);
		getAdviceDao().closeTransaction();
		return myAdvice;
	}

	public CUser isValidLogin(String username, String password) {
		getCuserDao().beginTransaction();
		CUser cuser = getCuserDao().isValidLogIn(username, password);
		getCuserDao().closeTransaction();	
		return cuser;
	}

}
