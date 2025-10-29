package AccesoADatos.Ejercicio3.Ejercicio3_1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FicheroPar {
	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		System.out.println("Dame el Nombre del fichero que quieres usar :");
		try (FileReader pr = new FileReader(entrada.next());BufferedReader br = new BufferedReader(pr);
			 FileWriter fw = new FileWriter(entrada.next());PrintWriter bw = new PrintWriter(fw)) {
			
			int contador = 0;
			String linea;
			System.out.println("Donde lo guardamos");

			while ((linea = br.readLine()) != null) {
				contador++;
				if (contador % 2 == 0)
					bw.println(linea);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		entrada.close();
	}
}
