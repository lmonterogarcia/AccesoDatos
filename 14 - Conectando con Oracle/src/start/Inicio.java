package start;

import java.sql.SQLException;

public class Inicio {

	public static void main(String[] args) {
		
		if (dbms.DBoracle.testDbOracle()) {
			System.out.println("Se puede establecer conexion con la base de datos");
		} else {
			System.out.println("No se puede establecer conexion con la base de datos");
		}


	}

}
