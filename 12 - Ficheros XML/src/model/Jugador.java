package model;

import java.util.Objects;

public class Jugador {

	private int iNumero;
	private String sNombre;
	private String sApellidos;
	private String sNick;
	private int iPuntos;
	
	public Jugador() {
		this.iNumero = 0;
		this.sNombre = "";
		this.sApellidos = "";
		this.sNick = "";
		this.iPuntos = 0;
	}
	
	public Jugador(int iNumero) {
		setiNumero(iNumero);
		this.sNombre = "";
		this.sApellidos = "";
		this.sNick = "";
		this.iPuntos = 0;
	}
	
	public Jugador(int iNumero, String sNombre, String sApellidos, String sNick, int iPuntos) {
		setiNumero(iNumero);
		setsNombre(sNombre);
		setsApellidos(sApellidos);
		setsNick(sNick);
		setiPuntos(iPuntos);
	}

	public int getiNumero() {
		return iNumero;
	}

	public void setiNumero(int iNumero) {

		this.iNumero = iNumero;
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

	public String getsNick() {
		return sNick;
	}

	public void setsNick(String sNick) {
		this.sNick = sNick;
	}

	public int getiPuntos() {
		return iPuntos;
	}

	public void setiPuntos(int iPuntos) {
		this.iPuntos = iPuntos;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(iNumero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		return iNumero == other.iNumero;
	}

	@Override
	public String toString() {
		return "Jugador [iNumero=" + iNumero + ", sNombre=" + sNombre + ", sApellidos=" + sApellidos + ", sNick="
				+ sNick + ", iPuntos=" + iPuntos + "]";
	}
	
	
	
	
}
