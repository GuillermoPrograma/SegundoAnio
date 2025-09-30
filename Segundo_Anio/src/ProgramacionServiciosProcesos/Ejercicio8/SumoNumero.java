package ProgramacionServiciosProcesos.Ejercicio8;

import java.util.Scanner;

public class SumoNumero {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		try {
			int num1 = entrada.nextInt();
			int num2 = entrada.nextInt();

			System.out.print("El resultado de la suma es :" + (num1 + num2));
		}

		catch (Exception e) {
			System.out.println("Solo se permiten números enteros");
		}
		entrada.close();

	}

}
