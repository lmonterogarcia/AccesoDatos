package logic;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import oracle.jdbc.internal.OracleTypes;

public class LogTablas {

	public static ArrayList<String> getListadoTablas() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException  {
		ArrayList<String> aListadoTablas = new ArrayList<String>();

		dbms.DBoracle.openConn();

		Statement miOrden = dbms.DBoracle.getConn().createStatement();
		miOrden.execute("SELECT TABLE_NAME FROM USER_TABLES");

		ResultSet resultado = miOrden.getResultSet();

		while (resultado.next()) {

			aListadoTablas.add(resultado.getString(1));

		}

		dbms.DBoracle.closeConn();

		return aListadoTablas;
	}

	public static int getNumRegistros(String sTabla) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException  {
		int iNumRegistros = 0;

		dbms.DBoracle.openConn();

		Statement miOrden = dbms.DBoracle.getConn().createStatement();
		miOrden.execute("SELECT COUNT(*) FROM " + sTabla);

		ResultSet resultado = miOrden.getResultSet();

		resultado.next();
		iNumRegistros = resultado.getInt(1);

		dbms.DBoracle.closeConn();

		return iNumRegistros;
	}

	public static ArrayList<String> getNombreCampos(String sTabla) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		ArrayList<String> aNombreColumnas = new ArrayList<String>();

		dbms.DBoracle.openConn();

		Statement miOrden = dbms.DBoracle.getConn().createStatement();
		miOrden.execute("SELECT COLUMN_NAME FROM ALL_TAB_COLUMNS WHERE TABLE_NAME = '" + sTabla + "'");

		ResultSet resultado = miOrden.getResultSet();

		while (resultado.next()) {

			aNombreColumnas.add(resultado.getString(1));

		}

		dbms.DBoracle.closeConn();

		return aNombreColumnas;
	}

	public static ArrayList<String> getInfoRegistroTabla(String sTabla, int iPosicion) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		ArrayList<String> aInfoRegistroTablas = new ArrayList<String>();

		dbms.DBoracle.openConn();

		Statement miOrden = dbms.DBoracle.getConn().createStatement();
		miOrden.execute("SELECT * FROM " + sTabla);

		ResultSet resultado = miOrden.getResultSet();

		ResultSetMetaData info = resultado.getMetaData();
		int iNumCampos = info.getColumnCount();

		for (int i = 0; i < iPosicion; i++) {
			resultado.next();
		}

		for (int i = 1; i <= iNumCampos; i++) {
			aInfoRegistroTablas.add(resultado.getString(i));
		}

		dbms.DBoracle.closeConn();

		return aInfoRegistroTablas;
	}

}
