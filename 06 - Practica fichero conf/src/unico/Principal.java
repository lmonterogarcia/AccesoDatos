package unico;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;

import model.Conexion;

public class Principal {

	public static void main(String[] args) {

		File fch = new File("conexion.cfg");

		Conexion oConexion = leerConexion(fch);
		System.out.println(oConexion);
	}

	private static Conexion leerConexion(File fch) {
		Conexion oConexion = new Conexion();

		try {
			BufferedReader buffReader = new BufferedReader(new FileReader(fch));

			String sLinea = buffReader.readLine();

			while(sLinea != null) {
				//Procesamos el fichero

				String sParam = sLinea.substring(0, sLinea.indexOf(":"));
				String sValue = sLinea.substring(sLinea.indexOf(":") + 1, sLinea.length());

				switch (sParam) {
				case "HOST":
					oConexion.setsHost(sValue);
					break;
				case "PORT":
					oConexion.setiPort(Integer.parseInt(sValue));
					break;
				case "DBNAME":
					oConexion.setsDbName(sValue);
					break;
				case "USERNAME":
					oConexion.setsUsername(sValue);
					break;
				case "USERPASS":
					oConexion.setsUserpass(sValue);
					break;

				default:
					break;
				}
				//Leemos siguiente linea
				sLinea = buffReader.readLine();

			}

			buffReader.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return oConexion;

	}

}
