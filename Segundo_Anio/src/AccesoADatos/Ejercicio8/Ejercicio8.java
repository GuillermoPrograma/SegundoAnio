package AccesoADatos.Ejercicio8;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;

public class Ejercicio8 {
	public static void main(String[] args) throws IOException {

		//Yo tengo todos los archivos guardados en paquetes, por lo que igual hay que quitar la variable
		String variable ="\\AccesoADatos\\";
		int xslVersion = 3; //Hay 3 versiones, del 1 al 3
        String hojaEstilo = "src"+ variable +"Ejercicio8\\alumnos_Version"+ xslVersion +".xsl";
        String datosAlumnos = "src" +variable+"Ejercicio8\\Alumnos_a.xml";
		File pagHTML = new File("miPagina.html");

		
		FileOutputStream os = new FileOutputStream(pagHTML);
		try {
			Source estilos = new StreamSource(hojaEstilo); //la ruta 
			Source datos = new StreamSource(datosAlumnos);

			Result result = new StreamResult(os); // declaras la ruta del resultado
			Transformer transformer = TransformerFactory.newInstance().newTransformer(estilos);
			transformer.transform(datos, result); //Aqui le dices lo demás
			System.out.println("Html completado");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			os.close();
		}
	}
}
