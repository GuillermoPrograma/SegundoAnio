package ProgramacionServiciosProcesos.EjercicioMio;

import java.util.Scanner;

public class MediaACentral {

	public static void main(String[] args) {
	 Scanner entrada = new Scanner(System.in);
	 
	 int num1 = entrada.nextInt();
	 int num2 = entrada.nextInt();
	 
	 int numFinal = (num1 + num2)/2;
	 
	 System.out.println("El resultado de la media es : " + numFinal);
	 
	 entrada.close();
	}
	
}
