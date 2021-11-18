package view;

public class FrmPrincipal {

	public static void inicio() {

		testConection();
		ctrl.GestFch.volcarDB();
		System.out.println("Se ha terminado el programa");
		
		
	}

	private static void testConection() {
		if (dbms.DBoracle.testDbOracle()) {
			System.out.println("Empieza la transferencia de datos");
		} else {
			System.out.println("No se puede establecer conexion con la base de datos");
		}
	}

}
