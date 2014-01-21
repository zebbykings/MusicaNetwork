package fra.project.mn.facade;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import fra.project.mn.dao.AdviceDao;
import fra.project.mn.dao.AdviceObjectDao;
import fra.project.mn.model.Advice;
import fra.project.mn.model.genericdata.Adviceobject;

public class AdviceFacade implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AdviceDao adviceDao = new AdviceDao();
	
	public void createAdvice(Advice advice/*, List<String> objects*/) {
		
		Set<Adviceobject> adviceobjects = advice.getAdviceobjects();
		List<Long> adIds = new LinkedList<Long>();
		for (Adviceobject adviceobject : adviceobjects) {
			System.out.println(adviceobject);			
		}

		adviceDao.beginTransaction();
		adviceDao.save(advice);
		adviceDao.commitAndCloseTransaction();
	}
	public List<Advice> getLaws() {
		adviceDao.beginTransaction();
		List<Advice> findAll = adviceDao.findAll();
		adviceDao.closeTransaction();
		return findAll;
	}
}
