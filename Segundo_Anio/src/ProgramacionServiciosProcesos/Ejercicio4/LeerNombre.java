package ProgramacionServiciosProcesos.Ejercicio4;

import java.util.Scanner;

public class LeerNombre {

	public static void main(String[] args) {

		if (args.length < 1) {
			System.exit(-1);
		} else {
			System.out.println("Nombre : " + args[0]);
			System.exit(0);
		}

	}

}
