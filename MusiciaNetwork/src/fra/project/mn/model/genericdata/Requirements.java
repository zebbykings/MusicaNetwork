package fra.project.mn.model.genericdata;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "requirements")
public class Requirements {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	public int idrequirements;
	private String requirements;

	public int getIdrequirements() {
		return idrequirements;
	}

	public void setIdrequirements(int idrequirements) {
		this.idrequirements = idrequirements;
	}

	public String getRequirements() {
		return requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

	@Override
	public String toString() {
		return  requirements;
	}
}
