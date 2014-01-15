package fra.project.mn.model.genericdata;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "certificate")
public class Certificate {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	public int idcertificate;
	private String subject;
	private String type;


	@Override
	public String toString() {
		return  subject+" "+type;
	}
}
