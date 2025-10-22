package ProgramacionServiciosProcesos.EjercicioMio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class LlamadorCentral {

	public static void main(String[] args) throws IOException, InterruptedException {

		File f = new File(".");

		Process procesoSuma = new ProcessBuilder("java", "ProgramacionServiciosProcesos.EjercicioMio.SumaACentral")
				.directory(f).start();
		Process procesoMultip = new ProcessBuilder("java",
				"ProgramacionServiciosProcesos.EjercicioMio.MultiplicacionACentral").directory(f).start();
		Process procesoMedia = new ProcessBuilder("java", "ProgramacionServiciosProcesos.EjercicioMio.MediaACentral")
				.directory(f).start();

		int numeroSuma = 0;
		int numMultiplicado = 0;

		try (PrintWriter pwSum = new PrintWriter(procesoSuma.getOutputStream(), true)) {
			try {
				int num1 = Integer.parseInt(args[0]);
				pwSum.println(num1);
				int num2 = Integer.parseInt(args[1]);
				pwSum.println(num2);
			} catch (Exception e) {
				System.out.println("Tienen que ser números");
			}
		}
		procesoSuma.waitFor();
		try (BufferedReader brSuma= new BufferedReader(new InputStreamReader(procesoSuma.getInputStream()))) {

			numeroSuma = Integer.parseInt(brSuma.readLine());
		}

		try (PrintWriter pwMult = new PrintWriter(procesoMultip.getOutputStream(), true)) {
			try {
				int num1 = Integer.parseInt(args[2]);
				pwMult.println(num1);
				int num2 = Integer.parseInt(args[3]);
				pwMult.println(num2);
			} catch (Exception e) {
				System.out.println("Tienen que ser números");
			}
		}
		procesoMultip.waitFor();
		try (BufferedReader brMult = new BufferedReader(new InputStreamReader(procesoMultip.getInputStream()))) {

			numMultiplicado = Integer.parseInt(brMult.readLine());
		}
		

		try (PrintWriter pw = new PrintWriter(procesoMedia.getOutputStream())) {
			pw.println(numeroSuma);
			pw.println(numMultiplicado);

		}
		procesoMedia.waitFor();

		try (InputStream is = procesoMedia.getInputStream()) {
			int c;
			while ((c = is.read()) != -1) {
				System.out.print((char) c);

			}
		}

	}

}
