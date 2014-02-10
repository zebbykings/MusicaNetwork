package fra.project.mn.beans.cuser;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fra.project.mn.beans.AdviceB;
import fra.project.mn.beans.AdviceTemplate;
import fra.project.mn.constant.Constant;
import fra.project.mn.model.Advice;
import fra.project.mn.model.CUser;
import fra.project.mn.model.genericdata.Law;
import fra.project.mn.model.genericdata.Requirements;
import fra.project.mn.model.genericdata.Sector;
import fra.project.mn.model.genericdata.Valutation;

@ManagedBean
@SessionScoped
public class AdviceBean extends AdviceB implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private AdviceTemplate ad = new AdviceTemplate();
	
//	create Advice data
	public Set<String> selectedSectors = new HashSet<String>();
	public String enddate="2014-01-30";

//	update data
	public String idToRemove;

	public Set<Sector> getCurrentSelectedSectors(){
		HashSet<Sector> sector_list = getObjectByIdFromSession(Constant.SECTORS, this.selectedSectors, "getSectorId");
		return sector_list;
	}

	public Set<String> getSelectedSectors() {
		return selectedSectors;
	}
	public void setSelectedSectors(Set<String> selectedSectors) {
		this.selectedSectors = selectedSectors;
	}
	
	public List<Sector> getSectors() {
		return this.ad.getSectors();
	}

	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String save(){
		Advice advice = new Advice();
		fillAdvice(advice);
		getAdviceFacade().createAdvice(advice);
		
		return "MyAdvices";
	}
	
	public String getAdviceHeading() {
		return this.ad.getAdviceHeading();
	}

	public String getAdviceHeadingII() {
		return this.ad.getAdviceHeadingII();

	}
	
	private void fillAdvice(Advice advice) {
		advice.setEnddate(enddate);
		
//		set all default list on advice
		advice.setTitle(this.ad.getTitle());
		
		HashSet<Law> law_list = new HashSet<Law>();
		law_list.addAll(this.ad.getLaws());
		advice.setLaws(law_list);
		HashSet<Requirements> requiriment_list = new HashSet<Requirements>();
		requiriment_list.addAll(this.ad.getRequirements());
		advice.setRequirements(requiriment_list);		
		HashSet<Valutation> valutation_list = new HashSet<Valutation>();
		valutation_list.addAll(this.ad.getValutations());
		advice.setValutations(valutation_list);
		
//		set sectors from selected item
		HashSet<Sector> sector_list= getObjectByIdFromSession(Constant.SECTORS, this.selectedSectors, "getSectorId");
		advice.setSectors(sector_list);
		
		advice.setCuser((CUser) getFromSession(Constant.CUSER));
	}
	
	private <T> HashSet<T> getObjectByIdFromSession(String constant, Set<String> id_list, String method_name) {
		@SuppressWarnings("unchecked")
//		List<T> t_list = (List<T>) getFromSession(constant);
		List<T> t_list = (List<T>) this.ad.getSectors();
		
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

}
