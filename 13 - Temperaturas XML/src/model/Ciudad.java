package model;

import java.util.Objects;

public class Ciudad {
	
	private String sNombre;
	private Double dTempMin, dTempMax;
	
	
	public Ciudad() {
		setsNombre("");
		setdTempMin(0d);
		setdTempMax(0d);
	}
	
	public Ciudad(String sNombre) {
		setsNombre(sNombre);
		setdTempMin(0d);
		setdTempMax(0d);
	}
	
	public Ciudad(String sNombre, Double dTempMin, Double dTempMax) {
		setsNombre(sNombre);
		setdTempMin(dTempMin);
		setdTempMax(dTempMax);
	}
	
	public String getsNombre() {
		return sNombre;
	}
	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}
	public Double getdTempMin() {
		return dTempMin;
	}
	public void setdTempMin(Double dTempMin) {
		this.dTempMin = dTempMin;
	}
	public Double getdTempMax() {
		return dTempMax;
	}
	public void setdTempMax(Double dTempMax) {
		this.dTempMax = dTempMax;
	}

	@Override
	public int hashCode() {
		return Objects.hash(sNombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ciudad other = (Ciudad) obj;
		return Objects.equals(sNombre, other.sNombre);
	}

	@Override
	public String toString() {
		return "Ciudad [sNombre=" + sNombre + ", dTempMin=" + dTempMin + ", dTempMax=" + dTempMax + "]";
	}
	
	
	
	
}
