package ProgramacionServiciosProcesos.MultiHilos.Ejercicio6;

import ProgramacionServiciosProcesos.MultiHilos.Ejercicio2.HiloC;

public class HilosIndependientes {
	public static void main(String[] args) throws InterruptedException {

		HiloPar hp1 = new HiloPar();
		HiloPar hp2 = new HiloPar();
		
		HiloImpar hi1 = new HiloImpar();
		HiloImpar hi2 = new HiloImpar();
		
		hp1.start();
		hp2.start();
		hi1.start();
		hi2.start();
	}
}
