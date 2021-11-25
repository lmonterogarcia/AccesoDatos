package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Casa;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Casa> listado = leerOBJ("casas.obj");
		guardarBD(listado);
		System.out.println("Se ha terminado el programa");

	}

	@SuppressWarnings("unchecked")
	private static ArrayList<Casa> leerOBJ(String fileName) {
		ArrayList<Casa> listadoCasas = new ArrayList<>();

		try {
			ObjectInputStream buff = new ObjectInputStream(new FileInputStream(fileName));

			listadoCasas = (ArrayList<Casa>)buff.readObject();
			
			buff.close();
			
		} catch (FileNotFoundException e) {
			System.err.println("ERROR: " + fileName + " no existe.");
		} catch (IOException e) {
			System.err.println("ERROR: No se puede leer del fichero.");
		} catch (ClassNotFoundException e) {
			System.err.println("ERROR: El fichero no contiene un coche");
		}

		return listadoCasas;
	}
	
	private static void guardarBD(ArrayList<Casa> listado) {
		
		listado.forEach(casa -> {
			try {
				
				logic.LogCasa.insertar(casa);
				
			} catch (InstantiationException e) {
				System.err.println("Error de Instantation DB: " + e.getMessage());
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				System.err.println("Error de Acceso Ilegal DB: " + e.getMessage());
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.err.println("Error de Clases no Encontrada DB: " + e.getMessage());
				e.printStackTrace();
			} catch (SQLException e) {
				System.err.println("Error de SQL DB: " + e.getMessage());
				e.printStackTrace();
			}
		});
		
	}

}
