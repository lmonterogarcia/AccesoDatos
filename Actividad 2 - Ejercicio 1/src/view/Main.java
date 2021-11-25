package view;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import model.Casa;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Casa> listado = crearCasas();
		guardarOBJ(listado, "casas.obj");
		guardarXML(listado, "casas.xml");
		
		System.out.println("Se ha completado el programa");

	}

	private static ArrayList<Casa> crearCasas() {
		
		ArrayList<Casa> listadoCasas = new ArrayList<Casa>();
		
		listadoCasas.add(new Casa("Sevilla", 234.87, 2));
		listadoCasas.add(new Casa("Huelva", 124.6, 3));
		listadoCasas.add(new Casa("Cadiz", 985.8, 1));
		listadoCasas.add(new Casa("Cordoba", 2456.9, 0));
		listadoCasas.add(new Casa("Malaga", 30.5, 1));
		
		return listadoCasas;
	}
	
	private static void guardarOBJ(ArrayList<Casa> listado, String fileName) {
		try {

			ObjectOutputStream buff = new ObjectOutputStream(new FileOutputStream(fileName));
			
			buff.writeObject(listado);

			buff.close();
		} catch (FileNotFoundException e) {
			System.err.println("ERROR: " + fileName + " no existe.");
		} catch (IOException e) {
			System.err.println("ERROR: No se puede escribir en el fichero.");
		}
		
	}
	
	private static void guardarXML(ArrayList<Casa> listado, String fileName) {
		
		Document docXML;
		try {
			docXML = DocumentBuilderFactory.newInstance().newDocumentBuilder().getDOMImplementation().createDocument(null,
					"CASAS", null);
			
			String sNombreElemento = "Casa";
			
			if (listado.size() > 0) {
				
				listado.forEach( casa -> {
					crearElementos(docXML, sNombreElemento, casa);
					
				});
			}
			
			saveXML(fileName, docXML);
			
		} catch (DOMException e1) {
			System.err.println("Error con el DOM");
			e1.printStackTrace();
		} catch (ParserConfigurationException e1) {
			System.err.println("Error con el PARSE");
			e1.printStackTrace();
		}
		
		
	}

	private static void crearElementos(Document docXML, String sNombreElemento, Casa casa) {
		Element elemento = docXML.createElement(sNombreElemento);
		Element tagName;
		Node tagValue;
		
		//Poblacion
		tagName = docXML.createElement("Poblacion");
		tagValue = docXML.createTextNode(casa.getsPoblacion());
		tagName.appendChild(tagValue);
		elemento.appendChild(tagName);
		
		//Superficie
		tagName = docXML.createElement("Superficie");
		tagValue = docXML.createTextNode("" + casa.getdSuperficie());
		tagName.appendChild(tagValue);
		elemento.appendChild(tagName);
		
		//Aseos
		tagName = docXML.createElement("Aseos");
		tagValue = docXML.createTextNode("" + casa.getiAseos());
		tagName.appendChild(tagValue);
		elemento.appendChild(tagName);
		
		Node nRaiz = docXML.getFirstChild();
		nRaiz.appendChild(elemento);
	}

	private static void saveXML(String fileName, Document docXML) throws TransformerFactoryConfigurationError {
		try {
			Transformer tr = TransformerFactory.newInstance().newTransformer();
			tr.setOutputProperty(OutputKeys.INDENT, "yes");
			tr.setOutputProperty(OutputKeys.METHOD, "xml");
			tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");


			tr.transform(new DOMSource(docXML), new StreamResult(new FileOutputStream(fileName)));

		} catch (Exception e) {
			System.err.println("Error al guardar el " + fileName + "\n" + e.getMessage());
		}
	}

}
