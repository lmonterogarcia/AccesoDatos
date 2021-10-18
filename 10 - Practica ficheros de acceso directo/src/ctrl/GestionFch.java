package ctrl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import model.Empleado;

public class GestionFch {

	private int iNumRegistos;
	private RandomAccessFile fch;

	public GestionFch(String sNombreArchivo) {
		abirFichero(sNombreArchivo);
		calcularNumRegistro();
	}
	
	private void calcularNumRegistro() {
		try {
			iNumRegistos = (int) (fch.length() / model.IEmpleado.iLongRegistro);
		} catch (IOException e) {
			System.err.println("Se ha encontrado un error al acceder al fichero");
		}
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

	private long getPosition(int iNumRegistro) {

		return (iNumRegistro - 1) * model.IEmpleado.iLongRegistro;
	}

	public void escribirRegistro(Empleado persona) {

		try {
			fch.seek(getPosition(iNumRegistos + 1));
			char cCaracter;
			//Nombre
			String sNombre = persona.getsNombre();
			for (int i = 0; i < model.IEmpleado.bNumsNombre; i++) {
				cCaracter = (i < sNombre.length()) ? sNombre.charAt(i) : ' ';
				fch.writeChar(cCaracter);
			}

			//Apellidos
			String sApellidos = persona.getsApellidos();
			for (int i = 0; i < model.IEmpleado.bNumsNombre; i++) {
				cCaracter = (i < sApellidos.length()) ? sApellidos.charAt(i) : ' ';
				fch.writeChar(cCaracter);
			}

			//Telefono
			fch.writeLong(persona.getlTelefono());

			//Email
			String sEmail = persona.getsEmail();
			for (int i = 0; i < model.IEmpleado.bNumsNombre; i++) {
				cCaracter = (i < sEmail.length()) ? sEmail.charAt(i) : ' ';
				fch.writeChar(cCaracter);
			}

			//Edad
			fch.writeByte(persona.getiEdad());

			//Sueldo
			fch.writeDouble(persona.getdSueldo());
			
			iNumRegistos++;


		} catch (IOException e) {
			System.err.println("El fichero no es accesible");
		}

	}

	public Empleado leerRegistro(int iNumRegistro) {
		String sNombre = "", sApellidos = "", sEmail = "";
		int iEdad = 0;
		long lTelefono = 0;
		double dSueldo = 0;

		try {

			fch.seek(getPosition(iNumRegistro));

			//Nombre
			for (int i = 0; i < model.IEmpleado.bNumsNombre; i++) {
				sNombre += fch.readChar();
			}
			
			//Apellidos
			for (int i = 0; i < model.IEmpleado.bNumsApellidos; i++) {
				sApellidos += fch.readChar();
			}
			
			//Telefono
			lTelefono = fch.readLong();
			
			//Email
			for (int i = 0; i < model.IEmpleado.bNumsEmail; i++) {
				sEmail += fch.readChar();
			}
			
			//Edad
			iEdad = fch.readByte();

			//Sueldo
			dSueldo = fch.readDouble();

		} catch (IOException e) {
			System.err.println("El fichero no es accesible");
		}

		return new Empleado(sNombre.trim(),sApellidos.trim(),lTelefono,sEmail.trim(),iEdad,dSueldo);
	}
	
	public String listar() {
		Empleado aEmpleado = new Empleado();
		String sResultado = "";
		boolean booPrimeraLinea = true;
		
		for (int i = 0; i < iNumRegistos; i++) {
			aEmpleado = leerRegistro(i);
			if (booPrimeraLinea) {
				sResultado = aEmpleado.toString();
			} else {
				sResultado = "\n" + aEmpleado.toString();
			}
		}
		
		return sResultado;
	}
}
