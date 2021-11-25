package logic;

import java.sql.SQLException;
import java.sql.Statement;

import model.Casa;

public class LogCasa {

	public static void insertar(Casa oCasa)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {

		String sPoblacion = oCasa.getsPoblacion();
		double dSuperficie = oCasa.getdSuperficie();
		int iAseos = oCasa.getiAseos();

		dbms.DBoracle.openConn();
		Statement miOrden = dbms.DBoracle.getConn().createStatement();
		miOrden.execute("INSERT INTO CASA2 (POBLACION, SUPERFICIE, ASEOS) VALUES ('" + sPoblacion + "', " + dSuperficie
				+ ", " + iAseos + ")");
		miOrden.execute("COMMIT");
		dbms.DBoracle.closeConn();

	}

}
