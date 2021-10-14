package ctrl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import model.Empleado;

public class GestionFch {

	private RandomAccessFile fch;
	
	public GestionFch(String sNombreArchivo) {
		abirFichero(sNombreArchivo);
	}

	private void abirFichero(String sNombreArchivo) {
		try {
			fch = new RandomAccessFile(sNombreArchivo,"rw");
		} catch (FileNotFoundException e) {
			System.err.println("El fichero " + sNombreArchivo + " no existe.");
		}		
	}

	public void cerrarFichero() {
		try {
			fch.close();
		} catch (IOException e) {
			System.err.println("El fichero no puede cerrarse");
		}		
	}

	public void escribirRegistro(int iNumRegistro, Empleado persona) {
		
		try {
			fch.seek(getPosition(iNumRegistro));
			
			//Nombre
			String sNombre = persona.getsNombre();
			char cCaracter;
			for (int i = 0; i < model.Empleado.getbNumCaracteresNombrePersona(); i++) {
				cCaracter = (i < sNombre.length()) ? sNombre.charAt(i) : ' ';
				fch.writeChar(cCaracter);
			}
			
			//Edad
			fch.writeByte(persona.getbEdad());
			
			//Altura
			fch.writeFloat(persona.getfAltura());
			
			
		} catch (IOException e) {
			System.err.println("El fichero no es accesible");
		}
		
	}

	private long getPosition(int iNumRegistro) {
		
		return (iNumRegistro - 1) * model.IEmpleado.iLongRegistro;
	}

	public Empleado leerRegistro(int iNumRegistro) {
		String sNombre = "";
		byte bEdad = 0;
		float fAltura = 0.0f;
		
		try {
			
			fch.seek(getPosition(iNumRegistro));
			
			//Nombre
			
			for (int i = 0; i < model.IEmpleado.bNumsNombre; i++) {
				sNombre += fch.readChar();
			}
			
			//Edad
			bEdad = fch.readByte();
			
			//Altura
			fAltura = fch.readFloat();
			
		} catch (IOException e) {
			System.err.println("El fichero no es accesible");
		}
		
		return new Empleado(sNombre.trim(),bEdad,fAltura);
	}
}
