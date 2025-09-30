package ProgramacionServiciosProcesos.Ejercicio9;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class LlamoGenerador {

	public static void main(String[] args) throws IOException {

		Scanner entrada = new Scanner(System.in); // No estoy seguro de que funcione
		String linea;
		boolean bucle = true;

		while (bucle == true) {
			linea = entrada.nextLine();
			if (linea.equals("fin")) {
				bucle = false;
			} else {
				File f = new File (".");
				Process p = new ProcessBuilder("java", "ProgramacionServiciosProcesos.Ejercicio9.NumAleatorio").directory(f).start();
				try (InputStream is = p.getInputStream()) {
					int c;
					while ((c = is.read()) != -1) {
						System.out.print((char) c);
					}

				} catch (Exception e) {
					System.err.print("No se encuentra");
				}
				
			}

		}
		entrada.close();
	}

}
