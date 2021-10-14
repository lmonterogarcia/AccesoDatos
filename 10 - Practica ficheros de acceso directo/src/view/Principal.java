package view;

import ctrl.GestionFch;
import model.Empleado;

public class Principal {

	public static void main(String[] args) {
		
		GestionFch gest = new GestionFch("datos.db");
		
		
		gest.escribirRegistro(1, new Empleado("Pepe",(byte)45, 1.68f));
		gest.escribirRegistro(2, new Empleado("Juan",(byte)24, 1.88f));
		
		Empleado aPersona1 = gest.leerRegistro(1);
		Empleado aPersona2 = gest.leerRegistro(2);
		
		System.out.println(aPersona1);
		System.out.println(aPersona2);
		
		gest.cerrarFichero();
		
		

	}

}
