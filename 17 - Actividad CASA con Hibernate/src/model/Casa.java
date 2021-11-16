package model;

import java.io.Serializable;

public class Casa implements Serializable{

	private Integer iId, iNumero;
	private String sCalle;
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
