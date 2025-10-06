package AccesoADatos.Ejercicio5;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeoBinario {
	public static void main(String[] args) throws FileNotFoundException {

		Scanner entrada = new Scanner(System.in);

		System.out.println("Nombre del fichero a encontrar : ");
		String nombre = entrada.nextLine();
		System.out.println("Dirección donde se encuentre el archivo : ");
		String direccion = entrada.nextLine();

		File f = new File(direccion + "\\" + nombre + ".dat");

		FileInputStream ficheroEntrada = new FileInputStream(f);

		DataInputStream entradaDatos = null;

		try {
			entradaDatos = new DataInputStream(ficheroEntrada);
			int nia;
			String nombreAl;
			String apellidos;
			char genero;
			String fecha_nac;
			String ciclo;
			String curso;
			String grupo;
			while (entradaDatos.available() > 0) {
				nia = entradaDatos.readInt();
				nombreAl = entradaDatos.readUTF();
				apellidos = entradaDatos.readUTF();
				genero = entradaDatos.readChar();
				fecha_nac = entradaDatos.readUTF();
				ciclo = entradaDatos.readUTF();
				curso = entradaDatos.readUTF();
				grupo = entradaDatos.readUTF();
				System.out.println("NIA : " + nia + "\n" + "nombreAl : " + nombreAl + "\n" + "apellidos : " + apellidos
						+ "\n" + "genero : " + genero + "\n" + "fecha Nacimiento :" + fecha_nac + "\n" + "Ciclo : "
						+ ciclo + "\n" + "Curso : " + curso + "\n" + "Grupo : " + grupo);

			}
			entrada.close();
			ficheroEntrada.close();

		} catch (Exception e) {
			System.out.println("Fallo en el archivo");
		}

	}

}
