package ProgramacionServiciosProcesos.Ejercicio7;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class MuestroFallo {
	public static void main(String[] args) throws IOException {
		File d = new File(".");
		// proceso a ejecutar es Ejemplo2
		Process ps = null;
		ps = new ProcessBuilder("java", "noExisto").directory(d).start();

		InputStream err = ps.getErrorStream();

		int c;
		while ((c = err.read()) != -1) {
			
			System.err.println(c); //No estoy seguro si esto está bien ya que creo que tendría que ir en un catch, pero sino detecta el prgrama nunca se inicia
		}

	}
}
