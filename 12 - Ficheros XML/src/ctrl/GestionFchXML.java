package ctrl;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.*;
import javax.xml.xpath.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import model.Jugador;
import model.Partida;

public class GestionFchXML {

	private Document docXML;

	public GestionFchXML(String filename) {
		try {
			docXML = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(filename);
			docXML.getDocumentElement().normalize();
		} catch (SAXException e) {
			System.err.println("Error SAX.");
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			System.err.println("Error con el PARSE");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error accediendo al fichero");
			e.printStackTrace();
		}
	}

	public void mostrarDocumento() {

		XPath xPath = XPathFactory.newInstance().newXPath();

		String sExpression = "/game/jugador";

		try {
			NodeList nodeList = (NodeList) xPath.compile(sExpression).evaluate(docXML, XPathConstants.NODESET);

			for (int i = 0; i < nodeList.getLength(); i++) {
				Node nNode = nodeList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					System.out.println("Jugador numero: " + eElement.getAttribute("numero"));
					System.out.println(
							"Nombre        = " + eElement.getElementsByTagName("nombre").item(0).getTextContent());
					System.out.println(
							"Apellidos     = " + eElement.getElementsByTagName("apellidos").item(0).getTextContent());
					System.out.println(
							"Nick          = " + eElement.getElementsByTagName("nick").item(0).getTextContent());
					System.out.println(
							"Puntos        = " + eElement.getElementsByTagName("puntos").item(0).getTextContent());
					System.out.println("\n");
				}
			}

		} catch (XPathExpressionException e) {
			System.err.println("Error aplicando al expresion");
			e.printStackTrace();
		}

	}

	public ArrayList<Jugador> getJugadores() {

		ArrayList<Jugador> listadoJugadores = new ArrayList<Jugador>();
		XPath xPath = XPathFactory.newInstance().newXPath();
		String sExpression = "/game/jugador";

		try {
			NodeList nodeList = (NodeList) xPath.compile(sExpression).evaluate(docXML, XPathConstants.NODESET);

			for (int i = 0; i < nodeList.getLength(); i++) {
				Node nNode = nodeList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					String sNombre, sApellidos, sNick;
					int iNumero, iPuntos;
					
					try {
						iNumero = Integer.parseInt(eElement.getAttribute("numero"));
					} catch (Exception e) {
						iNumero = 0;
					}
					
					try {
						sNombre = eElement.getElementsByTagName("nombre").item(0).getTextContent();
					} catch (Exception e) {
						sNombre = "";
					}
					
					try {
						sApellidos = eElement.getElementsByTagName("apellidos").item(0).getTextContent();
					} catch (Exception e) {
						sApellidos = "";
					}
					
					try {
						sNick = eElement.getElementsByTagName("nick").item(0).getTextContent();
					} catch (Exception e) {
						sNick = "";
					}
					
					try {
						iPuntos = Integer.parseInt(eElement.getElementsByTagName("puntos").item(0).getTextContent());
					} catch (Exception e) {
						iPuntos = 0;
					}
				

					listadoJugadores.add(new Jugador(iNumero, sNombre, sApellidos, sNick, iPuntos));
				}
			}

		} catch (XPathExpressionException e) {
			System.err.println("Error aplicando al expresion");
			e.printStackTrace();
		}

		return listadoJugadores;
	}

	public ArrayList<Partida> getPartidas() {
		
		ArrayList<Partida> listadoPartidas = new ArrayList<Partida>();
		XPath xPath = XPathFactory.newInstance().newXPath();
		String sExpression = "/game/partida";

		try {
			NodeList nodeList = (NodeList) xPath.compile(sExpression).evaluate(docXML, XPathConstants.NODESET);

			for (int i = 0; i < nodeList.getLength(); i++) {
				Node nNode = nodeList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					int iNumero, iDuracion;
					Jugador oJugador1, oJugador2;
					
					try {
						iNumero = Integer.parseInt(eElement.getAttribute("numero"));
					} catch (Exception e) {
						iNumero = 0;
					}
					
					try {
						oJugador1 = new Jugador (Integer.parseInt(eElement.getElementsByTagName("jugador1").item(0).getTextContent()));
					} catch (Exception e) {
						oJugador1 = null;
					}
					
					try {
						oJugador2 = new Jugador(Integer.parseInt(eElement.getElementsByTagName("jugador2").item(0).getTextContent()));
					} catch (Exception e) {
						oJugador2 = null;
					}
					
					try {
						iDuracion = Integer.parseInt(eElement.getElementsByTagName("duracion").item(0).getTextContent());
					} catch (Exception e) {
						iDuracion = 0;
					}
				

					listadoPartidas.add(new Partida(iNumero, iDuracion, oJugador1, oJugador2));
				}
			}

		} catch (XPathExpressionException e) {
			System.err.println("Error aplicando al expresion");
			e.printStackTrace();
		}
		
		return listadoPartidas;
	}
}
