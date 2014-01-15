package fra.project.mn.beans.cuser;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fra.project.mn.model.Advice;
import fra.project.mn.model.genericdata.AdviceObject;

@ManagedBean(name="advicebean")
@SessionScoped
public class AdviceBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public List<AdviceObject> selectedObjects;
	public List<AdviceObject> selectedLaws;
	public List<AdviceObject> selectedSectors;
	public List<AdviceObject> selectedRequirements;
	public List<AdviceObject> selectedValutation;

	public String enddate;
	
	public List<AdviceObject> getSelectedObjects() {
		return selectedObjects;
	}	

	public void setSelectedObjects(List<AdviceObject> selectedObjects) {
		this.selectedObjects = selectedObjects;
	}

	public List<AdviceObject> getSelectedLaws() {
		return selectedLaws;
	}

	public void setSelectedLaws(List<AdviceObject> selectedLaws) {
		this.selectedLaws = selectedLaws;
	}

	public List<AdviceObject> getSelectedSectors() {
		return selectedSectors;
	}

	public void setSelectedSectors(List<AdviceObject> selectedSectors) {
		this.selectedSectors = selectedSectors;
	}

	public List<AdviceObject> getSelectedRequirements() {
		return selectedRequirements;
	}

	public void setSelectedRequirements(List<AdviceObject> selectedRequirements) {
		this.selectedRequirements = selectedRequirements;
	}

	public List<AdviceObject> getSelectedValutation() {
		return selectedValutation;
	}

	public void setSelectedValutation(List<AdviceObject> selectedValutation) {
		this.selectedValutation = selectedValutation;
	}

	public String save(){
		System.out.println("selectedObjects "+selectedObjects);
		System.out.println("selectedLaws "+selectedLaws);
		System.out.println("selectedSectors"+selectedSectors);
		System.out.println("selectedRequirements "+selectedRequirements);
		System.out.println("selectedValuation "+selectedValutation);
		return "";
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	
	private void fillAdviceFromProperties(Advice advice) {
		advice.setEnddate(enddate);
		//TODO
		// dopo che ho mappato il box su oggetti
		
	}
}
