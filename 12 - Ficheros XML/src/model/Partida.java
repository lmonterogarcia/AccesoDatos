package model;

import java.util.Objects;

public class Partida {

	private int iNumero, iDuracion;
	private Jugador oJugador1, oJugador2;
	
	public Partida() {

		this.iNumero = 0;
		this.iDuracion = 0;
		this.oJugador1 = null;
		this.oJugador2 = null;
		
	}
	
	public Partida(int iNumero, int iDuracion, Jugador oJugador1, Jugador oJugador2) {

		this.iNumero = iNumero;
		this.iDuracion = iDuracion;
		this.oJugador1 = oJugador1;
		this.oJugador2 = oJugador2;
		
	}

	public int getiNumero() {
		return iNumero;
	}

	public void setiNumero(int iNumero) {
		this.iNumero = iNumero;
	}

	public int getiDuracion() {
		return iDuracion;
	}

	public void setiDuracion(int iDuracion) {
		this.iDuracion = iDuracion;
	}

	public Jugador getoJugador1() {
		return oJugador1;
	}

	public void setoJugador1(Jugador oJugador1) {
		this.oJugador1 = oJugador1;
	}

	public Jugador getoJugador2() {
		return oJugador2;
	}

	public void setoJugador2(Jugador oJugador2) {
		this.oJugador2 = oJugador2;
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
		Partida other = (Partida) obj;
		return iNumero == other.iNumero;
	}

	@Override
	public String toString() {
		return "Partida [iNumero=" + iNumero + ", iDuracion=" + iDuracion + ", oJugador1=" + oJugador1 + ", oJugador2="
				+ oJugador2 + "]";
	}
	
	
	
	
}
