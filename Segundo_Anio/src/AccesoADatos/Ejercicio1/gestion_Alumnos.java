package AccesoADatos.Ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class gestion_Alumnos {

	public static void main(String[] args) {
		int input = 0;
		boolean bucle = true;
		Scanner entrada = new Scanner(System.in);

		alumno a1 = new alumno(234567, "Guillermo", "García", 'M', "27/11/2001", "Segundo", "Curso", "A");
		alumno a2 = new alumno(987321, "Pilar", "Santos", 'F', "24/03/2003", "Segundo", "Curso", "A");
		alumno a3 = new alumno(880212, "Ayoub", "Santos", 'M', "24/03/2006", "Segundo", "Curso", "A");
		alumno a4 = new alumno(900000, "Daniel", "Perez", 'M', "24/03/2006", "Segundo", "Curso", "A");
		alumno a5 = new alumno(203944, "Cristina", "Martin", 'F', "24/03/2009", "Segundo", "Curso", "A");

		List<alumno> listado = new ArrayList<>();

		listado.add(a1);
		listado.add(a2);
		listado.add(a3);
		listado.add(a4);
		listado.add(a5);
		while (bucle == true) {
			System.out.println(
					"1-Mostrar Alumnos \n 2.Añadir Alumno \n  3.Ordenar por Nia \n 4. Ordenar por otras opciones \n 5.Salir");
			input = entrada.nextInt();
			switch (input) {
			case 1:
				for (alumno a : listado)
					System.out.println(a.toString());
				System.out.println();
				break;
			case 2:
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
				listado.add(
						new alumno(niaNuevo, nombreNuevo, apellidoNuevo, generoNuevo, fechaNuevo, ciclo, curso, grupo));
				break;
			case 3:
				listado.sort(new alumno.CompararPorNia());
				for (alumno a : listado)
					System.out.println(a.toString());
				break;
			case 4:
				System.out.println("6-Ordenar por fecha \n 7-Ordenar por Ciclo");
				int input2 = entrada.nextInt();
				switch (input2) {
				case 6:
					listado.sort(new alumno.CompararPorFecha());
					for (alumno a : listado)
						System.out.println(a.toString());
					break;
				case 7:
					listado.sort(new alumno.CompararPorCiclo());
					for (alumno a : listado)
						System.out.println(a.toString());
					break;
				}
				break;

			case 5:
				System.out.println("Saliendo del sistema");
				bucle = false;
			}

		}
		entrada.close();
	}

}
