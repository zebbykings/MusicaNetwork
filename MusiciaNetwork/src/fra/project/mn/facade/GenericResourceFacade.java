package fra.project.mn.facade;

import java.io.Serializable;
import java.util.List;

import fra.project.mn.beans.Bean;
import fra.project.mn.dao.LawDao;
import fra.project.mn.dao.RequiremntsDao;
import fra.project.mn.dao.SectorsDao;
import fra.project.mn.dao.ValutationDao;
import fra.project.mn.model.genericdata.Law;
import fra.project.mn.model.genericdata.Requirements;
import fra.project.mn.model.genericdata.Sector;
import fra.project.mn.model.genericdata.Valutation;

public class GenericResourceFacade extends Bean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LawDao lDao = new LawDao();
	private SectorsDao sDao = new SectorsDao();
	private RequiremntsDao rDao = new RequiremntsDao();
	private ValutationDao vDao = new ValutationDao();
	

	public List<Law> getLaws() {
		lDao.beginTransaction();
		List<Law> findAll = lDao.findAll();
		lDao.closeTransaction();
		return findAll;
	}
	public List<Sector> getSectors() {
		sDao.beginTransaction();
		List<Sector> findAll = sDao.findAll();
		sDao.closeTransaction();
		return findAll;
	}
	public List<Requirements> getRequirements() {
		rDao.beginTransaction();
		List<Requirements> findAll = rDao.findAll();
		rDao.closeTransaction();
		return findAll;
	}
	public List<Valutation> getValutations() {
		vDao.beginTransaction();
		List<Valutation> findAll = vDao.findAll();
		vDao.closeTransaction();
		return findAll;
	}
}
