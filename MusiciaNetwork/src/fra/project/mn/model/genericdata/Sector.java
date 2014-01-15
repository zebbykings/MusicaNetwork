package fra.project.mn.model.genericdata;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sector")
public class Sector {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	public int idsector;
	private String sector;
	private String code;
	
	public int getIdsector() {
		return idsector;
	}

	public void setIdsector(int idsector) {
		this.idsector = idsector;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}
	
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return  code+", "+sector;
	}
}
