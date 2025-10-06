package AccesoADatos.Ejercicio5;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class LeoBinario {
	public static void main(String[] args) throws FileNotFoundException {

		Scanner entrada = new Scanner(System.in);

		System.out.println("Nombre del fichero a encontrar : ");
		String nombre = entrada.nextLine();
		System.out.println("Dirección donde se encuentre el archivo : ");
		String direccion = entrada.nextLine();

		File f = new File(direccion + "\\" + nombre + ".dat");

		try (ObjectInputStream entradaDatos = new ObjectInputStream(new FileInputStream(f))) {

			while (true) // Bucle infinito para que salga por el catch, no sé si hay otrta manera
			{
				try {
					AlumnoEj5 a = (AlumnoEj5) entradaDatos.readObject();

					System.out.println(a.toString());
				}

				catch (EOFException eof) {
					// SALE POR AQUI
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
