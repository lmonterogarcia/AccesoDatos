package unico;

import java.io.File;

public class Principal {

	public static void main(String[] args) {
		
		//Mi app apunta a un fichero..
		
		String sFichero= "Ficheros\\ciudades.txt";
		File fch = new File(sFichero);
		
		if (fch.exists()) {
			
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
			
		} else {
			System.out.println("No Existe");
		}
		

	}

	private static String SiNo(boolean exp) {
		return  exp ? "Sí" : "No";
	}
}
