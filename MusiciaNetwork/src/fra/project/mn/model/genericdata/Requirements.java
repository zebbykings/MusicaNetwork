package fra.project.mn.model.genericdata;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import fra.project.mn.model.Advice;

@Entity
public class Requirements {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	public long idrequirements;
	private String requirements;

	public long getIdrequirements() {
		return idrequirements;
	}

	public void setIdrequirements(long idrequirements) {
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
		return "Requirements [idrequirements=" + idrequirements
				+ ", requirements=" + requirements + "]";
	}


}
