package fra.project.mn.facade;

import java.io.Serializable;
import java.util.HashSet;
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
	
	public void createAdvice(Advice advice) {
		
		
//		prendo gli advice object dal db e li ad advice
//		HashSet<Adviceobject> hashSet = new HashSet<Adviceobject>();
//		AdviceObjectDao adoa = new AdviceObjectDao();
//		adoa.beginTransaction();
//		List<Adviceobject> findAll = adoa.findAll();
//		adoa.closeTransaction();
//		
//		Set <Adviceobject> s = new HashSet<Adviceobject>();
//		s.addAll(findAll);
//		advice.setAdviceobjects(s);
//===============================================
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
