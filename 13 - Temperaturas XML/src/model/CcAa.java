package model;

import java.util.ArrayList;
import java.util.Objects;

public class CcAa {

	private String sNombre;
	private ArrayList<Provincia> listadoProvincias;
	
	public CcAa() {
		this.sNombre = "";
		this.listadoProvincias = new ArrayList<Provincia>();
	}
	
	public CcAa(String sNombre) {
		setsNombre(sNombre);
		this.listadoProvincias = new ArrayList<Provincia>();
	}

	public CcAa(String sNombre, ArrayList<Provincia> listadoProvincias) {
		setsNombre(sNombre);
		setListadoProvincias(listadoProvincias);
	}

	public String getsNombre() {
		return sNombre;
	}

	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}

	public ArrayList<Provincia> getListadoProvincias() {
		return listadoProvincias;
	}

	public void setListadoProvincias(ArrayList<Provincia> listadoProvincias) {
		this.listadoProvincias = listadoProvincias;
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
		CcAa other = (CcAa) obj;
		return Objects.equals(sNombre, other.sNombre);
	}

	@Override
	public String toString() {
		return "CcAa [sNombre=" + sNombre + ", listadoProvincias=" + listadoProvincias + "]";
	}
	
	
	
	
	
}
