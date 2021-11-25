package logic;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Casa;

public class LogCasa {

	public static void insertarListado(ArrayList<Casa> listadoCasas)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {

		dbms.DBoracle.openConn();
		
		for (Casa oCasa : listadoCasas) {
			String sPoblacion = oCasa.getsPoblacion();
			double dSuperficie = oCasa.getdSuperficie();
			int iAseos = oCasa.getiAseos();
			
			Statement miOrden = dbms.DBoracle.getConn().createStatement();
			miOrden.execute("INSERT INTO CASA2 (POBLACION, SUPERFICIE, ASEOS) VALUES ('" + sPoblacion + "', " + dSuperficie
					+ ", " + iAseos + ")");
			miOrden.execute("COMMIT");
		}
		
		dbms.DBoracle.closeConn();

	}

}
