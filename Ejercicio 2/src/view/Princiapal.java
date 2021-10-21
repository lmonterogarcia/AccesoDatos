package view;

import java.io.*;
import java.util.ArrayList;

public class Princiapal {

	public static void main(String[] args) {
		String sRuta = "test", sCadena = "chrome";

		imprimirFicheros(encontrarFichero(sRuta, sCadena));

	}

	private static void imprimirFicheros(ArrayList<String> nombresFichero) {
		for (String nombreFichero : nombresFichero) {
			System.out.println(nombreFichero);
		}
	}

	private static ArrayList<String> encontrarFichero(String sRuta, String sCadenaBuscada) {
		ArrayList<String> aArchivos = new ArrayList<String>();

		File fch = new File(sRuta);
		File[] dirContenido;

		if (fch.listFiles() != null) {

			dirContenido = fch.listFiles();

			for (File file : dirContenido) {
				if (!file.isDirectory()) {

					try {
						BufferedReader br = new BufferedReader(new FileReader(file));
						String sLineaLeida;

						sLineaLeida = br.readLine();

						while (sLineaLeida != null) {
							if (sLineaLeida.contains(sCadenaBuscada)) {
								aArchivos.add(file.getAbsolutePath());
							}
							sLineaLeida = br.readLine();
						}

						br.close();
					} catch (FileNotFoundException e) {
						System.err.println("El fichero no existe");
						e.printStackTrace();
					} catch (IOException e) {
						System.err.println("Se ha producido un error al acceder al fichero");
						e.printStackTrace();
					} catch (Exception e) {
						System.err.println("Ha ocurrido un error no clasificado");
						e.printStackTrace();
					}

				} else {
					aArchivos.addAll(encontrarFichero(file.getAbsolutePath(), sCadenaBuscada));
				}
			}
		}

		return aArchivos;
	}

}
