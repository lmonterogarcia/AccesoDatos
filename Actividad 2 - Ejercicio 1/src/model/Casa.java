package model;

import java.io.Serializable;

public class Casa implements Serializable{


	private static final long serialVersionUID = 1L;
	private String sPoblacion;
	private Double dSuperficie;
	private int iAseos;
	
	public Casa() {
		
	}
	
	public Casa(String sPoblacion, Double dSuperficie, int iAseos) {
		this.sPoblacion = sPoblacion;
		this.dSuperficie = dSuperficie;
		this.iAseos = iAseos;
	}

	public String getsPoblacion() {
		return sPoblacion;
	}

	public void setsPoblacion(String sPoblacion) {
		this.sPoblacion = sPoblacion;
	}

	public Double getdSuperficie() {
		return dSuperficie;
	}

	public void setdSuperficie(Double dSuperficie) {
		this.dSuperficie = dSuperficie;
	}

	public int getiAseos() {
		return iAseos;
	}

	public void setiAseos(int iAseos) {
		this.iAseos = iAseos;
	}

	@Override
	public String toString() {
		return "Casa [sPoblacion=" + sPoblacion + ", dSuperficie=" + dSuperficie + ", iAseos=" + iAseos + "]";
	}
	
	
}
