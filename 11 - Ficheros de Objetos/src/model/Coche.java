package model;

import java.io.Serializable;

public class Coche implements Serializable{


	private static final long serialVersionUID = 1L;
	private String sMarca, sModelo;
	private int iPotencia;
	
	
	public Coche() {
		this.sMarca = "";
		this.sModelo = "";
		this.iPotencia = -1;
	}
	
	public Coche(String sMarca, String sModelo, int iPotencia) {
		setsMarca(sMarca);
		setsModelo(sModelo);
		setiPotencia(iPotencia);
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

	public int getiPotencia() {
		return iPotencia;
	}

	public void setiPotencia(int iPotencia) {
		this.iPotencia = iPotencia;
	}

	@Override
	public String toString() {
		return "Coche [sMarca=" + sMarca + ", sModelo=" + sModelo + ", iPotencia=" + iPotencia + "]";
	}
	
	
}
