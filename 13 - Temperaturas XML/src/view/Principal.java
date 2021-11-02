package view;

import ctrl.GestFch;
import model.CcAa;
import model.Ciudad;
import model.Provincia;

public class Principal {

	public static void main(String[] args) {
		final String FILE_NAME = "PB.XML";
		
		GestFch fchXML = new GestFch(FILE_NAME);
		
		for (CcAa ca : fchXML.getCcAa()) {
			System.out.println("Comnidad Autonoma: " + ca.getsNombre());
			for (Provincia p : ca.getListadoProvincias()) {
				System.out.println("\tProvincia: " + p.getsNombre());
				for (Ciudad c : p.getListadoCiudades()) {
					System.out.println("\t\tCiudad: " + c.getsNombre() + " [" + c.getdTempMin() + " - " + c.getdTempMax() + "]");
				}
			}
		}
	}
}
