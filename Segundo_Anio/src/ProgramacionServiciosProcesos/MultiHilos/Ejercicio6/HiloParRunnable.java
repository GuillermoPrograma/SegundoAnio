package ProgramacionServiciosProcesos.MultiHilos.Ejercicio6;

public class HiloParRunnable implements Runnable {

	 public void run() {
	        for (int i = 1; i <= 10; i++) {
	            if (i % 2 == 0)
	                System.out.println( "Par: " + i);
	        }
	    }

}

class HiloImparRunnable implements Runnable {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 != 0)
                System.out.println("Impar: " + i);
        }
    }
}