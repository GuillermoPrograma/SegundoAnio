package ProgramacionServiciosProcesos.MultiHilos.Ejercicio5;



public class PruebaJoin {

	public static void main(String[] args) throws InterruptedException {
		
		HiloJoin hc = new HiloJoin(1);
		HiloJoin hc2 = new HiloJoin(2);
		System.out.println(hc.getState());
			hc.start();
			System.out.println(hc.getState());
			Thread.sleep(100);              // damos tiempo a que entre en sleep
			System.out.println(hc.getState());
			
			
			
			hc.join();
			System.out.println(hc.getState());
			hc2.start();
			
		
			
	
		System.out.println("Todos los hilos creados");
	}	
	
}
