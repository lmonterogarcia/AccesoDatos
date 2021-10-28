package model;

import java.util.ArrayList;
import java.util.Objects;

public class Provincia {

	private String sNombre;
	private ArrayList<Ciudad> listadoCiudades;
	
	public Provincia() {
		setsNombre("");
		setListadoCiudades(new  ArrayList<Ciudad>());
	}
	
	public Provincia(String sNombre) {
		setsNombre(sNombre);
		setListadoCiudades(new  ArrayList<Ciudad>());
	}
	
	public Provincia(String sNombre, ArrayList<Ciudad> listadoCiudades) {
		setsNombre(sNombre);
		setListadoCiudades(listadoCiudades);
	}
	
	public String getsNombre() {
		return sNombre;
	}
	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}
	public ArrayList<Ciudad> getListadoCiudades() {
		return listadoCiudades;
	}
	public void setListadoCiudades(ArrayList<Ciudad> listadoProvincia) {
		this.listadoCiudades = listadoProvincia;
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
		Provincia other = (Provincia) obj;
		return Objects.equals(sNombre, other.sNombre);
	}

	@Override
	public String toString() {
		return "Provincia [sNombre=" + sNombre + ", listadoCiudades=" + listadoCiudades + "]";
	}
	
	
	
}
