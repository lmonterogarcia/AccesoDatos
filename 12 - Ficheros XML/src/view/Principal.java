package view;

import java.util.ArrayList;

import ctrl.GestionFchXML;
import model.Jugador;
import model.Partida;

public class Principal {

	public static void main(String[] args) {
		
		String sFileName = "archivos/datos.xml";
		GestionFchXML fchXML = new GestionFchXML(sFileName);
		
//		fchXML.mostrarDocumento();
		
		ArrayList<Partida> listadoPartidas = fchXML.getPartidas();
		ArrayList<Jugador> listadoJugadores = fchXML.getJugadores();
		
		for (Partida partida : listadoPartidas) {
			System.out.println(partida);
		}
		
		
		// Buscar los jugadores dentro de sus arrayList y asignarlos a las Partidas#######################
		
		
//		for (Jugador jugador : listadoJugadores) {
//			System.out.println(jugador);
//		}
		
//		fchXML.getJugadores().forEach( oJugador -> System.out.println(oJugador));

	}

}
