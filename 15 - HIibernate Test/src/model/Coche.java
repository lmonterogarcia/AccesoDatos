package model;

public class Coche {

	private Integer iIdCoche;
	private String sMarca;
	private String sModelo;
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
