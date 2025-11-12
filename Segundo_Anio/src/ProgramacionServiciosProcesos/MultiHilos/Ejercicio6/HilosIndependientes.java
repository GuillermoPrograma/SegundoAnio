package ProgramacionServiciosProcesos.MultiHilos.Ejercicio6;

public class HilosIndependientes {
	public static void main(String[] args) throws InterruptedException {

		HiloPar hp1 = new HiloPar();
		HiloImpar hi1 = new HiloImpar();

		hp1.start();
		hi1.start();

	}
}
