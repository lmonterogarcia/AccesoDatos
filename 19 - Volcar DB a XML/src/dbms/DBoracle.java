package dbms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import model.ConectionInfo;

public class DBoracle {

	private static Connection conn;

	public static Connection getConn() {
		return conn;
	}

	public static void closeConn() throws SQLException {
		conn.close();
	}

	public static void openConn()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

		ConectionInfo connInfo = leerConectionInfo();

		String dbHOST = connInfo.getDbHOST();
		String dbPORT = connInfo.getDbPORT();
		String dbSID = connInfo.getDbSID();
		String dbUSER = connInfo.getDbUSER();
		String dbPASSWORD = connInfo.getDbPASSWORD();

		String dbURL = "jdbc:oracle:thin:@" + dbHOST + ":" + dbPORT + ":" + dbSID;

		// Cargar el driver en memoria
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// Establecemos la conexion
		conn = DriverManager.getConnection(dbURL, dbUSER, dbPASSWORD);
	}

	private static ConectionInfo leerConectionInfo() {
		ConectionInfo oConection;
		final String SSEPARADOR = ":";
		HashMap<String, String> map = new HashMap<String, String>();

		try {
			BufferedReader buffReader = new BufferedReader(new FileReader(new File("oracleconnection.cfg")));
			String sLinea = buffReader.readLine();
			String[] aCampos;

			while (sLinea != null) {
				// Procesamos el fichero

				aCampos = sLinea.split(SSEPARADOR);
				map.put((aCampos[0]).toUpperCase().trim(), (aCampos[1]).trim());
				sLinea = buffReader.readLine();
			}

			buffReader.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

		oConection = new ConectionInfo(map.get("HOST"), map.get("PORT"), map.get("SID"), map.get("USER"),
				map.get("PASSWORD"));
		return oConection;
	}

	public static boolean testDbOracle() {
		boolean booExito;

		try {
			openConn();
			closeConn();
			booExito = true;
		} catch (Exception e) {
			booExito = false;
		}

		return booExito;
	}
}
