package AccesoADatos.Ejercicio6;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import AccesoADatos.Ejercicio5.AlumnoEj5;

public class GestionFichero {

	File archivo;

	public void Generofichero(Scanner entrada) throws IOException {
		System.out.println("Dime el nombre del archivo que quieres creas :");
		String nombre = entrada.nextLine();
		System.out.println("Dime el nombre de la ruta donde va a ir este archivo :");
		String ruta = entrada.nextLine();
		try {
			archivo = new File(ruta + "\\" + nombre + ".dat");
		} catch (Exception e) {
			System.out.println("Ruta inválida, volviendo al menú");
		}
		AñadirAlumno(entrada);
	}

	public void AñadirAlumno(Scanner entrada) throws IOException {
		System.out.println("Nia del nuevo alumno");
		int niaNuevo = entrada.nextInt();
		System.out.println("Nombre del nuevo alumno");
		String nombreNuevo = entrada.next();
		System.out.println("Apellido del nuevo alumno");
		String apellidoNuevo = entrada.next();
		System.out.println("Genero del Nuevo alumno (M/F/N)");
		char generoNuevo = entrada.next().charAt(0);
		System.out.println("Fecha Nac dd/MM/yyyy");
		String fechaNuevo = entrada.next();
		System.out.println("Ciclo del nuevo alumno");
		String ciclo = entrada.next();
		System.out.println("Curso del nuevo alumno");
		String curso = entrada.next();
		System.out.println("Grupo del nuevo alumno");
		String grupo = entrada.next();

		PasoAlumnoABinario(
				new AlumnoEj5(niaNuevo, nombreNuevo, apellidoNuevo, generoNuevo, fechaNuevo, ciclo, curso, grupo));

	}

	public void PasoAlumnoABinario(AlumnoEj5 alumno) throws IOException {
		FileOutputStream salida = new FileOutputStream(archivo);
		ObjectOutputStream salidaDatos = new ObjectOutputStream(salida);

		salidaDatos.writeObject(alumno);

		salidaDatos.close();
	}

	public void CargarAlumno(Scanner entrada) throws IOException {
		AñadirAlumno(entrada);
	}

	public void MostrarAlumnos() {
		try (ObjectInputStream entradaDatos = new ObjectInputStream(new FileInputStream(archivo))) {
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
