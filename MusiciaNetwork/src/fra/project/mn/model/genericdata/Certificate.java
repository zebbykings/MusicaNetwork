package fra.project.mn.model.genericdata;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Certificate {
	
	public int idcertificate;
	private String subject;
	private CertificateType certificateType;
	private InstitiuteType institiute;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getIdcertificate() {
		return idcertificate;
	}

	public void setIdcertificate(int idcertificate) {
		this.idcertificate = idcertificate;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public CertificateType getCertificateType() {
		return certificateType;
	}

	public void setCertificateType(CertificateType certificateType) {
		this.certificateType = certificateType;
	}
	public InstitiuteType getInstitiute() {
		return institiute;
	}

	public void setInstitiute(InstitiuteType institiute) {
		this.institiute = institiute;
	}
}
