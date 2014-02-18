package fra.project.mn.model.genericdata;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import fra.project.mn.model.genericdata.embeddable.CertificateID;

@Entity
public class Certificate {

	@EmbeddedId()
	CertificateID certificateId;
	
	public Certificate() {
		super();
	}
	
	public Certificate(String subject, CertificateType certificateType,
			InstitiuteType institiute) {
		super();
		this.certificateId = new CertificateID();
		
		this.certificateId.setSubject(subject);
		this.certificateId.setCertificateType(certificateType);
		this.certificateId.setInstitiute(institiute);
	}

	public CertificateID getCertificateId() {
		return certificateId;
	}

	public void setCertificateId(CertificateID certificateId) {
		this.certificateId = certificateId;
	}

	
}
