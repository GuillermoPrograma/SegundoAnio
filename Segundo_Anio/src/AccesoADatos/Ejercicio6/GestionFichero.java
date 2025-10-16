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
			AñadirAlumno(entrada);
		} catch (Exception e) {
			System.out.println("Ruta inválida, volviendo al menú");
		}

	}

	public void AñadirAlumno(Scanner entrada) throws IOException {
		System.out.println("Nia del nuevo alumno");
		int niaNuevo = Integer.parseInt(entrada.nextLine()); //Cuidado el buffer que está dando problemas
		System.out.println("Nombre del nuevo alumno");
		String nombreNuevo = entrada.nextLine().trim();
		System.out.println("Apellido del nuevo alumno");
		String apellidoNuevo = entrada.nextLine().trim();
		System.out.println("Genero del Nuevo alumno (M/F/N)");
		char generoNuevo = entrada.nextLine().trim().toUpperCase().charAt(0);
		System.out.println("Fecha Nac dd/MM/yyyy");
		String fechaNuevo = entrada.nextLine().trim();
		System.out.println("Ciclo del nuevo alumno");
		String ciclo = entrada.nextLine().trim();
		System.out.println("Curso del nuevo alumno");
		String curso = entrada.nextLine().trim();
		System.out.println("Grupo del nuevo alumno");
		String grupo = entrada.nextLine().trim();

		PasoAlumnoABinario(
				new AlumnoEj6(niaNuevo, nombreNuevo, apellidoNuevo, generoNuevo, fechaNuevo, ciclo, curso, grupo));

	}

	public void CargarFichero(Scanner entrada) {
		System.out.println("Dame la ruta del fichero");
		String ruta = entrada.nextLine();
		System.out.println("Dime el nombre del fichero");
		String nombre = entrada.nextLine();
		try {
			archivo = new File(ruta + "\\" + nombre + ".dat"); //Lo Instancio en memoria pero no se crea realmente hasta que no escriba sobre él
			
			if(archivo.exists() && archivo.isFile())
				System.out.println("Archivo encontrado"); //Si los dos estan a true es que hay un archivo ya con objetos
			else
				System.out.println("Archivo no encontrado, tienes que crearlo o buscar otro");
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public void PasoAlumnoABinario(AlumnoEj6 alumno) throws IOException {
		FileOutputStream salida = new FileOutputStream(archivo);
		ObjectOutputStream salidaDatos = new ObjectOutputStream(salida);

		salidaDatos.writeObject(alumno);

		salidaDatos.close();
	}

	public void CargarAlumno(Scanner entrada) throws IOException {
		if(archivo != null)
		AñadirAlumno(entrada);
		else
			System.err.println("Fichero no está Inicializado, volviendo al Menu");
	}

	public void MostrarAlumnos() {
		if(archivo != null) 
		{
			try (ObjectInputStream entradaDatos = new ObjectInputStream(new FileInputStream(archivo))) {
				while (true) // Bucle infinito para que salga por el catch, no sé si hay otra manera
				{
					try {
						AlumnoEj6 a = (AlumnoEj6) entradaDatos.readObject();

						System.out.println(a.toString());
					}

					catch (EOFException eof) {
						// SALE POR AQUI
						break;
					}
				}
			} catch (Exception e) {
				System.err.println("No se encuentran alumnos");
			}
		}
		else
			System.err.println("No se pueden mostrar alumnos porque no hay archivo correcto seleccionado");
		

	}

}
