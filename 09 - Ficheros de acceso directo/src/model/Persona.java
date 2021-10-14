package model;

import java.util.Objects;

public class Persona implements IPersona{

	private String sNombre;
	private byte bEdad;
	private float fAltura;
	
	public Persona() {
		this.sNombre = "";
		this.bEdad = -1;
		this.fAltura = -1;
	}
	
	public Persona(String sNombre, byte bEdad, float fAltura) {
		setsNombre(sNombre);
		setbEdad(bEdad);
		setfAltura(fAltura);
	}

	public String getsNombre() {
		return sNombre;
	}

	public void setsNombre(String sNombre) {
		if (sNombre.length() <= 5) {
			this.sNombre = sNombre;
		}
	}

	public byte getbEdad() {
		return bEdad;
	}

	public void setbEdad(byte bEdad) {
		this.bEdad = bEdad;
	}

	public float getfAltura() {
		return fAltura;
	}

	public void setfAltura(float fAltura) {
		this.fAltura = fAltura;
	}
	
	public static byte getbNumCaracteresNombrePersona() {
		return bNumCaracteresNombrePersona;
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
		Persona other = (Persona) obj;
		return Objects.equals(sNombre, other.sNombre);
	}

	@Override
	public String toString() {
		return "Persona [sNombre=" + sNombre + ", bEdad=" + bEdad + ", fAltura=" + fAltura + "]";
	}
	
	
	
}
