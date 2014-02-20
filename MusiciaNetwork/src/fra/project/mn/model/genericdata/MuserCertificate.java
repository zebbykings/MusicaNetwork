package fra.project.mn.model.genericdata;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "MuserCertificate.findCertifcateByProperties", query = "select mc from MuserCertificate mc where mc.certificate = :certificate")
public class MuserCertificate {
	
	public static final String FIND_MUSERCERTIFICATE_BY_PROPERTIES = "MuserCertificate.findCertifcateByProperties";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idcertificate;
	@ManyToOne
	private Certificate certificate;
	private String city;
	private String year;
	@ManyToMany
	private Set<Sector> sectors = new HashSet<Sector>();

	public MuserCertificate() {
		super();
	}

	public int getIdcertificate() {
		return idcertificate;
	}

	public void setIdcertificate(int idcertificate) {
		this.idcertificate = idcertificate;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Certificate getCertificate() {
		return certificate;
	}

	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}

	public Set<Sector> getSectors() {
		return sectors;
	}

	public void setSectors(Set<Sector> sectors) {
		this.sectors = sectors;
	}

	
}
