package AccesoADatos.Ejercicio6;

import java.util.Scanner;

public class Menu {
	public static void main(String[] args) {
		boolean bucle = true;

		while (bucle == true) {
			Scanner entrada = new Scanner(System.in);
			System.out.println("1-Genera fichero vacío y añadir alumno \n" + "2-Selecciona un fichero \n"
					+ "3-Cargar Alumno (Fichero en uso) \n" + "4-Mostrar Alumnos (Fichero en uso) \n"
					+ "5-Salir del sistema");
			int numMenu = entrada.nextInt();

			switch (numMenu) {
			case 1:

				break;
			case 2:

				break;
			case 3:

				break;

			case 4:

				break;
			case 5:
				System.out.println("Saliendo del sistema");
				entrada.close();
				break;
			default:
				System.out.println("No coincide con ninguna opción, vuelve a elegir");

				break;
			}
		}

	}
}
