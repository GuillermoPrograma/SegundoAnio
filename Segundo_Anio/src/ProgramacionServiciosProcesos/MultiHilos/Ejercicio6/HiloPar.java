package ProgramacionServiciosProcesos.MultiHilos.Ejercicio6;

public class HiloPar extends Thread {

	public void run() {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0)
                System.out.println(  "Par: " + i);
        }
    }
	
}

class HiloImpar extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 != 0)
                System.out.println(" Impar: " + i);
        }
    }
}