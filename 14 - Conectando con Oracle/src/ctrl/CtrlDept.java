package ctrl;

import java.sql.*;
import java.util.ArrayList;

import model.Dept;

public class CtrlDept {

	public static void ejecutaSQL() {
		
		ArrayList<Dept> aListadoDept;
		try {
			
			aListadoDept = logic.LogDept.getListado();
			for (Dept dept : aListadoDept) {
				System.out.println(dept);
			}
			
		} catch (Exception e) {
			System.err.println("Ha ocurrido un error: " + e.getMessage());
			e.printStackTrace();
		}

		
	}

	public static void nuevaLoc(String sLocalidad, Integer iNumDept) {
		try {
			logic.LogDept.cambiarLocalidad(sLocalidad, iNumDept);
			System.out.println("Se ha cambiado la localidad correctamente.");
		} catch (Exception e) {
			System.out.println("No se ha podido cambiar la localidad correctamente.");
		}
	}

	public static void totalEmpleados(int iDepartamento) {
		try {
			int iTotal = logic.LogDept.getTotalEmpleados(iDepartamento);
			System.out.println("El departamento " + iDepartamento + " tiene " + iTotal + " empleados.");
		} catch (Exception e) {
			System.err.println("No se ha podido obtener el total de empleados del departmento");
		}
		
	}

	public static void getEmpsPorDept() {
		try {
			ArrayList<Dept> listadoDept = logic.LogDept.getDepts();
			for (Dept dept : listadoDept) {
				System.out.println(dept);
			}
		} catch (Exception e) {
			System.err.println("No se ha podido obtener el listado de departamentos");
			System.err.println(e.getMessage());
		}
		
	}
	
}
