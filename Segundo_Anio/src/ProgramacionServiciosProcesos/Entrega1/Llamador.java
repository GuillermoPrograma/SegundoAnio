package ProgramacionServiciosProcesos.Entrega1;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Clase {@code Llamador} llama al proceso {@code SumoNum} pasandole dos numeros
 * @author Guille 
 * @version 1.0
 */
public class Llamador {

	/**
	 * 
	 * @param args, se manda por codigo de comando
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {

		if (args.length < 2) {
			System.err.println("Tienen que ser dos números");
			return;
		}
		
		File f = new File("."); //Como son variables locales no se ponen en el javadoc

		Process p = new ProcessBuilder("java", "ProgramacionServiciosProcesos.Entrega1.SumoNum").directory(f).start();

		try (PrintWriter pw = new PrintWriter(p.getOutputStream(), true)) // Si lo hago de esta manera tiene que haber
																			// un escaner en la otra clase por el
																			// system.in
		{
			try {
				pw.println(Integer.parseInt(args[0]));
				pw.println(Integer.parseInt(args[1]));
			} catch (Exception e) {
				System.err.println("Has metido un codigo de texto");
			}
		}
		p.waitFor();
		try (InputStream is = p.getInputStream()) {
			int c;
			while ((c = is.read()) != -1) {
				System.out.print((char) c); // Leo lo que le pasa el hijo
			}

		}
		try (InputStream err = p.getErrorStream()) {
			int c;
			while ((c = err.read()) != -1) {
				System.out.print((char) c); // Leo lo que le pasa si tiene error el hijo
			}

		} catch (Exception e) {
			System.err.println("No se encuentra");
		}

	}
}
