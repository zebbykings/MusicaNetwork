package fra.project.mn.model.genericdata;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fra.project.mn.model.Advice;

@Entity
public class Valutation {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	public long idvalutation;
	@ManyToOne(optional=false)
	private Sector sector;
	@ManyToMany()
	private Set<Certificate> certificates = new HashSet<Certificate>(0);;

	public long getIdvalutation() {
		return idvalutation;
	}



	public void setIdvalutation(long idvalutation) {
		this.idvalutation = idvalutation;
	}



	public Sector getSector() {
		return sector;
	}



	public void setSector(Sector sector) {
		this.sector = sector;
	}


	public Set<Certificate> getCertificates() {
		return certificates;
	}



	public void setCertificates(Set<Certificate> certificates) {
		this.certificates = certificates;
	}






	@Override
	public String toString() {
		return "Valutation [idvalutation=" + idvalutation + /*", sector="
				+ sector +*/ ", certificates=" + certificates + "]";
	}	
}
