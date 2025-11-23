package ProgramacionServiciosProcesos.EjercicioRepaso2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Coordinador2 {
	public static void main(String[] args) throws IOException, InterruptedException {
		File f = new File(".");
		Process p = new ProcessBuilder("java", "ProgramacionServiciosProcesos.EjercicioRepaso2.GenerarNumeros", args[0])
				.directory(f).start();
		List<Integer> listaNumeros = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))) {

			String linea;
			while ((linea = br.readLine()) != null) {
				try {
					System.out.println(linea);
					listaNumeros.add(Integer.parseInt(linea));
				} catch (Exception e) {
					System.out.println("Tiene que ser un int lo que mandas");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		try (InputStream err = p.getErrorStream()) {
			int c;

			while ((c = err.read()) != -1) {
				System.out.print((char) c);
			}
		}
		p.waitFor();

		Process p2 = new ProcessBuilder("java", "ProgramacionServiciosProcesos.EjercicioRepaso2.Cuadrado", args[0])
				.directory(f).start();

		try (PrintWriter pw = new PrintWriter(p2.getOutputStream())) {
			for (Integer num : listaNumeros) {
				pw.println(num);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Integer> listaNumerosCuadrados = new ArrayList<>();
		try (BufferedReader br2 = new BufferedReader(new InputStreamReader(p2.getInputStream()))) {
			String linea;
			while ((linea = br2.readLine()) != null) {
				listaNumerosCuadrados.add(Integer.parseInt(linea));
				System.out.println(linea);
			}
			try (InputStream err = p2.getErrorStream()) {
				int c;
				while ((c = err.read()) != -1) {
					System.out.print((char) c);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		p2.waitFor();
		
		Process p3 = new ProcessBuilder("java","ProgramacionServiciosProcesos.EjercicioRepaso2.Suma").directory(f).start();
		
		try(PrintWriter pw = new PrintWriter(p3.getOutputStream()))
		{
			for (Integer num : listaNumerosCuadrados) 
			{
				pw.println(num);
			}
			
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		try(BufferedReader br = new BufferedReader(new InputStreamReader(p3.getInputStream())))
		{
			String linea;
			while((linea = br.readLine()) != null) 
			{
				System.out.println("la suma total es " + linea);
			}
		}
		
	}

}
