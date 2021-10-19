package view;

import java.util.ArrayList;

import model.Coche;

public class Principal {

	public static void main(String[] args) {
		String fileName = "archivos/coches.dat";
		
		escritura(fileName);
		lectura(fileName);

	}

	private static void escritura(String fileName) {
		
//		Coche c1 = new Coche("Citroen","C5",1500);
//		ctrl.GestionFch.escribirObjeto(fileName, c1);
		ArrayList<Coche> listado = new ArrayList<Coche>();
		Coche c2 = new Coche("Renault","Clio",1100);
		Coche c3 = new Coche("Mercedes","A",1800);
		Coche c4 = new Coche("BMW","3",2000);
		Coche c5 = new Coche("Audi","A4",2100);
		listado.add(c2);
		listado.add(c3);
		listado.add(c4);
		listado.add(c5);
		
		ctrl.GestionFch.escribirObjeto(fileName, listado);
		
		System.out.println("Se ha terminado la escritura correctamente.\n");
		
	}

	private static void lectura(String fileName) {
//		Coche c = ctrl.GestionFch.leerObjeto(fileName);
//		System.out.println(c);
		
		ArrayList<Coche> listado = ctrl.GestionFch.leerArrayObjeto(fileName);
		
		for (Coche coche : listado) {
			System.out.println(coche);
		}
		System.out.println("\nSe ha termiando la lectura correctamente");
		
	}

}
