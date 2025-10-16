package AccesoADatos.Ejercicio6;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
	
	public static void main(String[] args) throws IOException {
		Scanner entrada = new Scanner(System.in);
		boolean bucle = true;
		GestionFichero gestion1 = new GestionFichero();
		while (bucle == true) {
			
			System.out.println("1-Genera fichero vacío y añadir alumno \n" + "2-Selecciona un fichero \n"
					+ "3-Cargar Alumno (Fichero en uso) \n" + "4-Mostrar Alumnos (Fichero en uso) \n"
					+ "5-Salir del sistema");
			int numMenu = entrada.nextInt();
			entrada.nextLine();

			switch (numMenu) {
			case 1:
				gestion1.Generofichero(entrada);
				break;
			case 2:
				gestion1.CargarFichero(entrada);
				break;
			case 3:
				gestion1.CargarAlumno(entrada);
				break;

			case 4:
				gestion1.MostrarAlumnos();
				break;
			case 5:
				System.out.println("Saliendo del sistema");
				entrada.close();
				System.exit(0);
			default:
				System.out.println("No coincide con ninguna opción, vuelve a elegir");

				break;
			}
		}

	}
}
