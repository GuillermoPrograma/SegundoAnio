package ProgramacionServiciosProcesos.Ejercicio4;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Actividad1_1 {

	public static void main(String[] args) throws IOException {
		File d = new File(".");
		// proceso a ejecutar es Ejemplo2
		Process ps = new ProcessBuilder("java", "LeerNombre", "Guille").directory(d).start();// java es el comando para ejecutar un class
		// establecemos el directorio donde está el ejecutable

		// obtener la salida
		try {
			InputStream is = ps.getInputStream();
			int c;
			while ((c = is.read()) != -1) {
				System.out.print((char) c);
			}
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
