package ProgramacionServiciosProcesos.Hilos;

public class Ejercicio2_1 extends Thread{

	
	
	public static void main(String[] args) {
		int contador = 0;
		while(contador <= 10) 
		{
			
			Tic tic = new Tic();
			Tac tac = new Tac();
			
			tic.start();
			tac.start();
			contador++;
			
			
				
			
		}
		
		
			}
	
	
}
