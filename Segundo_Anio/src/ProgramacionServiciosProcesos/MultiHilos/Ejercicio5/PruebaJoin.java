package ProgramacionServiciosProcesos.MultiHilos.Ejercicio5;

import ProgramacionServiciosProcesos.MultiHilos.Ejercicio2.HiloC;

public class PruebaJoin {

	public static void main(String[] args) throws InterruptedException {
		for (int i = 1; i <= 5; i++) {
			HiloC hc = new HiloC(i);
			hc.start();
			hc.join();
		}
		System.out.println("Todos los hilos creados");
	}	
	
}
