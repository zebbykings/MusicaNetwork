package fra.project.mn.beans.cuser;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fra.project.mn.beans.AdviceB;
import fra.project.mn.constant.Constant;
import fra.project.mn.facade.CUserFacade;
import fra.project.mn.model.Advice;
import fra.project.mn.model.CUser;
import fra.project.mn.model.genericdata.Adviceobject;
import fra.project.mn.model.genericdata.Law;
import fra.project.mn.model.genericdata.Requirements;
import fra.project.mn.model.genericdata.Sector;
import fra.project.mn.model.genericdata.Valutation;

@ManagedBean(name="advicebean")
@SessionScoped
public class AdviceBean extends AdviceB implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CUserFacade cuserFacade;
//	create Advice data
	public Set<String> objects = new HashSet<String>();
	public Set<String> selectedLaws = new HashSet<String>();
	public Set<String> selectedSectors = new HashSet<String>();
	public Set<String> selectedRequirements = new HashSet<String>();
	public Set<String> selectedValutation = new HashSet<String>();
	public String enddate="2014-01-30";
	public String title="";
//	getter data
	public List<Advice> myAdvices;
//	update data
	public String idToRemove;
	
	public Set<String> getObjects() {
		return objects;
	}
	public void setObjects(Set<String> objects) {
		this.objects = objects;
	}


	public Set<String> getSelectedLaws() {
		return selectedLaws;
	}
	public void setSelectedLaws(Set<String> selectedLaws) {
		this.selectedLaws = selectedLaws;
	}

	public Set<String> getSelectedSectors() {
		return selectedSectors;
	}
	public void setSelectedSectors(Set<String> selectedSectors) {
		this.selectedSectors = selectedSectors;
	}

	public Set<String> getSelectedRequirements() {
		return selectedRequirements;
	}
	public void setSelectedRequirements(Set<String> selectedRequirements) {
		this.selectedRequirements = selectedRequirements;
	}

	public Set<String> getSelectedValutation() {
		return selectedValutation;
	}
	public void setSelectedValutation(Set<String> selectedValutation) {
		this.selectedValutation = selectedValutation;
	} 
	
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
			
	public String getIdToRemove() {
		return idToRemove;
	}
	public void setIdToRemove(String idToRemove) {
		this.idToRemove = idToRemove;
	}
	
	public String remove(){
		long id_advice = Long.parseLong((FacesContext.getCurrentInstance().
				getExternalContext().getRequestParameterMap().get("a_id")));
			getAdviceFacade().removeById(id_advice);
		return "";
	}
	
	public List<Advice> getMyAdvices() {
		myAdvices = getCuserFacade().getMyAdvice(((CUser) getFromSession(Constant.CUSER)));
		return myAdvices;
	}
	
	public String save(){
		Advice advice = new Advice();
		fillAdviceFromProperties(advice);
		getAdviceFacade().createAdvice(advice);
		
//		TODO
		return "";
	}
	private void fillAdviceFromProperties(Advice advice) {
		advice.setEnddate(enddate);
		advice.setTitle(title);
		
		HashSet<Adviceobject> ado_list = getObjectFromSession(Constant.ADVICEOBJECT_LIST, this.objects, "getAdviceobjectId");
		advice.setAdviceobjects(ado_list);
		
		HashSet<Law> law_list = getObjectFromSession(Constant.LAW_LIST, this.selectedLaws, "getIdlaw");
		advice.setLaws(law_list);
		
		HashSet<Sector> sector_list= getObjectFromSession(Constant.SECTORS, this.selectedSectors, "getSectorId");
		advice.setSectors(sector_list);
		
		HashSet<Requirements> requiriment_list= getObjectFromSession(Constant.REQUERIMENTS, this.selectedRequirements, "getIdrequirements");
		advice.setRequirements(requiriment_list);
		
		HashSet<Valutation> valutation_list= getObjectFromSession(Constant.VALUTATIONS, this.selectedValutation, "getIdvalutation");
		advice.setValutations(valutation_list);
		
		advice.setCuser((CUser) getFromSession(Constant.CUSER));
	}
	private <T> HashSet<T> getObjectFromSession(String constant, Set<String> id_list, String method_name) {
		@SuppressWarnings("unchecked")
		List<T> t_list = (List<T>) getFromSession(constant);
		
		long[] array_long = new long[id_list.size()];
		int i = 0;
		for (String curr_id : id_list) {
			array_long[i]=Long.parseLong(curr_id);
			i++;
		}
		HashSet<T> s = new HashSet<T>();
		for (T t : t_list) {
			for(i = 0; i<array_long.length;i++){
				Method get_id_method;
				try {
					
					get_id_method = t.getClass().getMethod(method_name);
					long l = (long) get_id_method.invoke(t);
					if(l ==array_long[i]){
						s.add(t);
					}
				
				} catch (NoSuchMethodException | SecurityException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
			
		}
		return s;
	}

	private CUserFacade getCuserFacade(){
		if(cuserFacade==null){
			cuserFacade = new CUserFacade();
		}
		return cuserFacade;
	}


}
