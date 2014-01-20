package fra.project.mn.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import fra.project.mn.model.genericdata.Adviceobject;

@Entity
@Table(name = "ADVICE")
public class Advice {

	private long adviceId;
	private Set<Adviceobject> adviceobjects = new HashSet<Adviceobject>(0);

	public Advice() {
	}

	public Advice( Set<Adviceobject> adviceobjects) {
		this.adviceobjects = adviceobjects;
	}

	@Id
	@GeneratedValue
	@Column(name = "ADVICE_ID")
	public long getAdviceId() {
		return this.adviceId;
	}

	public void setAdviceId(long adviceId) {
		this.adviceId = adviceId;
	}

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "ADVICE_ADVICEOBJECT", joinColumns = { @JoinColumn(name = "ADVICE_ID") }, inverseJoinColumns = { @JoinColumn(name = "ADVICEOBJECT_ID") })
	public Set<Adviceobject> getAdviceobjects() {
		return this.adviceobjects;
	}

	public void setAdviceobjects(Set<Adviceobject> adviceobjects) {
		this.adviceobjects = adviceobjects;
	}

	@Override
	public String toString() {
		return "Advice [adviceId=" + adviceId + ", adviceobjects="
				+ adviceobjects + "]";
	}
	
}
