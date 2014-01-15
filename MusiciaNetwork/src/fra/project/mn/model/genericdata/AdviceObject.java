package fra.project.mn.model.genericdata;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table(name = "adviceObject")
public class AdviceObject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	public int idadvice;
	private String adviceObjects;
	public int getIdadvice() {
		return idadvice;
	}
	public void setIdadvice(int idadvice) {
		this.idadvice = idadvice;
	}
	public String getAdviceObjects() {
		return adviceObjects;
	}
	public void setAdviceObjects(String adviceObjects) {
		this.adviceObjects = adviceObjects;
	}
	@Override
	public String toString() {
		return "AdviceObject [idadvice=" + idadvice + ", adviceObjects="
				+ adviceObjects + "]";
	}
	
	
}
