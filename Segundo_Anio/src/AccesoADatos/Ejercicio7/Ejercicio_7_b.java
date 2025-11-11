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

public class Ejercicio_7_b extends MetodosEnComun {

	public static void main(String[] args) {

		int alumnosCreados = 5;

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			Document documento = GeneroXML(factory);

			for (int i = 0; i < alumnosCreados; i++) {
				Element alumno = documento.createElement("Alumno");
				documento.getDocumentElement().appendChild(alumno);

				AlumnoEjercicio7 alumnoEj7 = CrearAlumnos();
				crearAlumnoComoAtributos(alumno, alumnoEj7);
			}
			FinalizoXml(documento);
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
