package fra.project.mn.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
	
	private GenericResourceFacade getGenericResourceFacade() {
		if(genericUserFacade==null){
			genericUserFacade = new GenericResourceFacade();
		}
		return genericUserFacade;
	}
	
	public List<Adviceobject> getObjects(){		
		return getGenericResourceFacade().getObject();
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
	
}
