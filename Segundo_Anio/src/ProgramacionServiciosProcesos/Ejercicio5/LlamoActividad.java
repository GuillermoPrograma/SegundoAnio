package ProgramacionServiciosProcesos.Ejercicio5;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class LlamoActividad {

	public static void main(String[] args) throws IOException {
		File d = new File(".");
		// proceso a ejecutar es Ejemplo2
		Process ps = new ProcessBuilder("java","ProgramacionServiciosProcesos.Ejercicio5.Divisores", 
				args[0]).directory(d).start();// java es el comando para ejecutar un class

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
	
