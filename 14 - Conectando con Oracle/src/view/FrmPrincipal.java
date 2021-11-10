package view;

public class FrmPrincipal {

	public static void inicio() {

//		testConection();
//		ctrl.CtrlDept.ejecutaSQL();	
//		nuevoDepartamento();
//		totalEmpleados();
		
		listadoDepts();
		
		
	}

	private static void listadoDepts() {
		Integer iNumDept = 20;
		
		ctrl.CtrlDept.getEmpsPorDept();
		
		
	}

	private static void totalEmpleados() {
		int iDepartamento = 20;
		ctrl.CtrlDept.totalEmpleados(iDepartamento);
		
	}

	private static void nuevoDepartamento() {
		String sLocalidad = "MADRID";
		Integer iNumDept = 10;
		
		ctrl.CtrlDept.nuevaLoc(sLocalidad, iNumDept);
	}

	private static void testConection() {
		if (dbms.DBoracle.testDbOracle()) {
			System.out.println("Se puede establecer conexion con la base de datos");
		} else {
			System.out.println("No se puede establecer conexion con la base de datos");
		}
	}

}
