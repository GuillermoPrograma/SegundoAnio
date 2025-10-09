package ProgramacionServiciosProcesos.Entrega1;

import java.util.Scanner;

/**
 * Clase {@code SumoNum} Suma los dos numeros, los recibe desde
 * {@code Llamador}, esta clase se ejecuta como proceso hijo
 * 
 * @author Guille
 * @version 1.0
 */
public class SumoNum {

	/**
	 * Lee dos números enteros desde el objeto {@link Scanner} leyendo los
	 * aprametros a traves del system.in ya que en la otra clase le he puesto un
	 * print write y no se lo he mandado como parametros de process builder
	 * 
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		try {
			int num1 = entrada.nextInt();
			int num2 = entrada.nextInt();

			System.out.println("El resultado final es : " + (num1 + num2));

		} catch (Exception e) {
			System.err.println("Tienen que ser dos números enteros");
		} finally {
			entrada.close();
		}
	}

}
