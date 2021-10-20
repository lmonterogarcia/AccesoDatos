package unico;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import model.Persona;

public class Principal {

	public static void main(String[] args) {

		File fch = new File("personas.txt");

		ArrayList<Persona> aPersonas = leerPersonas(fch);

//		for (Persona persona : aPersonas) {
//			System.out.println(persona);
//		}
		
		escribirPersonas("personas2.txt", aPersonas);
		
		aPersonas.forEach( p -> System.out.println(p));

	}

	private static void escribirPersonas(String fch, ArrayList<Persona> aPersonas) {

		
		boolean booPrimera = true;
		
		try {
			File fichero = new File(fch);
			BufferedWriter buffWriter = new BufferedWriter(new FileWriter(fichero));
			final String sSeparador = "#";
			
			for (Persona persona : aPersonas) {
				if (booPrimera) {
					booPrimera = !booPrimera;
				} else {
					buffWriter.newLine();
				}
				
				buffWriter.write(persona.getsNombre() + "#" + persona.getsApellidos() + "#" + persona.getbEdades());	
			}
			
			for (int i = 0; i < aPersonas.size(); i++) {
				String sLinea = aPersonas.get(i).getsNombre() + sSeparador + aPersonas.get(i).getsApellidos() + sSeparador + aPersonas.get(i).getbEdades();
			}
			
			buffWriter.flush();
			buffWriter.close();
		} catch (FileNotFoundException e) {
			System.out.println("El fichero no existe");
		} catch (IOException ioe){
			System.out.println("Se ha producido un error al acceder al fichero");
		}

	}

	private static ArrayList<Persona> leerPersonas(File fch) {
		ArrayList<Persona> aPersonas = new ArrayList<Persona>();

		try {
			FileReader fichero = new FileReader(fch);
			BufferedReader bufLectura =  new BufferedReader(fichero);

			String sLinea = bufLectura.readLine();

			while(sLinea != null) {
				//Procesamos el fichero

				StringTokenizer stLinea = new StringTokenizer(sLinea,"#");
				String sNombre = stLinea.nextToken();
				String sApellidos = stLinea.nextToken();
				byte bEdad = Byte.parseByte(stLinea.nextToken());
				aPersonas.add(new Persona(sNombre, sApellidos, bEdad));

				//Leemos siguiente linea
				sLinea = bufLectura.readLine();

			}

			bufLectura.close();
			fichero.close();
		} catch (FileNotFoundException e) {
			System.err.println("El fichero no existe");
		} catch (IOException ioe){
			System.err.println("Se ha producido un error al acceder al fichero");
		} catch (Exception eiu) {
			System.err.println("Ha ocurrido un error no clasificado");
			eiu.printStackTrace();
		}

		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return aPersonas;
	}

}
