package unico;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.StringTokenizer;

import model.Conexion;

public class Principal {

	public static void main(String[] args) {

		File fch = new File("conexion.cfg");

//		Conexion oConexion = leerConexion(fch);
		Conexion oConexion = leerConexion2(fch);
		
		System.out.println(oConexion);
	}

	private static Conexion leerConexion2(File fch) {
		Conexion oConexion = new Conexion();
		final String SSEPARADOR = ":";
		HashMap<String,String> map = new HashMap<String,String>();

		try {
			BufferedReader buffReader = new BufferedReader(new FileReader(fch));
			String sLinea = buffReader.readLine();
			String[] aCampos;
			
			while(sLinea != null) {
				//Procesamos el fichero

				aCampos = sLinea.split(SSEPARADOR);
				map.put((aCampos[0]).toUpperCase().trim(), (aCampos[1]).toUpperCase().trim());
				sLinea = buffReader.readLine();
			}

			buffReader.close();  
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		oConexion.setsHost(map.get("HOST"));
		oConexion.setiPort(Integer.parseInt(map.get("PORT")));
		oConexion.setsDbName(map.get("DBNAME"));
		oConexion.setsUsername(map.get("USERNAME"));
		oConexion.setsUserpass(map.get("USERPASS"));

		return oConexion;
	}

	private static Conexion leerConexion(File fch) {
		Conexion oConexion = new Conexion();
		final String SSEPARADOR = ":";

		try {
			BufferedReader buffReader = new BufferedReader(new FileReader(fch));

			String sLinea = buffReader.readLine();
			
			//	Solucion de Cifredo
//			oConexion.setsHost(buffReader.readLine().split(SSEPARADOR)[1]);
//			oConexion.setiPort(Integer.parseInt(buffReader.readLine().split(SSEPARADOR)[1]));
//			oConexion.setsDbName(buffReader.readLine().split(SSEPARADOR)[1]);
//			oConexion.setsUsername(buffReader.readLine().split(SSEPARADOR)[1]);
//			oConexion.setsUserpass(buffReader.readLine().split(SSEPARADOR)[1]);

			while(sLinea != null) {
				//Procesamos el fichero

				String[] aCampos = sLinea.split(SSEPARADOR);
				
//				String sParam = sLinea.substring(0, sLinea.indexOf(":"));
//				String sValue = sLinea.substring(sLinea.indexOf(":") + 1, sLinea.length());

				switch ((aCampos[0]).toUpperCase()) {
				case "HOST":
					oConexion.setsHost(aCampos[1]);
					break;
				case "PORT":
					oConexion.setiPort(Integer.parseInt(aCampos[1]));
					break;
				case "DBNAME":
					oConexion.setsDbName(aCampos[1]);
					break;
				case "USERNAME":
					oConexion.setsUsername(aCampos[1]);
					break;
				case "USERPASS":
					oConexion.setsUserpass(aCampos[1]);
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
