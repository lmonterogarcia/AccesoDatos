package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import model.Casa;

public class Main {

	public static void main(String[] args) {

		ArrayList<Casa> listado = leerXML("casas.xml");
		guardarHibernate(listado);
		System.out.println("Se ha terminado el programa");

	}

	private static ArrayList<Casa> leerXML(String fileName) {

		ArrayList<Casa> listadoCasas = new ArrayList<Casa>();
		Document docXML;
		
		try {
			docXML = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(fileName);
			docXML.getDocumentElement().normalize();
			
			NodeList nodes = docXML.getElementsByTagName("Casa");

				for (int i = 0; i < nodes.getLength(); i++) {
					Node nNode = nodes.item(i);
					
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) nNode;
						String sPoblacion, sSuperficie, sAseos;

						try {
							sPoblacion = eElement.getElementsByTagName("Poblacion").item(0).getTextContent();
						} catch (Exception e) {
							sPoblacion = "";
						}

						try {
							sSuperficie = eElement.getElementsByTagName("Superficie").item(0).getTextContent();
						} catch (Exception e) {
							sSuperficie = "";
						}

						try {
							sAseos = eElement.getElementsByTagName("Aseos").item(0).getTextContent();
						} catch (Exception e) {
							sAseos = "";
						}

						listadoCasas.add(new Casa(sPoblacion, Double.parseDouble(sSuperficie), Integer.parseInt(sAseos)));
					}
				}
			
		} catch (SAXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return listadoCasas;
	}

	private static void guardarHibernate(List<Casa> listadoCasasLeido) {
		org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.OFF);

		SessionFactory conf = new Configuration().configure().buildSessionFactory();
		Session session = conf.openSession();

		Transaction tx = session.beginTransaction();

		listadoCasasLeido.forEach(casa -> {
			session.save(casa);
			System.out.println("Añadido la casa: " + casa.toString());
		});

		tx.commit();

		session.close();
		conf.close();
	}

}
