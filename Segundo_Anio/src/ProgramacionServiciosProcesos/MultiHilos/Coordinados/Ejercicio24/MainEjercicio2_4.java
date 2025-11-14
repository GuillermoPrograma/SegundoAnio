package ProgramacionServiciosProcesos.MultiHilos.Coordinados.Ejercicio24;

import java.util.Scanner;

public class MainEjercicio2_4 {

	

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		
		
		MyHilo h1 = new MyHilo();
		MyHilo h2 = new MyHilo();
		
		h1.Suspende();
		h2.Suspende();
		
		h1.start();
		h2.start();
		
		String comando="";
		
		while(!(comando = entrada.nextLine()).equals("*")) 
		{
			if(comando.equals("R")) 
			{
				h1.Reanuda();
				h2.Suspende();
			}
			if(comando.equals("S")) 
			{
				h2.Reanuda();
				h1.Suspende();
			}
		}
		
	}
}
