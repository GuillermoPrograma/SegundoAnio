package ProgramacionServiciosProcesos.MultiHilos.Ejercicio6;

public class LlamoHiloRunnable {

	
	public static void main(String[] args) {
		
		Thread par1 = new Thread(new HiloParRunnable());
       
        Thread imp1 = new Thread(new HiloImparRunnable());
     

        par1.start();
    
        imp1.start();
        
	}
}
