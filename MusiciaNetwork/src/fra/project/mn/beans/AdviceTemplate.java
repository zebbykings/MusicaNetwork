package fra.project.mn.beans;

import java.io.Serializable;
import java.util.List;

import fra.project.mn.facade.GenericResourceFacade;
import fra.project.mn.model.genericdata.Law;
import fra.project.mn.model.genericdata.Requirements;
import fra.project.mn.model.genericdata.Sector;
import fra.project.mn.model.genericdata.Valutation;

public class AdviceTemplate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GenericResourceFacade genericUserFacade;
	private List<Law> laws;
	private List<Requirements> requiriments;
	private List<Valutation> valutations;
	private List<Sector> sectors;

	private GenericResourceFacade getGenericResourceFacade() {
		if (genericUserFacade == null) {
			genericUserFacade = new GenericResourceFacade();
		}
		return genericUserFacade;
	}

	public List<Law> getLaws() {
		if (this.laws == null) {
			laws = getGenericResourceFacade().getLaws();
		}
		return laws;
	}

	public List<Requirements> getRequirements() {
		if (this.requiriments == null) {
			requiriments = getGenericResourceFacade().getRequirements();
		}
		return requiriments;
	}

	public List<Sector> getSectors() {
		if (this.sectors == null) {
			sectors = getGenericResourceFacade().getSectors();
		}
		return sectors;
	}

	public List<Valutation> getValutations() {
		if (this.valutations == null) {
			valutations = getGenericResourceFacade().getValutations();
		}
		return valutations;
	}

	public String getTitle() {
		return "AVVISO DI PROCEDURA PUBBLICA FINALIZZATA ALLA FORMAZIONE DI GRADUATORIE D’ISTITUTO";
	}

	public String getAdviceHeading() {
		// TODO template
		return "Ministero dell’Istruzione, dell’Università e della Ricerca";
	}

	public String getAdviceHeadingII() {
		// TODO template
		return "ALTA FORMAZIONE ARTISTICA E MUSICALE";
	}

}
