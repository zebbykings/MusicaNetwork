package fra.project.mn.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fra.project.mn.model.genericdata.Adviceobject;

public class AdviceObjectDao extends GenericDAO<Adviceobject> {
	private static final long serialVersionUID = 1L;

	public AdviceObjectDao() {
		super(Adviceobject.class);
	}
	
	public List<Adviceobject> findAdviceobjectsById(List<Long> id_list) {
		beginTransaction();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("adviceobjectId", id_list);
		

		List<Adviceobject> findMoreResult = super.findMoreResult(Adviceobject.FIND_ADVICEOBJECT_BY_ID,
				parameters);
		closeTransaction();
		return findMoreResult;
	}
}
