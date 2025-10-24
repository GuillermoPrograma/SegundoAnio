package AccesoADatos.Ejercicio7;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Ejercicio_7_b {

	public static void main(String[] args) {

		int alumnosCreados = 5;

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();
			Document documento = implementation.createDocument(null, "Alumnos_b", null);
			documento.setXmlVersion("1.0");

			for (int i = 0; i < alumnosCreados; i++) {
				Element alumno = documento.createElement("Alumno");
				documento.getDocumentElement().appendChild(alumno);

				AlumnoEjercicio7 alumnoEj7 = MetodosEnComun.CrearAlumnos();
				crearAlumnoComoAtributos(alumno, alumnoEj7);
			}
			Source source = new DOMSource(documento); // El XML en memoria
			Result result = new StreamResult(new java.io.File("Alumnos_b.xml")); // Archivo de salida
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, result);
			System.out.println("XML completado con éxito");
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

	}

	private static void crearAlumnoComoAtributos(Element alumno, AlumnoEjercicio7 alumnoEj7) {
		alumno.setAttribute("Nia", Integer.toString(alumnoEj7.getNia()));
		alumno.setAttribute("Nombre", alumnoEj7.getNombre());
		alumno.setAttribute("Apellidos", alumnoEj7.getApellidos());
		alumno.setAttribute("Ciclo", alumnoEj7.getCiclo());
		alumno.setAttribute("Curso", alumnoEj7.getCurso());
		alumno.setAttribute("Grupo", alumnoEj7.getGrupo());
		alumno.setAttribute("Genero", Character.toString(alumnoEj7.getGenero()));
		alumno.setAttribute("Fecha_Nacimiento", alumnoEj7.getFechaString());
	}


	

	
}
