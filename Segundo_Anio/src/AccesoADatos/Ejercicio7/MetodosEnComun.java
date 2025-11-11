 package AccesoADatos.Ejercicio7;

import java.io.File;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;



public abstract class MetodosEnComun {

	final static int NUM_ALUMNOS = 1;
	
	public static AlumnoEjercicio7 CrearAlumnos() 
	{
		Scanner entrada = new Scanner(System.in);
		System.out.println("Nia del nuevo alumno");
		int niaNuevo = Integer.parseInt(entrada.nextLine()); 
		System.out.println("Nombre del nuevo alumno");
		String nombreNuevo = entrada.nextLine().trim();
		System.out.println("Apellido del nuevo alumno");
		String apellidoNuevo = entrada.nextLine().trim();
		System.out.println("Genero del Nuevo alumno (M/F/N)");
		char generoNuevo = entrada.nextLine().trim().toUpperCase().charAt(0);
		System.out.println("Fecha Nac dd/MM/yyyy");
		String fechaNuevo = entrada.nextLine().trim();
		System.out.println("Ciclo del nuevo alumno");
		String ciclo = entrada.nextLine().trim();
		System.out.println("Curso del nuevo alumno");
		String curso = entrada.nextLine().trim();
		System.out.println("Grupo del nuevo alumno");
		String grupo = entrada.nextLine().trim();
		return new AlumnoEjercicio7(niaNuevo, nombreNuevo, apellidoNuevo, generoNuevo, fechaNuevo, ciclo, curso, grupo);

	}
	public static Document GeneroXML(DocumentBuilderFactory factory) throws ParserConfigurationException {
		DocumentBuilder builder = factory.newDocumentBuilder();
		DOMImplementation implementation = builder.getDOMImplementation();
		Document documento = implementation.createDocument(null, "Alumnos", null);
		documento.setXmlVersion("1.0");
		return documento;
	}
	
	public static void FinalizoXml(Document documento)
			throws TransformerConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		Source source = new DOMSource(documento); // El XML en memoria
		Result result = new StreamResult(new java.io.File("Alumnos_a.xml")); // Archivo de salida
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.transform(source, result);
		System.out.println("XML completado con éxito");
	}
	
	
}
