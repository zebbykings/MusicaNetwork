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
	private List<Adviceobject> object = getGenericResourceFacade().getObject(); 
	
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
//		TODO put in session requested list
		putInSessiion(Constant.ADVICEOBJECT_LIST, object);
		return object;
	}

	public List<Law> getLaws(){		
		return getGenericResourceFacade().getLaws();
	}
	public List<Sector> getSectors(){		
		return getGenericResourceFacade().getSectors();
	}
	public List<Requirements> getRequirements(){		
		return getGenericResourceFacade().getRequirements();
	}
	public List<Valutation> getValutations(){		
		return getGenericResourceFacade().getValutations();
	}
	
	private void putInSessiion(String object_name, Object object) {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		request.getSession().setAttribute(object_name, object);
	}
}
