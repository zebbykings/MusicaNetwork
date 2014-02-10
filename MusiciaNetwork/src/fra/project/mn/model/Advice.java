package fra.project.mn.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import fra.project.mn.model.genericdata.Law;
import fra.project.mn.model.genericdata.Requirements;
import fra.project.mn.model.genericdata.Sector;
import fra.project.mn.model.genericdata.Valutation;

@Entity

@NamedQueries({
	@NamedQuery(name = "Advice.getAdviceById", query = "select a from Advice a where a.cuser = :cuser"),
	@NamedQuery(name = "Advice.removeById", query = "delete from Advice a where a.adviceId = :adviceId")
 })

public class Advice {

	public static final String FIND_CUSER_BY_NAME = "Advice.getAdviceById";
	public static final String DELETE_CUSER_BY_ID = "Advice.removeById";

	private long adviceId;
	private CUser cuser;
	private String enddate;
	private String title;
	private Set<Law> laws = new HashSet<Law>(0);
	private Set<Sector> sectors = new HashSet<Sector>(0);
	private Set<Requirements> requirements = new HashSet<Requirements>(0);
	private Set<Valutation> valutations = new HashSet<Valutation>(0);
	private Set<MUser> musicans = new HashSet<MUser>(0);
	public Advice() {
	}


	@Id
	@GeneratedValue
	public long getAdviceId() {
		return this.adviceId;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public void setAdviceId(long adviceId) {
		this.adviceId = adviceId;
	}
	@ManyToOne()
	public CUser getCuser() {
		return cuser;
	}
	public void setCuser(CUser cuser) {
		this.cuser = cuser;
	}	


	
	@ManyToMany()
	public Set<Law> getLaws() {
		return this.laws;
	}
	public void setLaws(Set<Law> laws) {
		this.laws = laws;
	}
	
	@ManyToMany()
	public Set<Sector> getSectors() {
		return this.sectors;
	}
	public void setSectors(Set<Sector> sectors) {
		this.sectors = sectors;
	}
	
	@ManyToMany()
	public Set<Requirements> getRequirements() {
		return this.requirements;
	}
	public void setRequirements(Set<Requirements> requirements) {
		this.requirements = requirements;
	}
	
	@ManyToMany()
	public Set<Valutation> getValutations() {
		return this.valutations;
	}
	public void setValutations(Set<Valutation> valutations) {
		this.valutations = valutations;
	}
		@ManyToMany()
	public Set<MUser> getMusicans() {
		return musicans;
	}

	public void setMusicans(Set<MUser> musicans) {
		this.musicans = musicans;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String end_date) {
		this.enddate = end_date;
	}

	@Override
	public String toString() {
		return "Advice [adviceId=" + adviceId + ", cuser=" + cuser
				+ ", enddate=" + enddate + ", title=" + title
				+ ", laws=" + laws
				+ ", sectors=" + sectors + ", requirements=" + requirements
				+ ", valutations=" + valutations + "]";
	}

	
	
}
