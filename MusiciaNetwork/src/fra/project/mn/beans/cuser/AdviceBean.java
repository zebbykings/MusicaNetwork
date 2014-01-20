package fra.project.mn.beans.cuser;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.jboss.weld.bean.builtin.ee.HttpSessionBean;

import fra.project.mn.dao.AdviceDao;
import fra.project.mn.facade.AdviceFacade;
import fra.project.mn.model.Advice;
import fra.project.mn.model.CUser;
import fra.project.mn.model.genericdata.Adviceobject;
import fra.project.mn.model.genericdata.Law;
import fra.project.mn.model.genericdata.Requirements;
import fra.project.mn.model.genericdata.Sector;
import fra.project.mn.model.genericdata.Valutation;

@ManagedBean(name="advicebean")
@SessionScoped
public class AdviceBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AdviceFacade adviceFacade;
	public List<Adviceobject> objects;
	public List<Law> selectedLaws;
	public List<Sector> selectedSectors;
	public List<Requirements> selectedRequirements;
	public List<Valutation> selectedValutation;
	
	public Adviceobject[] data = {};
	
	public Adviceobject[] getData() {
		return data;
	}

	public void setData(Adviceobject[] data) {
		this.data = data;
	}

	public String enddate="10/10/2012";
	
	public List<Adviceobject> getObjects() {
		return objects;
	}	

	public void setObjects(List<Adviceobject> objects) {
		this.objects = objects;
	}


	public List<Law> getSelectedLaws() {
		return selectedLaws;
	}

	public void setSelectedLaws(List<Law> selectedLaws) {
		this.selectedLaws = selectedLaws;
	}

	public List<Sector> getSelectedSectors() {
		return selectedSectors;
	}

	public void setSelectedSectors(List<Sector> selectedSectors) {
		this.selectedSectors = selectedSectors;
	}

	public List<Requirements> getSelectedRequirements() {
		return selectedRequirements;
	}

	public void setSelectedRequirements(List<Requirements> selectedRequirements) {
		this.selectedRequirements = selectedRequirements;
	}

	public List<Valutation> getSelectedValutation() {
		return selectedValutation;
	}

	public void setSelectedValutation(List<Valutation> selectedValutation) {
		this.selectedValutation = selectedValutation;
	}

	public String save(){

		Advice advice = new Advice();
		CUser cuser = (CUser) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("cuser"); 
		fillAdviceFromProperties(advice, cuser);
		System.out.println("advice "+advice);
		getAdviceFacade().createAdvice(advice);
		
//		TODO
		return "";
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	
	private void fillAdviceFromProperties(Advice advice, CUser cuser) {
//		advice.setEnddate(enddate);
//		advice.setSelectedLaws(selectedLaws);
		Set<Adviceobject> s = new HashSet<Adviceobject>(0);
		s.addAll(objects);
		advice.setAdviceobjects(s);
//		advice.setSelectedRequirements(selectedRequirements);
//		advice.setSelectedValutation(selectedValutation);
//		advice.setSelectedSectors(selectedSectors);
//		advice.setCuser(cuser);
		System.out.println(advice);
	}
	
	private AdviceFacade getAdviceFacade(){
		if(adviceFacade==null){
			adviceFacade = new AdviceFacade();
		}
		return adviceFacade;
	}
}
