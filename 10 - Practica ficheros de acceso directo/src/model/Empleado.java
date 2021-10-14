package model;

import java.util.Objects;

public class Empleado implements IEmpleado{

	private String sNombre, sApellidos, sEmail;
	private long lTelefono;
	private int iEdad;
	private double dSueldo;
	
	public Empleado() {
		this.sNombre = "";
		this.sApellidos = "";
		this.sEmail = "";
		this.lTelefono = -1;
		this.iEdad = -1;
		this.dSueldo = -1;
	}
	
	public Empleado(String sNombre, String sApellidos,long lTelefono, String sEmail, int iEdad, double dSueldo) {
		setsNombre(sNombre);
		setsApellidos(sApellidos);
		setsEmail(sEmail);
		setlTelefono(lTelefono);
		setiEdad(iEdad);
		setdSueldo(dSueldo);
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

	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public long getlTelefono() {
		return lTelefono;
	}

	public void setlTelefono(long lTelefono) {
		this.lTelefono = lTelefono;
	}

	public int getiEdad() {
		return iEdad;
	}

	public void setiEdad(int iEdad) {
		this.iEdad = iEdad;
	}

	public double getdSueldo() {
		return dSueldo;
	}

	public void setdSueldo(double dSueldo) {
		this.dSueldo = dSueldo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(sEmail);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(sEmail, other.sEmail);
	}

	@Override
	public String toString() {
		return "Empleado [sNombre=" + sNombre + ", sApellidos=" + sApellidos + ", sEmail=" + sEmail + ", lTelefono="
				+ lTelefono + ", iEdad=" + iEdad + ", dSueldo=" + dSueldo + "]";
	}
	
	
	
	
	
	
	
}
