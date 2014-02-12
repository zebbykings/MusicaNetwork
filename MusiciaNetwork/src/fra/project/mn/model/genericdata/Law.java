package fra.project.mn.model.genericdata;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Law {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	public long idlaw;
	private String law;
	public long getIdlaw() {
		return idlaw;
	}

	public void setIdlaw(long idlaw) {
		this.idlaw = idlaw;
	}

	public String getLaw() {
		return law;
	}

	public void setLaw(String law) {
		this.law = law;
	}
	


	@Override
	public String toString() {
		return "Law [idlaw=" + idlaw + ", law=" + law + "]";
	}

	
	
}
