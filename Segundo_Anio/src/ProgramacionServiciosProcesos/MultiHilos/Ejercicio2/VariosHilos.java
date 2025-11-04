package ProgramacionServiciosProcesos.MultiHilos.Ejercicio2;

public class VariosHilos {
	public static void main(String[] args) {
		for (int i = 1; i <= 5; i++) {
			HiloC hc = new HiloC(i);
			hc.start();
			
		}
		System.out.println("Todos los hilos creados");
	}

}
