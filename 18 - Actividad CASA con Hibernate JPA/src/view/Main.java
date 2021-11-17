package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Casa;

public class Main {

	public static void main(String[] args) {
		
		
		List<Casa> listadoCasas = crearCasas();
		escribirObj("casas.dat", listadoCasas);
		List<Casa> listadoCasasLeido = leerObj("casas.dat");
		escribirDB(listadoCasasLeido);
		

	}

	private static void escribirDB(List<Casa> listadoCasasLeido) {
		org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.OFF);

		SessionFactory conf = new Configuration().configure().buildSessionFactory();
		Session session = conf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		//INSERTAR
		
		listadoCasasLeido.forEach(casa -> {
			session.save(casa);
			System.out.println("Añadido la casa: " + casa.toString());	
		});
		
		tx.commit();

		session.close();
		conf.close();
	}

	@SuppressWarnings("unchecked")
	private static List<Casa> leerObj(String fileName) {
		List<Casa> listado = new ArrayList<>();

		try {
			ObjectInputStream buff = new ObjectInputStream(new FileInputStream(fileName));

			listado = (List<Casa>)buff.readObject();
			
		} catch (FileNotFoundException e) {
			System.err.println("ERROR: " + fileName + " no existe.");
		} catch (IOException e) {
			System.err.println("ERROR: No se puede leer del fichero.");
		} catch (ClassNotFoundException e) {
			System.err.println("ERROR: El fichero no contiene un coche");
		}

		return listado;
	}

	private static void escribirObj(String fileName, List<Casa> listadoCasas) {
		try {
			ObjectOutputStream buff = new ObjectOutputStream(new FileOutputStream(fileName));
			
			buff.writeObject(listadoCasas);

			buff.close();
		} catch (FileNotFoundException e) {
			System.err.println("ERROR: " + fileName + " no existe.");
		} catch (IOException e) {
			System.err.println("ERROR: No se puede escribir en el fichero.");
		}
	}

	private static List<Casa> crearCasas() {
		List<Casa> listadoCasas = new ArrayList<Casa>();
		
		listadoCasas.add(new Casa("Mexico", 23, 120.45));
		listadoCasas.add(new Casa("Panama", 1, 300.43));
		listadoCasas.add(new Casa("Costa Rica", 21, 900.8));
		listadoCasas.add(new Casa("Francia", 12, 30.0));
		listadoCasas.add(new Casa("Sol", 45, 88.67));
		listadoCasas.add(new Casa("Luna", 9, 70.54));
		listadoCasas.add(new Casa("Colon", 26, 564.45));
		listadoCasas.add(new Casa("Martin Pinto", 87, 76.45));
		listadoCasas.add(new Casa("Sur", 87, 234.45));
		
		
		return listadoCasas;
	}

}
