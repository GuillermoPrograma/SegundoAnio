package ProgramacionServiciosProcesos.Ejercicio5;

import java.util.Scanner;

public class Divisores {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Numero para encontrar divisores");
		int num = entrada.nextInt();
		
		for(int i = 1; i < num; i++) 
		{
			if(num % i == 0)
				System.out.println(i);
		}
		entrada.close();
	}
	
}
