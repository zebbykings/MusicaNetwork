package fra.project.mn.facade;

import java.io.Serializable;
import java.util.List;

import fra.project.mn.dao.AdviceDao;
import fra.project.mn.model.Advice;

public class AdviceFacade implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AdviceDao adviceDao = new AdviceDao();
	
	public void createAdvice(Advice advice/*, List<String> objects*/) {
		adviceDao.beginTransaction();
		adviceDao.save(advice);
		adviceDao.commitAndCloseTransaction();
	}
	public List<Advice> getAdvices() {
		adviceDao.beginTransaction();
		List<Advice> findAll = adviceDao.findAll();
		adviceDao.closeTransaction();
		return findAll;
	}
	public void removeById(long id){
		adviceDao.beginTransaction();
		adviceDao.deleteById(id);
		adviceDao.commitAndCloseTransaction();
	}
	public void update(Advice adviceToShow) {
		adviceDao.beginTransaction();
		adviceDao.update(adviceToShow);
		adviceDao.commitAndCloseTransaction();
	}
}
