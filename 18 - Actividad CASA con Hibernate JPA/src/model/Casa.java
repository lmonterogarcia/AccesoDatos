package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "Casa")
public class Casa implements Serializable {

	@Id
	@GeneratedValue(generator = "seqCasa")
	@SequenceGenerator(name = "seqCasa", sequenceName = "SEQ_CASA", allocationSize = 1)
	@Column(name = "ID_CASA")
	private Integer iId;
	@Column(name = "CALLE")
	private String sCalle;
	@Column(name = "NUMERO")
	private Integer iNumero;
	@Column(name = "SUPERFICIE")
	private Double dSuperficie;

	public Casa() {
	}

	public Casa(String sCalle, Integer iNumero, Double dSuperficie) {
		this.iNumero = iNumero;
		this.sCalle = sCalle;
		this.dSuperficie = dSuperficie;
	}

	public Casa(Integer iId, String sCalle, Integer iNumero, Double dSuperficie) {
		this.iId = iId;
		this.iNumero = iNumero;
		this.sCalle = sCalle;
		this.dSuperficie = dSuperficie;
	}

	public Integer getiId() {
		return iId;
	}

	public void setiId(Integer iId) {
		this.iId = iId;
	}

	public Integer getiNumero() {
		return iNumero;
	}

	public void setiNumero(Integer iNumero) {
		this.iNumero = iNumero;
	}

	public String getsCalle() {
		return sCalle;
	}

	public void setsCalle(String sCalle) {
		this.sCalle = sCalle;
	}

	public Double getdSuperficie() {
		return dSuperficie;
	}

	public void setdSuperficie(Double dSuperficie) {
		this.dSuperficie = dSuperficie;
	}

	@Override
	public String toString() {
		return "Casa [iId=" + iId + ", iNumero=" + iNumero + ", sCalle=" + sCalle + ", dSuperficie=" + dSuperficie
				+ "]";
	}

}
