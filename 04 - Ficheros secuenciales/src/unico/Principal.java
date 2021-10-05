package unico;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {

		File fch = new File("ejemplo.txt");

		String sTexto = "ñqwekjfhikljherqioljfgh  iquerfgipbqwerfgpibqeripugfh puiqerfgigref";
		ArrayList<String>  aTexto = new ArrayList();
		aTexto.add("ñqwekjfhikljherqioljfgh");
		aTexto.add("iquerfgipbqwerfgpibqeripugfh");
		aTexto.add("puiqerfgigref");

		//		escribirFch(fch, sTexto);
		escribirFicheroList(fch, aTexto);
		
		// leer ficheros
		ArrayList<String> aPalabras = leerFichero(fch);
		aPalabras.forEach(s -> System.out.println(s));




	}

	private static void escribirFicheroList(File fch, ArrayList<String> aTexto) {
		boolean booPrimelaLinea = true;
		try {
			FileWriter oFichero = new FileWriter(fch);
			BufferedWriter oFicheroBuff = new BufferedWriter(oFichero);

			//			for (String sTexto : aTexto) {
			//				if (booPrimelaLinea) {
			//					oFicheroBuff.write(sTexto);
			//					booPrimelaLinea = false;
			//				} else {
			//					oFicheroBuff.newLine();
			//					oFicheroBuff.write(sTexto);
			//				}
			//			}

			for (int i = 0; i < aTexto.size(); i++) {
				oFicheroBuff.write(aTexto.get(i));
				if (i<aTexto.size() - 1) {
					oFicheroBuff.newLine();
				}
			}

			oFicheroBuff.flush();
			oFicheroBuff.close();

		} catch (IOException ioe) {
			System.out.println("Error al acceder al fichero");
		}

	}

	private static void escribirFch(File fch, String sTexto) {

		try {
			//Abrir el fichero
			FileWriter oFichero = new FileWriter(fch);

			//Crear el buffered para escribir dato yq ue se envien al fichero
			BufferedWriter oFicheroBuff = new BufferedWriter(oFichero);

			//Volcamos el texto que queremos guardar sobre el buffer
			// y este buffer lo escribre sobre el fichero.
			oFicheroBuff.write(sTexto);

			//Antes de cerrar el buffer hay que vaciarlo, asi no se pierde información.
			oFicheroBuff.flush();

			//Cerramos el buffer
			oFicheroBuff.close();

			//Cerramos el fichero
			oFichero.close();

		} catch (IOException ioe) {
			System.out.println("Error al acceder al fichero");
		}

	}

	private static void escribirFch2(File fch, String sTexto) {

		try {
			//Crear el buffered para escribir dato yq ue se envien al fichero
			BufferedWriter oFichero = new BufferedWriter(new FileWriter(fch));

			//Volcamos el texto que queremos guardar sobre el buffer
			// y este buffer lo escribre sobre el fichero.
			oFichero.write(sTexto);

			//Antes de cerrar el buffer hay que vaciarlo, asi no se pierde información.
			oFichero.flush();

			//Cerramos el buffer
			oFichero.close();
		} catch (IOException ioe) {
			System.out.println("Error al acceder al fichero");
		}

	}

	private static ArrayList<String> leerFichero(File fch) {
		
		ArrayList<String>  aContenido = new ArrayList<String>();
		
		try {
			FileReader fichero = new FileReader(fch);
			BufferedReader bufLectura =  new BufferedReader(fichero);
			
			String sLinea = bufLectura.readLine();
			
			while(sLinea != null) {
				//Procesamos el fichero
				aContenido.add(sLinea);
				//Leemos siguiente linea
				sLinea = bufLectura.readLine();
				
			}
			
			bufLectura.close();
			fichero.close();
		} catch (FileNotFoundException e) {
			System.out.println("El fichero no existe");
		} catch (IOException ioe){
			System.out.println("Se ha producido un error al acceder al fichero");
		}
		
		return aContenido;
	}

}
