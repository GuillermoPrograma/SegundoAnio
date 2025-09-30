package ProgramacionServiciosProcesos.Ejercicio7;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class MuestroFallo {
public static void main(String[] args) {
	File d = new File(".");
	// proceso a ejecutar es Ejemplo2
	Process ps = null;
	try {
		ps = new ProcessBuilder("java", "noExisto").directory(d).start();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(ps.getErrorStream());
	}
}
}
