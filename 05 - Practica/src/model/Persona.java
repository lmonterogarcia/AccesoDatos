package model;

import java.util.Objects;

public class Persona {

	private String sNombre, sApellidos;
	private byte bEdades;
	
	public Persona(String sNombre, String sApellido, byte bEdad) {
		setsNombre(sNombre);
		setsApellidos(sApellido);
		setbEdades(bEdad);
	}
	
	public String getsNombre() {
		return sNombre;
	}
	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}
	public String getsApellidos() {
		return sApellidos;
	}
	public void setsApellidos(String sApellidos) {
		this.sApellidos = sApellidos;
	}
	public byte getbEdades() {
		return bEdades;
	}
	public void setbEdades(byte bEdades) {
		this.bEdades = bEdades;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bEdades, sApellidos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return bEdades == other.bEdades && Objects.equals(sApellidos, other.sApellidos);
	}

	@Override
	public String toString() {
		return "Persona [sNombre=" + sNombre + ", sApellidos=" + sApellidos + ", bEdades=" + bEdades + "]";
	}
	
	
}
