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
		File nombreFchEncriptado = new File("notasDesencriptado.txt");
		//		copiarFichero(nombreFchSource, nombreFchTarget);
		//		System.out.println(copiarFicheroConContadorChar(nombreFchSource, nombreFchTarget));
		escribirFchEncriptado(nombreFchSource,nombreFchEncriptado, 200);
		escribirFchDesencriptado(nombreFchEncriptado,nombreFchTarget,200);

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

	private static String copiarFicheroConContadorChar(File nombreFchSource, File nombreFchTarget) {
		int iCaracter, iConsonantes = 0, iVocales = 0, iCaracterTotal = 0;
		String sValidar = "aeiouáéíóúàèìòùäëïöü";
		try {

			FileReader fchSource = new FileReader(nombreFchSource);
			FileWriter fchTarget = new FileWriter(nombreFchTarget);

			iCaracter = fchSource.read();

			while (iCaracter != -1) {
				iCaracterTotal++;
				char cCaracter = String.valueOf((char)iCaracter).toLowerCase().charAt(0);
				if (Character.isLetter(cCaracter)
						&& sValidar.indexOf(cCaracter) > 0
						//								(
						//								cCaracter == 'a'
						//								|| cCaracter == 'e'
						//								|| cCaracter == 'i'
						//								|| cCaracter == 'o'
						//								|| cCaracter == 'u'
						//								)
						) {
					iVocales++;
				} else if (Character.isLetter(cCaracter)) {
					iConsonantes++;
				}
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

		return "El archivo se ha copiado correctamente.\n" + iCaracterTotal + " caracteres totales, de los cuales hay " 
		+ iVocales + " vocales, " + iConsonantes + " consonantes y " + (iCaracterTotal - iVocales - iConsonantes) 
		+ " simbolos o especiales";
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
		boolean booPrimeraLinea = true;


		try {
			FileWriter fch = new FileWriter(nombreFichero);

			do {
				System.out.println("Escriba una frase (Para terminar dejelo vacio y pulse ENTER): ");
				sTexto = teclado.readLine();
				if (!sTexto.isEmpty() && !booPrimeraLinea) {
					fch.write("\n" + sTexto);
				} else if (sTexto.isEmpty()){
					fch.write(sTexto);
					booPrimeraLinea = false;
				}
			} while (!sTexto.isEmpty());
			fch.close();

		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado");
		} catch (IOException e) {
			System.err.println("Error accediendo al fichero");
		}
	}

	private static void escribirFchEncriptado(File nombreFchSource, File nombreFchEncriptado, int iClave) {

		int iCaracter;

		try {

			FileReader fchSource = new FileReader(nombreFchSource);
			FileWriter fchTarget = new FileWriter(nombreFchEncriptado);

			iCaracter = fchSource.read();

			while (iCaracter != -1) {
				if ((iCaracter + iClave) > 255) {
					fchTarget.write(((char)iCaracter + iClave) - 255);
				} else {
					fchTarget.write((char)iCaracter + iClave);
				}

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
	private static void escribirFchDesencriptado(File nombreFchSource, File nombreFchEncriptado, int iClave) {

		int iCaracter;

		try {

			FileReader fchSource = new FileReader(nombreFchSource);
			FileWriter fchTarget = new FileWriter(nombreFchEncriptado);

			iCaracter = fchSource.read();

			while (iCaracter != -1) {
				if ((iCaracter - iClave) < 1) {
					fchTarget.write(((char)iCaracter - iClave) + 255);
				} else {
					fchTarget.write((char)iCaracter - iClave);
				}
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

}
