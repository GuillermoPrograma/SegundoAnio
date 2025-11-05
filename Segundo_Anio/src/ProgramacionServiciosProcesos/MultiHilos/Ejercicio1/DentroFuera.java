package ProgramacionServiciosProcesos.MultiHilos.Ejercicio1;

public class DentroFuera {

	
	public static void main(String[] args) {
		Hilofor h1 = new Hilofor();
		h1.start();
		for(int i = 0; i < 11; i++)
		System.out.println("Estoy fuera del hilo");
	}
	
}
