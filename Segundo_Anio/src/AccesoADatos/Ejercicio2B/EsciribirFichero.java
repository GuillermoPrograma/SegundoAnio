package AccesoADatos.Ejercicio2B;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EsciribirFichero {

	public static void main(String[] args) {
		boolean bucle = true;
		Scanner entrada = new Scanner(System.in);
		File archivo = new File("Prueba.txt");
		try (FileWriter fw = new FileWriter(archivo); PrintWriter bw = new PrintWriter(fw)) {
			String linea;
			while (bucle == true) {
				linea = entrada.nextLine();
				if (linea.equalsIgnoreCase("exit")) {
					System.out.println("finalizando Sistema");
					bucle = false;
				} else {
					bw.println(linea);
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		entrada.close();
	}
	
}
