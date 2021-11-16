package model;

import javax.persistence.*;

@Entity
@Table(name="Coche")
public class Coche {

	@Id
	//MYSQL @GeneratedValue(GenerationType.IDENTITY)
	@GeneratedValue(generator="seqCoche")
	@SequenceGenerator(name="seqCoche",sequenceName = "SEQ_COCHE", allocationSize = 1)
	@Column(name="ID_COCHE")
	private Integer iIdCoche;
	@Column(name="MARCA")
	private String sMarca;
	@Column(name="MODELO")
	private String sModelo;
	@Column(name="POTENCIA")
	private Integer iPotencia;
	
	public Coche() {
		this.iIdCoche = null;
		this.sMarca = "";
		this.sModelo = "";
		this.iPotencia = null;
	}
	
	public Coche(Integer iIdCoche, String sMarca, String sModelo, Integer iPotencia) {
		this.iIdCoche = iIdCoche;
		this.sMarca = sMarca;
		this.sModelo = sModelo;
		this.iPotencia = iPotencia;
	}
	
	public Coche(String sMarca, String sModelo, Integer iPotencia) {
		this.sMarca = sMarca;
		this.sModelo = sModelo;
		this.iPotencia = iPotencia;
	}

	public Integer getiIdCoche() {
		return iIdCoche;
	}

	public void setiIdCoche(Integer iIdCoche) {
		this.iIdCoche = iIdCoche;
	}

	public String getsMarca() {
		return sMarca;
	}

	public void setsMarca(String sMarca) {
		this.sMarca = sMarca;
	}

	public String getsModelo() {
		return sModelo;
	}

	public void setsModelo(String sModelo) {
		this.sModelo = sModelo;
	}

	public Integer getiPotencia() {
		return iPotencia;
	}

	public void setiPotencia(Integer iPotencia) {
		this.iPotencia = iPotencia;
	}

	@Override
	public String toString() {
		return "Coche [iIdCoche=" + iIdCoche + ", sMarca=" + sMarca + ", sModelo=" + sModelo + ", iPotencia="
				+ iPotencia + "]";
	}
	
	
	
	
	
}
