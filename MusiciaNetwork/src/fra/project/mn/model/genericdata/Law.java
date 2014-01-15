package fra.project.mn.model.genericdata;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "law")
public class Law {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	public int idlaw;
	private String law;
	
	public int getIdlaw() {
		return idlaw;
	}

	public void setIdlaw(int idlaw) {
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
