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
import javax.persistence.Table;

import fra.project.mn.model.genericdata.Certificate;
import fra.project.mn.model.genericdata.Sector;

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
	private Set<Certificate> certificates = new HashSet<Certificate>();
	
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
	public Set<Certificate> getCertificates() {
		return certificates;
	}
	public void setCertificates(Set<Certificate> certificates) {
		this.certificates = certificates;
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
