package view;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Coche;

public class FrmPrincipal {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.OFF);

		SessionFactory conf = new Configuration().configure().buildSessionFactory();
		Session session = conf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		
		
		//INSERTAR
		Coche c = new Coche("Renault","Kangoo",1100);
		session.save(c);
		System.out.println("Añadido el coche: " + c.toString());
		
		//BORRAR
//		Coche c = new Coche(22, "Mercedes","GLC",2500);
//		session.delete(c);
//		System.out.println("Borrado el coche: " + c.toString());
		
		//ACTUALIZAR
//		Coche c = new Coche(23, "Mercedes","GLC",3000);
//		session.update(c);
//		System.out.println("Actualizado el coche: " + c.toString());
		
		//CONSULTA
//		int iId = 23;
//		Coche c = session.byId(Coche.class).getReference(iId);
//		Coche c = session.load(Coche.class, iId);
//		System.out.println(c);
		
		//LISTAR
//		List<Coche> listadoCoches = session.createQuery("from Coche").list();
//		listadoCoches.forEach( c -> System.out.println(c));		
		
		tx.commit();

		session.close();
		conf.close();
		
		System.out.println("Fin del programa");

	}

}
