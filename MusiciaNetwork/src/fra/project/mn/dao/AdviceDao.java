package fra.project.mn.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fra.project.mn.model.Advice;
import fra.project.mn.model.CUser;

public class AdviceDao extends GenericDAO<Advice> {
	private static final long serialVersionUID = 1L;

	public AdviceDao() {
		super(Advice.class);
	}
	
	public List<Advice> getMyAdvice(CUser c) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("cuser", c);
		
		 List<Advice> findMoreResult = super.findMoreResult(Advice.FIND_CUSER_BY_NAME,
				parameters);
		return findMoreResult;
	}

}
