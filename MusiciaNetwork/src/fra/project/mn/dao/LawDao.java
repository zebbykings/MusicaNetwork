package fra.project.mn.dao;

import fra.project.mn.model.genericdata.Law;

public class LawDao extends GenericDAO<Law>{
	private static final long serialVersionUID = 1L;

	public LawDao() {
		super(Law.class);
	}
}
