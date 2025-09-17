package MovilesRepaso_Ejercicio2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Conversion {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		int opcion = 0;

		while (opcion != 4) {
			
			try {
				System.out.println("1. Para Metros \n 2. Para Kilos \n 3. Para Euros \n 4.Salir");
				opcion = entrada.nextInt();
				switch (opcion) {
				case 1:
					System.out.println("Introduce Metros para pasar a centimetros");
					double unidad = entrada.nextDouble();
					System.out.println("Son " + metros(unidad) + " Centimetros");

					break;
				case 2:
					System.out.println("Introduce los Kilos para pasarlos a Gramos");
					double unidadkilo = entrada.nextDouble();
					System.out.println("Son " + metros(unidadkilo) + " Gramos");
					break;
				case 3:
					System.out.println("Introduce Euros para pasarlos a Dolares");
					double euro = entrada.nextDouble();
					System.out.println("Son " + dolar(euro) + " Dolares");

					break;
				case 4:

					System.out.println("Saliendo del sistema");
					break;

				}
			} catch (InputMismatchException e) {
				System.out.println("Error");
				entrada.nextLine();
			}
		}

	}

	public static double metros(double centimetros) {

		centimetros = centimetros * 100;
		return centimetros;

	}

	public static double gramos(double kilos) {

		double gramos;
		gramos = kilos * 1000;
		return gramos;
	}

	public static double dolar(double euros) {

		double dolares;
		dolares = euros * 1.08;
		return dolares;
	}
}
