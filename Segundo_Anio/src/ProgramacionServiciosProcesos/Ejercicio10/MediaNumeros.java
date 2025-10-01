package ProgramacionServiciosProcesos.Ejercicio10;

import java.util.Scanner;

public class MediaNumeros {

	public static void main(String[] args) {
		
		
		Scanner entrada = new Scanner(System.in);
		
		int contador = entrada.nextInt();
		int suma = entrada.nextInt();
		
		
		System.out.println("La media es :" + suma / contador);
		
		entrada.close();		
	}
	
	
}
