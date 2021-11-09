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
	
}
