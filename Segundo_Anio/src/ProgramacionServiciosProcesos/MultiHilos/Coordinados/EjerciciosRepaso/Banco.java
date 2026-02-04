package ProgramacionServiciosProcesos.MultiHilos.Coordinados.EjerciciosRepaso;

public class Banco {

	public static void main(String[] args) throws InterruptedException {
		Cuenta banco = new Cuenta("jose",300.0);
		
		Proceso retiro = new Proceso(false,2000,banco);
		Proceso aniado = new Proceso(true, 20, banco);
		aniado.start();
		aniado.join();
		retiro.start();
		
		
		System.out.println("Cuenta jose" + banco.getSaldo());
	}
	
}
