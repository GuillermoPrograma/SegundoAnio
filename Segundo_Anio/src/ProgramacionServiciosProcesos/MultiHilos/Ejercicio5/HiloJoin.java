package ProgramacionServiciosProcesos.MultiHilos.Ejercicio5;

public class HiloJoin {
	int c;
	
	public HiloJoin(int c) 
	{
		this.c = c;
		System.out.println("Creando hilo " + c);
	}
	
	
	public void run() 
	{
		for(int i = 0; i <= 5 ; i ++) 
		{
			System.out.println("Hilo " + c + "linea " + i);
		}
		
	}
}
