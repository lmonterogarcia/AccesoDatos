package dbms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

		ConectionInfo connInfo = new ConectionInfo(ctrl.CtrlConectionInfo.leerConectionInfo("oracleconnection.cfg"));
		
		String dbHOST = "10.192.120.60";
		String dbPORT = "1521";
		String dbSID = "ORCL";
		String dbUSER = "LUIS";
		String dbPASSWORD = "informedac";

		String dbURL = "jdbc:oracle:thin:@" + dbHOST + ":" + dbPORT + ":" + dbSID;

		// Cargar el river en memoria
		Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();

		// Establecemos la conexion
		conn = DriverManager.getConnection(dbURL, dbUSER, dbPASSWORD);
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
