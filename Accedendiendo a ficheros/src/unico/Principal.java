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
			
			System.out.println("Nombre Archivo: " + sFchNombreArchivo);
			System.out.println("Carpeta Padre: " + sFchCarpetaPadre);
			System.out.println("Ruta Absulota: " + sfchRutaAbsoluta);
			System.out.println("Tamanio (Byte): " + lFchByte);
			
			
		} else {
			System.out.println("No Existe");
		}
		

	}

}
