package fra.project.mn.model.genericdata;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "valutation")
public class Valutation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	public int idvalutation;
	@OneToOne
	private Sector sector;
	@ManyToMany
	private List<Certificate> certificates;
	@Override
	public String toString() {
		return "Valutation [idvalutation=" + idvalutation + ", sector="
				+ sector + ", certificates=" + certificates + "]";
	}	
}
