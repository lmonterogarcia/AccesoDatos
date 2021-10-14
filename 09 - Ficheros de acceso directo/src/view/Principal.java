package view;

import ctrl.GestionFch;
import model.Persona;

public class Principal {

	public static void main(String[] args) {
		
		GestionFch gest = new GestionFch("datos.db");
		
		
		gest.escribirRegistro(1, new Persona("Pepe",(byte)45, 1.68f));
		gest.escribirRegistro(2, new Persona("Juan",(byte)24, 1.88f));
		
		Persona aPersona1 = gest.leerRegistro(1);
		Persona aPersona2 = gest.leerRegistro(2);
		
		System.out.println(aPersona1);
		System.out.println(aPersona2);
		
		gest.cerrarFichero();
		
		

	}

}
