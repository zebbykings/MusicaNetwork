package fra.project.mn.dao;

import java.util.HashMap;
import java.util.Map;

import fra.project.mn.model.MUser;

public class MUserDao extends GenericDAO<MUser> {

	private static final long serialVersionUID = 1L;

	public MUserDao() {
		super(MUser.class);
	}

	public MUser findPersonByName(String name) {
		beginTransaction();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("name", name);

		MUser findOneResult = super.findOneResult(MUser.FIND_MUSER_BY_NAME,
				parameters);
		closeTransaction();
		return findOneResult;
	}
	
	public MUser isValidLogIn(String mail, String password) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("mail", mail);
		parameters.put("password", password);
		
		MUser findOneResult = super.findOneResult(MUser.ISVALIDlOGIN,
				parameters);
		return findOneResult;
	}
}