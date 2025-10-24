package AccesoADatos.Ejercicio7;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.transform.Source;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class Ejercicio_7_a {

	public static void main(String[] args) {

		int alumnosCreados = 5;

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();
			Document documento = implementation.createDocument(null, "Alumnos", null);
			documento.setXmlVersion("1.0");

			for (int i = 0; i < alumnosCreados; i++) {
				Element alumno = documento.createElement("Alumno");
				documento.getDocumentElement().appendChild(alumno);

				AlumnoEjercicio7 alumnoEj7 = MetodosEnComun.CrearAlumnos();
				extracted(documento, alumno, alumnoEj7);
			}
			Source source = new DOMSource(documento); // El XML en memoria
			Result result = new StreamResult(new java.io.File("Alumnos_a.xml")); // Archivo de salida
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, result);
			System.out.println("XML completado con éxito");
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

	}

	private static void extracted(Document documento, Element alumno, AlumnoEjercicio7 alumnoEj7)
			throws TransformerException, ParserConfigurationException {
		crearElementoComoEtiqueta("Nia", alumnoEj7.getNia(), alumno, documento);
		crearElementoComoEtiqueta("Nombre", alumnoEj7.getNombre(), alumno, documento);
		crearElementoComoEtiqueta("Apellidos", alumnoEj7.getApellidos(), alumno, documento);
		crearElementoComoEtiqueta("Ciclo", alumnoEj7.getCiclo(), alumno, documento);
		crearElementoComoEtiqueta("Curso", alumnoEj7.getCurso(), alumno, documento);
		crearElementoComoEtiqueta("Grupo", alumnoEj7.getGrupo(), alumno, documento);
		crearElementoComoEtiqueta("Genero", alumnoEj7.getGenero(), alumno, documento);
		crearElementoComoEtiqueta("Fecha_Nacimiento", alumnoEj7.getFechaString(), alumno, documento);
	}

	private static void crearElementoComoEtiqueta(String datoEmpleado, String valor, Element empleado,
			Document documento) {
		Element elem = documento.createElement(datoEmpleado); // Creo el empleado con lo que le vaya a poner,
																// <nombre></nombre>
		Text text = documento.createTextNode(valor); // Texto interno dentro de la etiqueta, <nombre>Guille<nombre>
		elem.appendChild(text);
		empleado.appendChild(elem); // nodo padre que va a ser empleado en este caso

	}

	private static void crearElementoComoEtiqueta(String datoEmpleado, int valor, Element empleado,
			Document documento) {
		Element elem = documento.createElement(datoEmpleado); // Creo el empleado con lo que le vaya a poner,
																// <nombre></nombre>
		Text text = documento.createTextNode(Integer.toString(valor)); // Texto interno dentro de la etiqueta,
																		// <nombre>Guille<nombre>
		elem.appendChild(text);
		empleado.appendChild(elem); // nodo padre que va a ser empleado en este caso

	}
}
