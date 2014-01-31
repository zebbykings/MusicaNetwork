package fra.project.mn.dao;

import java.util.*;

import fra.project.mn.model.Advice;
import fra.project.mn.model.CUser;

public class CUserDao extends GenericDAO<CUser> {

	private static final long serialVersionUID = 1L;

	public CUserDao() {
		super(CUser.class);
	}

	public CUser findPersonByName(String name) {
		beginTransaction();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("name", name);

		CUser findOneResult = super.findOneResult(CUser.FIND_CUSER_BY_NAME,
				parameters);
		closeTransaction();
		return findOneResult;
	}
	public CUser isValidLogIn(String username, String password) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("username", username);
		parameters.put("password", password);
		
		CUser findOneResult = super.findOneResult(CUser.ISVALIDlOGIN,
				parameters);
		return findOneResult;
	}
	
}