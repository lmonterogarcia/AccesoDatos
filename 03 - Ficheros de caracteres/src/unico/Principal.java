package unico;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Principal {

	public static void main(String[] args) {

//		File nombreFichero = new File("notas.txt");
//		escribirFch(nombreFichero);
//		leerFch(nombreFichero);
		
		File nombreFchSource = new File ("notas.txt");
		File nombreFchTarget = new File ("notas_V2.txt");
		copiarFichero(nombreFchSource, nombreFchTarget);

	}
	
	private static void copiarFichero(File nombreFchSource, File nombreFchTarget) {
		try {
			FileReader fchSource = new FileReader(nombreFchSource);
			FileWriter fchTarget = new FileWriter(nombreFchTarget);
			int iCaracter;
			
			iCaracter = fchSource.read();
			while (iCaracter != -1) {
				fchTarget.write((char)iCaracter);
				iCaracter = fchSource.read();
			}
			
			fchSource.close();
			fchTarget.close();
			
		} catch (FileNotFoundException e) {
			System.err.println("Fichero No ENCONTRADO");
		} catch (IOException e) {
			System.err.println("Error Accediendo al Fichero");
		}
		
	}

	private static void leerFch(File nombreFichero) {
		String sCaracter;
		try {
			FileReader fch = new FileReader(nombreFichero);
			int iCaracter;
			
			iCaracter = fch.read();
			while (iCaracter != -1) {
				System.out.print((char)iCaracter);
				iCaracter = fch.read();
			}
			
			fch.close();
		} catch (FileNotFoundException e) {
			System.err.println("Fichero No ENCONTRADO");
		} catch (IOException e) {
			System.err.println("Error Accediendo al Fichero");
		}
		
	}

	private static void escribirFch(File nombreFichero) {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		String sTexto ="";
		
		
		try {
			FileWriter fch = new FileWriter(nombreFichero);
			
			do {
				System.out.println("Escriba una frase (Para terminar dejelo vacio y pulse ENTER): ");
				sTexto = teclado.readLine();
				if (!sTexto.isEmpty()) {
					fch.write(sTexto + "\n");
				}
			} while (!sTexto.isEmpty());
				fch.close();
			
		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado");
		} catch (IOException e) {
			System.err.println("Error accediendo al fichero");
		}
	}

}
