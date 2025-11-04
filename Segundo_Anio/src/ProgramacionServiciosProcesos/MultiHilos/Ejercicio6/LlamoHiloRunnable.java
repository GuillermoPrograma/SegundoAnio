package ProgramacionServiciosProcesos.MultiHilos.Ejercicio6;

public class LlamoHiloRunnable {

	
	public static void main(String[] args) {
		
		Thread par1 = new Thread(new HiloParRunnable());
        Thread par2 = new Thread(new HiloParRunnable());
        Thread imp1 = new Thread(new HiloImparRunnable());
        Thread imp2 = new Thread(new HiloImparRunnable());

        par1.start();
        par2.start();
        imp1.start();
        imp2.start();
	}
}
