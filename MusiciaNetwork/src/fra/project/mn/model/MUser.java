package fra.project.mn.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fra.project.mn.model.genericdata.MuserCertificate;
import fra.project.mn.model.genericdata.Eligibility;
import fra.project.mn.model.genericdata.Esibition;
import fra.project.mn.model.genericdata.MusicalProduction;
import fra.project.mn.model.genericdata.Publication;
import fra.project.mn.model.genericdata.Sector;
import fra.project.mn.model.genericdata.ServiceTitle;

@Entity
@Table(name="muser")
@NamedQueries({
	@NamedQuery(name = "MUser.findMUserByName", query = "select mu from MUser mu where mu.name = :name"),
	@NamedQuery(name = "MUser.isValidLoggin", query = "select mu from MUser mu where mu.mail = :mail and mu.password = :password") })

public class MUser implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String FIND_MUSER_BY_NAME = "MUser.findMUserByName";
	public static final String ISVALIDlOGIN = "MUser.isValidLoggin";
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idmuser;
	private String name;
	@Column(unique=true)
	private String mail;
	private String password;
	@ManyToMany
	private List<CUser> cusers;
	@ManyToMany()
	private Set<Sector> sectors = new HashSet<Sector>();
	@ManyToMany()
	private Set<MuserCertificate> certificates = new HashSet<MuserCertificate>();
	@OneToMany
	private Set<ServiceTitle> serviceTitles = new HashSet<ServiceTitle>();
	@OneToMany
	private Set<Publication> pubblicatons = new HashSet<Publication>();
	@OneToMany
	private Set<MusicalProduction> musicalProductions = new HashSet<MusicalProduction>();
	@OneToMany
	private Set<Esibition> esibitions = new HashSet<Esibition>();
	@OneToMany
	private Set<Eligibility> eligibility = new HashSet<Eligibility>();
	
	public int getIdmuser() {
		return idmuser;
	}
	public void setIdmuser(int idmuser) {
		this.idmuser = idmuser;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<CUser> getCusers() {
		return cusers;
	}
	public void setCusers(List<CUser> cusers) {
		this.cusers = cusers;
	}
	
	public Set<Sector> getSectors() {
		return sectors;
	}
	public void setSectors(Set<Sector> sectors) {
		this.sectors = sectors;
	}	
	public Set<MuserCertificate> getCertificates() {
		return certificates;
	}
	public void setCertificates(Set<MuserCertificate> certificates) {
		this.certificates = certificates;
	}
	
	public Set<ServiceTitle> getServiceTitles() {
		return serviceTitles;
	}
	public void setServiceTitles(Set<ServiceTitle> serviceTitles) {
		this.serviceTitles = serviceTitles;
	}
	
	
	
	public Set<Publication> getPubblicatons() {
		return pubblicatons;
	}
	public void setPubblicatons(Set<Publication> pubblicatons) {
		this.pubblicatons = pubblicatons;
	}
	public Set<MusicalProduction> getMusicalProductions() {
		return musicalProductions;
	}
	public void setMusicalProductions(Set<MusicalProduction> musicalProductions) {
		this.musicalProductions = musicalProductions;
	}
	public Set<Esibition> getEsibitions() {
		return esibitions;
	}
	public void setEsibitions(Set<Esibition> esibitions) {
		this.esibitions = esibitions;
	}
	public Set<Eligibility> getEligibility() {
		return eligibility;
	}
	public void setEligibility(Set<Eligibility> eligibility) {
		this.eligibility = eligibility;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idmuser;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MUser other = (MUser) obj;
		if (idmuser != other.idmuser)
			return false;
		return true;
	}
	
	
}
