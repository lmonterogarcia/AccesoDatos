package view;

import ctrl.GestionFch;
import model.Empleado;

public class Principal {

	public static void main(String[] args) {

		GestionFch gest = new GestionFch("datos.db");
		byte bOpcion = -1;

		do {
			System.out.println("Menu:\n1.Listar todo\n" + "2.Buscar por posicion\n" + "3.Modificar\n" + "4.Aniadir\n");

			bOpcion = (byte) Libreria.leer("Opción [0 salir]: ", 0, 4, -1, -1, (byte) 1);

			switch (bOpcion) {
			case 1:
				if (gest.getiNumRegistro() < 1) {
					System.out.println("No existen empleados, cree un registro antes de listar");
				} else {
					System.out.println(gest.listar());
				}
				System.out.println(gest.listar());
				break;
			case 2:
				if (gest.getiNumRegistro() < 1) {
					System.out.println("No existen empleados, cree un registro antes de buscar");
				} else {
					Empleado oEmpleado = gest
							.leerRegistro((int) Libreria.leer("Introduzca la posición del registro que quiere ver: ", 1,
									gest.getiNumRegistro(), -1, -1, (byte) 3));
					System.out.println(oEmpleado);
				}

				break;
			case 3:
				modificarRegistro(gest);
				break;
			case 4:
				aniadirRegistro(gest);
				break;

			default:
				System.out.println("Cerrando programa");
				break;
			}
		} while (bOpcion != 0);

		gest.cerrarFichero();

	}

	private static void modificarRegistro(GestionFch gest) {
		// TODO Auto-generated method stub
		
	}

	private static void aniadirRegistro(GestionFch gest) {
		Empleado oEmpleado = new Empleado();
		String sNombre = (String) Libreria.leer("Introduce el nombre ", 1, 10, -1, -1, (byte) 7);
		String sApellidos = (String) Libreria.leer("Introduce los apellidos ", 1, 20, -1, -1, (byte) 7);
		long lTelefono = (long) Libreria.leer("Introduce el telefono ", 1, 999999999, -1, -1, (byte) 4);
		String sEmail = (String) Libreria.leer("Introduce el email ", 1, 25, -1, -1, (byte) 7);
		int iEdad = (int) Libreria.leer("Introduce la edad ", 0, 130, -1, -1, (byte) 3);
		double dSueldo = (double) Libreria.leer("Introduce el sueldo ", -1, -1, 0, 100000, (byte) 6);

		oEmpleado.setsNombre(sNombre);
		oEmpleado.setsApellidos(sApellidos);
		oEmpleado.setlTelefono(lTelefono);
		oEmpleado.setsEmail(sEmail);
		oEmpleado.setiEdad(iEdad);
		oEmpleado.setdSueldo(dSueldo);

		gest.escribirRegistro(oEmpleado);

	}

}
