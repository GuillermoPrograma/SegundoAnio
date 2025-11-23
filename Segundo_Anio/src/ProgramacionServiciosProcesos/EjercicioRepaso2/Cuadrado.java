package ProgramacionServiciosProcesos.EjercicioRepaso2;

import java.util.Scanner;

public class Cuadrado {

	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		
		while(entrada.hasNextInt()) 
		{
			int valor = entrada.nextInt();
			
		System.out.println(valor * valor);
			
		}
		
	}
}
