package fra.project.mn.model.genericdata;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "certificate")
public class Certificate {
	
	public int idcertificate;
	private String subject;
	private String type;
	private Set<Valutation> valuations = new HashSet<Valutation>(0);
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getIdcertificate() {
		return idcertificate;
	}

	public void setIdcertificate(int idcertificate) {
		this.idcertificate = idcertificate;
	}


	public String getSubject() {
		return subject;
	}



	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}

	@ManyToMany(mappedBy="certificates")
	public Set<Valutation> getValuation() {
		return valuations;
	}

	public void setValuation(Set<Valutation> valuations) {
		this.valuations = valuations;
	}

	@Override
	public String toString() {
		return "Certificate [idcertificate=" + idcertificate + ", subject="
				+ subject + ", type=" + type + "]";
	}


	
}
