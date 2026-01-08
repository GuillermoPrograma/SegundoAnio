package AccesoADatos.EjercicioPruebaXml;

import java.io.File;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class PrueboXML {
public static void main(String[] args) {
	DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();

	try {
		DocumentBuilder db = factoria.newDocumentBuilder();
		Document doc = db.newDocument();
		
		Element root = doc.createElement("empleado");
		doc.appendChild(root);
		
		Element empleado = doc.createElement("Empleado");
		root.appendChild(empleado);
		
		Element nombre = doc.createElement("Nombre");
		nombre.setTextContent("ALba");
		empleado.appendChild(nombre);
		
		
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("Prueba.xml"));
		 transformer.transform(source, result);
		 
		
	} catch (ParserConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (TransformerConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (TransformerException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
