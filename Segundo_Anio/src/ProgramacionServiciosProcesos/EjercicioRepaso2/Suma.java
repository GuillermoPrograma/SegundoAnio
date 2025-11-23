package ProgramacionServiciosProcesos.EjercicioRepaso2;

import java.util.Scanner;

public class Suma {
	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		int num;
		int numSumaDef = 0;
		while(entrada.hasNextInt()) 
		{
			num = entrada.nextInt();
			numSumaDef += num;
		}
		
		System.out.println(numSumaDef);
	}
}
