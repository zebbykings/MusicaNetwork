package fra.project.mn.facade;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fra.project.mn.dao.CertificateDao;
import fra.project.mn.dao.MUserDao;
import fra.project.mn.dao.MuserCertificateDao;
import fra.project.mn.dao.SectorsDao;
import fra.project.mn.dao.ServiceTitleDao;
import fra.project.mn.model.MUser;
import fra.project.mn.model.genericdata.Certificate;
import fra.project.mn.model.genericdata.CertificateType;
import fra.project.mn.model.genericdata.ContractOrCallServiceTitle;
import fra.project.mn.model.genericdata.InstitiuteType;
import fra.project.mn.model.genericdata.MuserCertificate;
import fra.project.mn.model.genericdata.Sector;
import fra.project.mn.model.genericdata.SectoreRule;
import fra.project.mn.model.genericdata.ServiceTitle;
import fra.project.mn.model.genericdata.embeddable.CertificateID;

public class MUserFacade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MUserDao muserDao = new MUserDao();
	private ServiceTitleDao std;
	private SectorsDao sd;
	private CertificateDao cd;
	private MuserCertificateDao mcd;

	private List<Sector> sectors;

	public void createCUser(MUser cuser) {

		muserDao.beginTransaction();
		muserDao.save(cuser);
		muserDao.commitAndCloseTransaction();
	}

	public MUser isValidLogin(String mail, String password) {
		muserDao.beginTransaction();
		MUser muser = muserDao.isValidLogIn(mail, password);
		muserDao.closeTransaction();
		return muser;
	}

	public MUser getMuserById(long entityID) {
		muserDao.beginTransaction();
		MUser muser = muserDao.find(entityID);
		muserDao.closeTransaction();
		return muser;
	}

	public void updateServiceTitle(MUser m, String city, String place, String acadamic_year, Sector sector, String teaching, String from_date, String to_date, boolean isPublicProcedure, String hourNumber, String publicProcedureName){
		
		ServiceTitle toAdd;
		if(isPublicProcedure){
			toAdd = new ContractOrCallServiceTitle(city, place, acadamic_year, sector, teaching, from_date, to_date, publicProcedureName, Integer.parseInt(hourNumber));
		}else
			toAdd = new ServiceTitle(city, place, acadamic_year, sector, teaching, from_date, to_date);
		
		
		muserDao.beginTransaction();
		getServiceTitleDao().beginTransaction();
		getServiceTitleDao().save(toAdd);
		getServiceTitleDao().flush();
		m.getServiceTitles().add(toAdd);
		getServiceTitleDao().commitAndCloseTransaction();
		muserDao.update(m);
		muserDao.flush();
		muserDao.commitAndCloseTransaction();
	}
	
	public void updateCertificate(MUser m, String subject, String selectedType,
			String selectedInstitiute, String city, String year) {

		Certificate c = getOrStoreCertificate(subject,
				CertificateType.values()[Integer.parseInt(selectedType)],
				InstitiuteType.values()[Integer.parseInt(selectedInstitiute)]);

		muserDao.beginTransaction();
		MuserCertificate find = getMuserCertificateDao().find(c);
		muserDao.closeTransaction();
		
		if(find!=null){
//			TODO certificate present			
			return;
		}
		
		MuserCertificate muc = createAndStoreMuserCertificate(c, city, year);

		m.getCertificates().add(muc);
		for (Sector s : muc.getSectors()) {
			if(!m.getSectors().contains(s)){
				m.getSectors().add(s);
			}
		}
		
		muserDao.beginTransaction();
		muserDao.update(m);
		muserDao.flush();
		muserDao.commitAndCloseTransaction();

	}

	private MuserCertificate createAndStoreMuserCertificate(Certificate c, String city,
			String year) {
		MuserCertificate muc = new MuserCertificate();
		muc.setCertificate(c);
		muc.setCity(city);
		muc.setYear(year);

		Set<Sector> toAdd = new HashSet<Sector>();

		List<Sector> sectors = getSectors();
		for (Sector sector : sectors) {
			Set<SectoreRule> allowedCertificatesRule = sector
					.getAllowedCertificatesRule();
			boolean good = true;
			for (SectoreRule sectoreRule : allowedCertificatesRule) {

				if (!(isCTypeOk(muc, sectoreRule)
						&& isITypeOk(muc, sectoreRule) && isSTypeOk(muc,
							sectoreRule))) {
					good = false;
				}
			}
			if (good)
				toAdd.add(sector);
		}
		muc.setSectors(toAdd);

		getMuserCertificateDao().beginTransaction();
		getMuserCertificateDao().save(muc);
		getMuserCertificateDao().flush();
		getMuserCertificateDao().commitAndCloseTransaction();
		
		return muc;
	}

	private Certificate getOrStoreCertificate(String subject,
			CertificateType certificateType, InstitiuteType institiuteType) {
		
		CertificateID idc = new CertificateID(subject, certificateType,
				institiuteType);
		
		Certificate c = new Certificate();
		c.setCertificateId(idc);
		getCertificateDao().beginTransaction();
		Certificate find = getCertificateDao().find(idc);
		if(find==null){
			getCertificateDao().save(c);
			getCertificateDao().flush();			
		}
		getCertificateDao().commitAndCloseTransaction();
		return c;
	}

	private List<Sector> getSectors() {
		if (sectors == null) {
			getSectorDao().beginTransaction();
			sectors = getSectorDao().findAll();
			getSectorDao().closeTransaction();
		}
		return sectors;
	}

	private SectorsDao getSectorDao() {
		if (this.sd == null) {
			this.sd = new SectorsDao();
		}
		return sd;
	}
	private ServiceTitleDao getServiceTitleDao() {
		if (this.std == null) {
			this.std = new ServiceTitleDao();
		}
		return std;
	}

	private CertificateDao getCertificateDao() {
		if (this.cd == null) {
			this.cd = new CertificateDao();
		}
		return cd;
	}
	private MuserCertificateDao getMuserCertificateDao() {
		if (this.mcd == null) {
			this.mcd = new MuserCertificateDao();
		}
		return mcd;
	}

	private boolean isCTypeOk(MuserCertificate muc, SectoreRule sectoreRule) {
		if (sectoreRule.getCertificateType() == null)
			return true;
		return sectoreRule.getCertificateType().ordinal() == muc
				.getCertificate().getCertificateId().getCertificateType()
				.ordinal();
	}

	private boolean isITypeOk(MuserCertificate muc, SectoreRule sectoreRule) {
		if (sectoreRule.getInsitituteTyepe() == null)
			return true;
		return sectoreRule.getInsitituteTyepe().ordinal() == muc
				.getCertificate().getCertificateId().getInstitiute().ordinal();
	}

	private boolean isSTypeOk(MuserCertificate muc, SectoreRule sectoreRule) {
		if (sectoreRule.getSubject() == null)
			return true;
		return sectoreRule.getSubject().equals(
				muc.getCertificate().getCertificateId().getSubject());
	}

}
