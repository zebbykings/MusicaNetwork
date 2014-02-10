package fra.project.mn.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "cuser")
@NamedQueries({
		@NamedQuery(name = "CUser.findCUserByName", query = "select cu from CUser cu where cu.name = :name"),
		@NamedQuery(name = "CUser.isValidLoggin", query = "select cu from CUser cu where cu.username = :username and cu.password = :password") })

public class CUser implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_CUSER_BY_NAME = "CUser.findCUserByName";
	public static final String ISVALIDlOGIN = "CUser.isValidLoggin";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idcuser;

	private String name;
	private String username;
	private String password;
//	private String score;
	@ManyToMany
	private List<MUser> musers;
//	@ElementCollection
//	@CollectionTable(name="graded_muser")
//	@MapKey(name="score")
//	private Map<Integer, MUser> graded_musers = new HashMap<Integer, MUser>();
	
	public List<MUser> getMusers() {
		return musers;
	}

	public void setMusers(List<MUser> musers) {
		this.musers = musers;
	}

	public int getIdCUser() {
		return idcuser;
	}

	public void setIdCUser(int idCUser) {
		this.idcuser = idCUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	

//	public Map<Integer, MUser> getGraded_musers() {
//		return graded_musers;
//	}
//
//	public void setGraded_musers(Map<Integer, MUser> graded_musers) {
//		this.graded_musers = graded_musers;
//	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CUser other = (CUser) obj;
		if (idcuser != other.idcuser)
			return false;
		return true;
	}

}
