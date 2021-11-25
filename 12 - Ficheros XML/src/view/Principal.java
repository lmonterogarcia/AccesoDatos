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
		
//		ArrayList<Partida> listadoPartidas = fchXML.getPartidas();
//		ArrayList<Jugador> listadoJugadores = fchXML.getJugadores();
//		
//		for (Partida partida : listadoPartidas) {
//			System.out.println(partida);
//		}
		// Buscar los jugadores dentro de sus arrayList y asignarlos a las Partidas#######################
		
//		fchXML.addJugador(new Jugador(678, "Fernando", "Gomez Murube", "La Masa", 146));
//		fchXML.addJugador(new Jugador(563, "Javier", "Garcia Murube", "Luigi", 45));
//		fchXML.addJugador(new Jugador(786, "Miguel", "Murube Murube", "Gordo", 76));
//		fchXML.addJugador(new Jugador(2, "Oliver", "Montero Lopez", "Flaco", 123));
		fchXML.mostrarDocumento();
		
//		fchXML.saveData();
		
		
		
		
		
//		for (Jugador jugador : listadoJugadores) {
//			System.out.println(jugador);
//		}
		
//		fchXML.getJugadores().forEach( oJugador -> System.out.println(oJugador));

	}

}
