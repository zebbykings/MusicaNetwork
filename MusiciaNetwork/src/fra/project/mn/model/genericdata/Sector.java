package fra.project.mn.model.genericdata;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import fra.project.mn.model.Advice;


/**
 * The persistent class for the sector database table.
 * 
 */
@Entity
@NamedQuery(name="Sector.findAll", query="SELECT s FROM Sector s")
public class Sector implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long sectorId;

	private String code;

	private String name;
	public Sector() {
	}

	public long getSectorId() {
		return this.sectorId;
	}

	public void setSectorId(long sectorId) {
		this.sectorId = sectorId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Sector [sectorId=" + sectorId + ", code=" + code + ", name="
				+ name + "]";
	}

	
}