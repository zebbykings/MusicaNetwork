package fra.project.mn.beans.cuser;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jboss.weld.bean.builtin.ee.HttpSessionBean;

import fra.project.mn.constant.Constant;
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
	public Set<String> objects = new HashSet<String>();
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
	
	public Set<String> getObjects() {
		return objects;
	}	

	public void setObjects(Set<String> objects) {
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
		for (String objectId : objects) {
			
		}
		List<Adviceobject> object_list = (List<Adviceobject>) getFromSessiion(Constant.ADVICEOBJECT_LIST);
		
		long[] array_long = new long[this.objects.size()];
		int i = 0;
		for (String object_id : this.objects) {
			array_long[i]=Long.parseLong(object_id);
		}
		HashSet<Adviceobject> s = new HashSet<Adviceobject>();
		for (Adviceobject adviceobject : object_list) {
			for(i = 0; i<array_long.length;i++){
				if(adviceobject.getAdviceobjectId()==array_long[i]){
					s.add(adviceobject);
				}
			}
			
		}
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
	
	private Object getFromSessiion(String object_name) {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		return request.getSession().getAttribute(object_name);
	}
}
