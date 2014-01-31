package fra.project.mn.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import fra.project.mn.constant.Constant;
import fra.project.mn.facade.GenericResourceFacade;
import fra.project.mn.model.genericdata.Adviceobject;
import fra.project.mn.model.genericdata.Law;
import fra.project.mn.model.genericdata.Requirements;
import fra.project.mn.model.genericdata.Sector;
import fra.project.mn.model.genericdata.Valutation;
@ManagedBean(name="genericresource")
@SessionScoped
public class GenericResource implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GenericResourceFacade genericUserFacade;
	private List<Adviceobject> object;
	private List<Law> laws;
	private List<Requirements> requiriments;
	private List<Valutation> valutations;
	private List<Sector> sectors;
	
	private GenericResourceFacade getGenericResourceFacade() {
		if(genericUserFacade==null){
			genericUserFacade = new GenericResourceFacade();
		}
		return genericUserFacade;
	}
	
	public void setObjects(List<Adviceobject> object){	
		this.object = object;
	}
	public List<Adviceobject> getObjects(){	
		if(object==null){
			object = getGenericResourceFacade().getObject(); 
			putInSessiion(Constant.ADVICEOBJECT_LIST, object);
		}
		return object;
	}

	public List<Law> getLaws(){	
		if(this.laws==null){
			laws = getGenericResourceFacade().getLaws();
			putInSessiion(Constant.LAW_LIST, this.laws);
		}
		return laws;
	}
	public List<Requirements> getRequirements(){		
		if(this.requiriments==null){
			requiriments = getGenericResourceFacade().getRequirements();
			putInSessiion(Constant.REQUERIMENTS, this.requiriments);
		}
		return requiriments;
	}
	public List<Sector> getSectors(){		
		if(this.sectors==null){
			sectors = getGenericResourceFacade().getSectors();
			putInSessiion(Constant.SECTORS, this.sectors);
		}
		return sectors;
	}
	
	public List<Valutation> getValutations(){		
		if(this.valutations==null){
			valutations = getGenericResourceFacade().getValutations();
			putInSessiion(Constant.VALUTATIONS, this.valutations);
		}
		return valutations;
	}
	
	private void putInSessiion(String object_name, Object object) {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		request.getSession().setAttribute(object_name, object);
	}
}
