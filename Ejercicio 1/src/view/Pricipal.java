package view;

import java.io.File;
import java.util.ArrayList;

public class Pricipal {

	public static void main(String[] args) {
		
		
		String sRuta = "test", sCadena = "chrome";
		
		imprimirFicheros(nombresFichero(sRuta,sCadena));

		}

		private static void imprimirFicheros(ArrayList<String> nombresFichero) {
			for (String nombreFichero : nombresFichero) {
				System.out.println(nombreFichero);
			}
		}
	
		private static ArrayList<String> nombresFichero (String sRuta, String sCadena) {
			ArrayList<String> aNombreFicheros = new ArrayList<String>();
			File fch = new File(sRuta);
			File[] dirContenido;
			
			if (fch.listFiles() != null) {
				
				dirContenido = fch.listFiles();
				
				for (File file : dirContenido) {
					if (!file.isDirectory()) {
						if (file.getName().contains(sCadena)) {
							aNombreFicheros.add(file.getAbsolutePath());
						}
					} else {
						aNombreFicheros.addAll(nombresFichero(file.getAbsolutePath(), sCadena));
					}
				}
			}
			return aNombreFicheros;
		}
}
