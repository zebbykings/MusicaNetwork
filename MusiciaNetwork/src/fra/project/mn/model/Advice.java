package fra.project.mn.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fra.project.mn.model.genericdata.AdviceObject;
import fra.project.mn.model.genericdata.Law;
import fra.project.mn.model.genericdata.Requirements;
import fra.project.mn.model.genericdata.Sector;
import fra.project.mn.model.genericdata.Valutation;

@Entity
@Table(name="advice")
public class Advice {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int idadvice;
	@ManyToOne
	CUser cuser;
	@ManyToMany
	public List<AdviceObject> selectedObjects;
	@ManyToMany
	public List<Law> selectedLaws;
	@ManyToMany
	public List<Sector> selectedSectors;
	@ManyToMany
	public List<Requirements> selectedRequirements;
	@ManyToMany
	public List<Valutation> selectedValutation;

	public String enddate;

	public List<AdviceObject> getSelectedObjects() {
		return selectedObjects;
	}

	public void setSelectedObjects(List<AdviceObject> selectedObjects) {
		this.selectedObjects = selectedObjects;
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

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	
}
