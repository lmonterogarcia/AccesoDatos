package view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Principal {

	public static void main(String[] args) {

		File fch01 = new File("f1.txt");
		File fchResultado = new File("fresultado.txt");
		invertirFichero(fch01, fchResultado);

	}

	private static void invertirFichero(File fch01, File fchResultado) {

		int iNumLineas = contadorLineas(fch01);
		String sLineaLeida = "";
		boolean booPrimera = true;
		
		try {
			BufferedWriter buffWrite = new BufferedWriter(new FileWriter(fchResultado));
			for (int i = iNumLineas; i > 0; i--) {
				BufferedReader buffReader = new BufferedReader(new FileReader(fch01));
				for (int j = i; j > 0; j--) {
					sLineaLeida = buffReader.readLine();
				}
				if (!booPrimera) {
					buffWrite.newLine();
					
				} else {
					booPrimera = false;
				}
				
				buffWrite.write(sLineaLeida);
				buffReader.close();
			}
			buffWrite.flush();
			buffWrite.close();

		} catch (FileNotFoundException e) {
			System.out.println("El fichero no existe");
		} catch (IOException ioe){
			System.out.println("Se ha producido un error al acceder al fichero");
		} catch (Exception eiu) {
			System.out.println("Se ha producido un error no tipificado");
		}



	}

	private static int contadorLineas(File fch01) {
		int iNumLineas = 0;
		
		try {
			BufferedReader buffReader = new BufferedReader(new FileReader(fch01));
			String sLineaLeida = buffReader.readLine();
			while (sLineaLeida != null) {
				iNumLineas++;
				sLineaLeida = buffReader.readLine();
			}
			buffReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("El fichero no existe");
		} catch (IOException ioe){
			System.out.println("Se ha producido un error al acceder al fichero");
		} catch (Exception eiu) {
			System.out.println("Se ha producido un error no tipificado");
		}

		return iNumLineas;
	}

}
