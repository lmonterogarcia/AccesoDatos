package logic;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import model.Dept;
import oracle.jdbc.internal.OracleTypes;

public class LogDept {

	public static ArrayList<Dept> getListado() throws Exception {
		ArrayList<Dept> aListadoDept = new ArrayList<Dept>();

		dbms.DBoracle.openConn();

		Statement miOrden = dbms.DBoracle.getConn().createStatement();
		miOrden.execute("SELECT DEPTNO, DNAME, LOC FROM DEPT ORDER BY 1");

		ResultSet resultado = miOrden.getResultSet();

		ResultSetMetaData info = resultado.getMetaData();
		int iNumCampos = info.getColumnCount();

//			for (int i = 1; i <= iNumCampos; i++) {
//				System.out.print(info.getColumnName(i) + "\t\t");
//			}

		while (resultado.next()) {
//				System.out.println();
//				for (int i = 1; i <= iNumCampos; i++) {
//					System.out.print(resultado.getString(i) + "\t\t");
//				}
			Dept oDept = new Dept(resultado.getString("DEPTNO"), resultado.getString("DNAME"),
					resultado.getString("LOC"));
			aListadoDept.add(oDept);

//				System.out.println("Nombre: " + resultado.getString("ENAME"));
//				System.out.println("Salario: " + resultado.getInt("SAL"));
		}

		dbms.DBoracle.closeConn();

		return aListadoDept;
	}

	public static void cambiarLocalidad(String sLocalidad, Integer iNumDept) throws Exception {

		dbms.DBoracle.openConn();

		String sql = "{call CAMBIAR_DEPT_LOC(?,?)}";

		CallableStatement orden = dbms.DBoracle.getConn().prepareCall(sql);

		orden.setString(1, sLocalidad);
		orden.setInt(2, iNumDept);

		orden.execute();

		dbms.DBoracle.closeConn();

	}

	public static int getTotalEmpleados(int iDepartamento) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

		int iTotal = 0;

		dbms.DBoracle.openConn();

		String sql = "{ ? = call TOTAL_EMPS(?)}";

		CallableStatement orden = dbms.DBoracle.getConn().prepareCall(sql);
		
		orden.registerOutParameter(1, Types.NUMERIC);
		orden.setInt(2, iDepartamento);

		orden.execute();

		iTotal = orden.getInt(1);
		
		dbms.DBoracle.closeConn();

		return iTotal;
	}

	public static ArrayList<Dept> getDepts() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		ArrayList<Dept> listadoDepartamentos = new ArrayList<Dept>();

		dbms.DBoracle.openConn();

		String sql = "{ ? = call GET_DEPT()}";

		CallableStatement orden = dbms.DBoracle.getConn().prepareCall(sql);
		
		orden.registerOutParameter(1, OracleTypes.CURSOR);

		orden.execute();

		ResultSet resultado = (ResultSet) orden.getObject(1);
		while (resultado.next()) {
			listadoDepartamentos.add(new Dept(Integer.toString(resultado.getInt("DEPTNO")), resultado.getString("DNAME"), resultado.getString("LOC")));
		}
		
		dbms.DBoracle.closeConn();

		return listadoDepartamentos;
	}
}
