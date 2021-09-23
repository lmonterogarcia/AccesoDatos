package unico;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class Principal {

	public static void main(String[] args) {

		//Mi app apunta a un Ruta..

//		String sRuta= "Ficheros\\ciudades.txt";
		String sRuta= "C:\\Users\\Usuario\\Documents\\workspaces";
		File fch = new File(sRuta);

		if (fch.exists()) {

			if (fch.isDirectory()) {
//				infoDir(fch);
//				diffTipoContenido(fch);
//				contadorContenido(fch);
				contadorContenidoInterior(fch);
			} else {
				infoFile(fch);
			}

		} else {
			System.out.println("No Existe");
		}


	}

	private static void infoDir(File fch) {
		System.out.println("Es un DIRECTORIO");
		
		long dirEspacioLibreByte = fch.getFreeSpace();
		long dirEspacioLibreMB = fch.getFreeSpace() / 1024 / 1024;
		long dirEspacioLibreGB = dirEspacioLibreMB / 1024;
		
		File[] dirContenido = fch.listFiles();
		
		for (File f : dirContenido) {
			String sInfoPrevia = f.isDirectory() ? "DIR" : "FCH";
				System.out.println(sInfoPrevia + f.getName());
		}
		
		System.out.print("\n");
		System.out.println("Espacio libre = " + dirEspacioLibreByte + " Bytes");
		System.out.println("              = " + dirEspacioLibreMB + " MB");
		System.out.println("              = " + dirEspacioLibreGB + " GB");
		
	}
	
	private static void diffTipoContenido(File fch) {
		File[] dirContenido = fch.listFiles();
		ArrayList<String> nombres = new ArrayList<String>();
		
		String sInfoPrevio;
		for (File f : dirContenido) {
			sInfoPrevio = f.isDirectory() ? "DIR" : "FCH";
			nombres.add(sInfoPrevio + f.getName());
		}
		Collections.sort(nombres);
		
		//Arrow Funtion
		nombres.forEach((nombre) -> System.out.println(nombre));
		//Igual a lo de abajo
//		for (String nombre : nombres) {
//			System.out.println(nombre);
//		}
		
	}
	
	private static void contadorContenido(File fch) {
		File[] dirContenido = fch.listFiles();
		int iContDir = 0, iContFch = 0;
		
		for (File f : dirContenido) {
			if (f.isDirectory()) {
				iContDir++;
			} else {
				iContFch++;
			}
		}
		
		System.out.println("Dentro de este directorio hay:\n" + iContDir + " Carpetas\n" + iContFch + " Ficheros");
		
	}
	

	private static void infoFile(File fch) {
		String sFchNombreArchivo = fch.getName();
		String sFchCarpetaPadre = fch.getParent();
		String sfchRutaAbsoluta = fch.getAbsolutePath();
		long lFchByte = fch.length();

		boolean fchPuedeLeer = fch.canRead();
		boolean fchPuedeEscribir = fch.canWrite();
		boolean fchPuedeEjecutar = fch.canExecute();

		System.out.println("Nombre Archivo: " + sFchNombreArchivo);
		System.out.println("Carpeta Padre: " + sFchCarpetaPadre);
		System.out.println("Ruta Absulota: " + sfchRutaAbsoluta);
		System.out.println("Tamanio (Byte): " + lFchByte);
		System.out.println("Se puede leer: " + SiNo(fchPuedeLeer));
		System.out.println("Se puede escribir: " + SiNo(fchPuedeLeer));
		System.out.println("Se puede ejecutar: " + SiNo(fchPuedeLeer));
	}

	private static String SiNo(boolean exp) {
		return  exp ? "Sí" : "No";
	}
	
	private static void contadorContenidoInterior(File fch) {
		File[] dirContenido;
		String sResultado = "";
		
		if (fch.listFiles() != null) {
			dirContenido = fch.listFiles();
			for (File f : dirContenido) {
				if (f.isDirectory()) {
					System.out.println(f.getName());
					sResultado += f.getName() + "{ ";
					contadorContenidoInterior(f);
					sResultado += " }";
				} 
			}
		}
	}
}
