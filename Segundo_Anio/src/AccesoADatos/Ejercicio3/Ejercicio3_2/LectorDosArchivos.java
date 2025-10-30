package AccesoADatos.Ejercicio3.Ejercicio3_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LectorDosArchivos {

	public static void main(String[] args) {

		File archivoLec1 = new File("Prueba.txt");
		File archivoLec2 = new File("CogePar.txt");
		File archivoEsc = new File("Tercero.txt");

		try (FileWriter fw = new FileWriter(archivoEsc);
				PrintWriter bw = new PrintWriter(fw);
				FileReader pr = new FileReader(archivoLec1);
				BufferedReader br1 = new BufferedReader(pr);
				FileReader pr2 = new FileReader(archivoLec2);
				BufferedReader br2 = new BufferedReader(pr2);) {
			String linea = "";
			String linea2 = "";

			while ((linea = br1.readLine()) != null && (linea2 = br2.readLine()) != null) {

				bw.println(linea);

				bw.println(linea2);

			}
			if (linea == null) {
				while ((linea2 = br2.readLine()) != null) {
					bw.println(linea2);
				}
			}
			if (linea2 == null) {
				bw.println(linea);
				while ((linea = br1.readLine()) != null) {
					bw.println(linea);
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
