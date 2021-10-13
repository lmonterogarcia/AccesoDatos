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
		File fch02 = new File("f2.txt");
		File fchResultado = new File("fd.txt");
		crearFchComun(fch01, fch02, fchResultado);
	}

	private static void crearFchComun(File fch01, File fch02, File fchResultado) {
		
		int iContador = 0;
		
		try {
			BufferedReader brFch01 = new BufferedReader(new FileReader(fch01));
			BufferedWriter bwFchResultado= new BufferedWriter(new FileWriter(fchResultado));
			String sLinea01 = brFch01.readLine();
			
			while (sLinea01 != null) {
				
//				if (lineaEncontrada(sLinea01,fch02)) {
//					escribirLoIGual(sLinea01, fchResultado);
//				}
				
				BufferedReader brFch02 = new BufferedReader(new FileReader(fch02));
				String sLinea02 = brFch02.readLine();
				boolean booEncontrado = false;
				
				while (sLinea02 != null && !booEncontrado) {
					
					if (sLinea01.equals(sLinea02)) {
						
						if (iContador > 0) {
							bwFchResultado.newLine();
							iContador++;
						} else {
							iContador++;
						}
						
						bwFchResultado.write(sLinea01);
						booEncontrado = true;
						
					}
					sLinea02 = brFch02.readLine();
				}
				sLinea01 = brFch01.readLine();
				brFch02.close();
			}
			
			bwFchResultado.flush();
			bwFchResultado.close();
			brFch01.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("El fichero no existe");
		} catch (IOException ioe){
			System.out.println("Se ha producido un error al acceder al fichero");
		} catch (Exception eiu) {
			System.out.println("Se ha producido un error no tipificado");
		}
	}
	
	private static boolean lineaEncontrada(File fch01, File fch02, File fchResultado) {
		boolean booEncontrado = false;
		
		return booEncontrado;
	}
	
	private static void escribirLoIGual() {
		
	}
}
