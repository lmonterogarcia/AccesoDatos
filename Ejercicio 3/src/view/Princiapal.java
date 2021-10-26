package view;

import java.io.*;

public class Princiapal {

	public static void main(String[] args) {

		File fch1 = new File("fichero1.txt");
		File fch2 = new File("fichero2.txt");

		contarSiExiste(fch1, fch2);

	}

	private static void contarSiExiste(File fch1, File fch2) {
		int iContador = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(fch1));
			String sLineaLeida = br.readLine();

			while (sLineaLeida != null) {
				iContador = contarIguales(sLineaLeida, fch2);
				System.out.println(sLineaLeida + "," + iContador);
				sLineaLeida = br.readLine();
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println("El fichero no existe");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Se ha producido un error al acceder al fichero");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Ha ocurrido un error no clasificado");
			e.printStackTrace();
		}
	}

	private static int contarIguales(String sLineaLeida, File fch) throws Exception{
		int iContador = 0;

//		try {
			BufferedReader br = new BufferedReader(new FileReader(fch));
			String sLineaLeida2 = br.readLine();

			while (sLineaLeida2 != null) {
				if (sLineaLeida.equals(sLineaLeida2)) {
					iContador++;
				}
				sLineaLeida2 = br.readLine();
			}
			br.close();

//		} catch (FileNotFoundException e) {
//			System.err.println("El fichero no existe");
//			e.printStackTrace();
//		} catch (IOException e) {
//			System.err.println("Se ha producido un error al acceder al fichero");
//			e.printStackTrace();
//		} catch (Exception e) {
//			System.err.println("Ha ocurrido un error no clasificado");
//			e.printStackTrace();
//		}
		return iContador;
	}

}
