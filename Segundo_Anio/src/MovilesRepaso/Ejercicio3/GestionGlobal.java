package MovilesRepaso.Ejercicio3;

import java.util.Scanner;

public class GestionGlobal {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int opcion;

		GestorTareas g1 = new GestorTareas();

		do {

			System.out.println("Elige opcion\n"

					+ "1. Agregar una nueva tarea.\n"

					+ "2. Eliminar una tarea (por su número de lista).\n"

					+ "3. Buscar una tarea por prioridad.\n"

					+ "4. Buscar una tarea por descripción.\n"

					+ "5. Buscar una tarea por estado.\n"

					+ "6. Mostrar todas las tareas.\n"

					+ "7. Salir del programa");

			opcion = Integer.parseInt(sc.nextLine());

			switch (opcion) {

			case 1:
				System.out.println("Descripcion");
				String des = sc.nextLine();

				System.out.println("Prioridad");
				int pri = Integer.parseInt(sc.nextLine());

				System.out.println("Hecho si/no");
				String hec = sc.nextLine();
				boolean hecho = hec.equalsIgnoreCase("si");

				if (hec.equals("si"))
					hecho = true;
				if (hec.equals("no"))
					hecho = false;

				Tarea t1 = new Tarea(des, pri, hecho);

				g1.AgregarTarea(t1);

				break;

			case 2:

				g1.eliminarTarea(Integer.parseInt(sc.nextLine()));

				break;

			case 3:

				g1.buscarPrioridad(Integer.parseInt(sc.nextLine()));

				break;

			case 4:

				g1.buscarDescripcion(sc.nextLine());

				break;

			case 5:

				g1.BuscarcompletoIncompleto(Integer.parseInt(sc.nextLine()));

				break;

			case 6:

				g1.toString();

				break;

			case 7:

				System.out.println("Terminado");

				break;

			default:

				System.out.println("Opcion no valida");

				break;

			}

		} while (opcion != 7);
		g1.ImprimirInformacion();
		sc.close();

	}
}
