package ProgramacionServiciosProcesos.MultiHilos.Ejercicio9;

import ProgramacionServiciosProcesos.MultiHilos.Ejercicio8.HiloPitufo;

public class ManejoHilosSumatorio {

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			HiloSumatorio hs = new HiloSumatorio(i);
			hs.start();
	}
	
	
	}
}
