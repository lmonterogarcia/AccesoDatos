package ctrl;

import java.io.*;
import java.util.ArrayList;

import model.Coche;

public class GestionFch {

	public static void escribirObjeto(String fileName, Coche c) {

		try {
//			FileOutputStream fch = new FileOutputStream(fileName);
//			ObjectOutputStream buff = new ObjectOutputStream(fch);
			ObjectOutputStream buff = new ObjectOutputStream(new FileOutputStream(fileName));

			buff.writeObject(c);

			buff.close();
//			fch.close();
		} catch (FileNotFoundException e) {
			System.err.println("ERROR: " + fileName + " no existe.");
		} catch (IOException e) {
			System.err.println("ERROR: No se puede escribir en el fichero.");
		}
	}

	public static void escribirObjeto(String fileName, ArrayList<Coche> listado) {

		try {
//			FileOutputStream fch = new FileOutputStream(fileName);
//			ObjectOutputStream buff = new ObjectOutputStream(fch);
			ObjectOutputStream buff = new ObjectOutputStream(new FileOutputStream(fileName));

//			for (Coche coche : listado) {
//				buff.writeObject(coche);
//			}
			
			buff.writeObject(listado);

			buff.close();
//			fch.close();
		} catch (FileNotFoundException e) {
			System.err.println("ERROR: " + fileName + " no existe.");
		} catch (IOException e) {
			System.err.println("ERROR: No se puede escribir en el fichero.");
		}
	}

	public static Coche leerObjeto(String fileName) {
		Coche c = null;

		try {
			ObjectInputStream buff = new ObjectInputStream(new FileInputStream(fileName));

			c = (Coche) buff.readObject();

		} catch (FileNotFoundException e) {
			System.err.println("ERROR: " + fileName + " no existe.");
		} catch (IOException e) {
			System.err.println("ERROR: No se puede leer del fichero.");
		} catch (ClassNotFoundException e) {
			System.err.println("ERROR: El fichero no contiene un coche");
		}

		return c;
	}

	public static ArrayList<Coche> leerArrayObjeto(String fileName) {
		ArrayList<Coche> listado = new ArrayList<>();

		try {
			ObjectInputStream buff = new ObjectInputStream(new FileInputStream(fileName));

//			Object obj = buff.readObject();
//
//			while (obj != null) {
//				if (obj instanceof Coche) {
//					listado.add((Coche) obj);
//				}
//				obj = buff.readObject();
//			}

			listado = (ArrayList<Coche>)buff.readObject();
			
		} catch (FileNotFoundException e) {
			System.err.println("ERROR: " + fileName + " no existe.");
		} catch (IOException e) {
			System.err.println("ERROR: No se puede leer del fichero.");
		} catch (ClassNotFoundException e) {
			System.err.println("ERROR: El fichero no contiene un coche");
		}

		return listado;
	}

}
