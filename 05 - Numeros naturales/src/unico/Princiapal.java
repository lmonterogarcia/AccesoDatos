package unico;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Princiapal {

	public static void main(String[] args) {

		File fch1 = new File("numNaturales.txt");
		String[] aNombres = { "Jesus", "Macarena", "Jose", "Maria" };

		escribirNumNaturales(fch1);
		leerNumNaturales(fch1);

		File fch2 = new File("nombres.txt");
		guardarNombres(aNombres, fch2);
		escribirNombres(fch2);

	}

	private static void escribirNombres(File fch2) {
		String sSeparador = ":";
		try {
			BufferedReader br = new BufferedReader(new FileReader(fch2));
			String sLineaLeida  = br.readLine();
			while (sLineaLeida != null) {
				String[] aPartes = sLineaLeida.split(sSeparador);
				for (String nombre : aPartes) {
					System.out.println(nombre);
				}
				sLineaLeida = br.readLine();
			}
			
			
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println("No se ha encontrado el archivo");
		} catch (IOException e) {
			System.err.println("Error al abrir el archivo");
		} catch (Exception e) {
			System.err.println("Error no tipificado");
			e.printStackTrace();
		}
		
	}

	private static void guardarNombres(String[] aNombres, File fch) {
		int iContador = 1;
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fch));

			for (String sNombre : aNombres) {

				bw.write(sNombre);
				if (iContador < aNombres.length) {
					bw.write(":");
				}
				iContador++;
			}

			bw.flush();
			bw.close();
		} catch (FileNotFoundException e) {
			System.err.println("No se ha encontrado el archivo");
		} catch (IOException e) {
			System.err.println("Error al abrir el archivo");
		} catch (Exception e) {
			System.err.println("Error no tipificado");
			e.printStackTrace();
		}

	}

	private static void leerNumNaturales(File fch) {
		int iSuma = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(fch));

			String sLineaLeida = br.readLine();
			while (sLineaLeida != null) {
				iSuma += Integer.parseInt(sLineaLeida);
				sLineaLeida = br.readLine();

				;
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println("No se ha encontrado el archivo");
		} catch (IOException e) {
			System.err.println("Error al abrir el archivo");
		} catch (Exception e) {
			System.err.println("Error no tipificado");
			e.printStackTrace();
		}

		System.out.println("La suma total de los numeros en el archivo es: " + iSuma);

	}

	private static void escribirNumNaturales(File fch) {

		try {
			FileWriter fr = new FileWriter(fch);
			

			for (int i = 1; i <= 100; i++) {
				if (i > 1) {
					fr.write("\n");
				}
				fr.write(Integer.toString(i));
			}

			fr.close();
		} catch (FileNotFoundException e) {
			System.err.println("No se ha encontrado el archivo");
		} catch (IOException e) {
			System.err.println("Error al abrir el archivo");
		} catch (Exception e) {
			System.err.println("Error no tipificado");
			e.printStackTrace();
		}

	}

}
