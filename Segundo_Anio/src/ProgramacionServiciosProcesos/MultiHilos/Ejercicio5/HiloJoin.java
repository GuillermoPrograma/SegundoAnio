package ProgramacionServiciosProcesos.MultiHilos.Ejercicio5;

public class HiloJoin extends Thread{
	int c;
	
	public HiloJoin(int c) 
	{
		this.c = c;
		System.out.println("Creando hilo " + c);
	}
	
	
	public void run() 
	{ try {
        Thread.sleep(1000); // <-- TIMED_WAITING
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
		
		for(int i = 0; i <= 5 ; i ++) 
		{
			System.out.println("Hilo " + c + "linea " + i);
		}
		
	}
}
