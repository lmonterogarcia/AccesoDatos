package ctrl;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

public class GestFch {

	private static Document docXML;

	public static void volcarDB() {
		ArrayList<String> aTablas;

		try {
			aTablas = logic.LogTablas.getListadoTablas();
			for (String tabla : aTablas) {
				crearXML(tabla);
				System.out.println("Se ha creado el archivo " + tabla + ".xml");
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void crearXML(String sTabla) throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException, DOMException, ParserConfigurationException {

		int iNumRegistros = 0;
		ArrayList<String> aNombreColumnas = null;

		iNumRegistros = logic.LogTablas.getNumRegistros(sTabla);
		aNombreColumnas = logic.LogTablas.getNombreCampos(sTabla);

		docXML = DocumentBuilderFactory.newInstance().newDocumentBuilder().getDOMImplementation().createDocument(null,
				sTabla.toUpperCase() + "S", null);

		if (aNombreColumnas != null) {

			for (int i = 1; i <= iNumRegistros; i++) {
				Element elemento = docXML.createElement(sTabla);
				ArrayList<String> aInfoRegistroTablas = logic.LogTablas.getInfoRegistroTabla(sTabla, i);

				Element tagName;
				Node tagValue;

				for (int j = 0; j < aNombreColumnas.size(); j++) {

					// Nombre
					tagName = docXML.createElement(aNombreColumnas.get(j));
					tagValue = docXML.createTextNode(aInfoRegistroTablas.get(j));
					tagName.appendChild(tagValue);
					elemento.appendChild(tagName);
				}

				Node nRaiz = docXML.getFirstChild();
				nRaiz.appendChild(elemento);

			}
			saveData(sTabla);
		}
	}

	public static void saveData(String sTabla) {

		try {
			Transformer tr = TransformerFactory.newInstance().newTransformer();
			tr.setOutputProperty(OutputKeys.INDENT, "yes");
//			tr.setOutputProperty(OutputKeys.METHOD, "xml");
			tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

			// enviar el DOM al fichero
			tr.transform(new DOMSource(docXML), new StreamResult(new FileOutputStream(sTabla + ".xml")));

		} catch (Exception e) {
			System.err.println("Error al guardar el " + sTabla + ".xml\n" + e.getMessage());
		}

	}

}
