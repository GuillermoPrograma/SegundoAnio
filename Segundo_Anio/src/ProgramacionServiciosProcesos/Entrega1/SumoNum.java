package ProgramacionServiciosProcesos.Entrega1;

import java.util.Scanner;

public class SumoNum {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		try {
			int num1 = entrada.nextInt();
			int num2 = entrada.nextInt();

			System.out.println("El resultado final es : " + (num1 + num2));
			entrada.close();
		} catch (Exception e) {
			System.err.println("Tienen que ser dos números enteros");
		}
	}

}
