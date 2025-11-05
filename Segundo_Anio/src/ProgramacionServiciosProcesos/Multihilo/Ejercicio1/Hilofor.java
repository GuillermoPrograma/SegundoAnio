package ProgramacionServiciosProcesos.Multihilo.Ejercicio1;

public class Hilofor extends Thread {

	
	public void run() 
	{
		for(int i = 0; i < 11 ; i++)
		System.out.println("Estoy dentro del hilo");
	}
	
	
	
}
