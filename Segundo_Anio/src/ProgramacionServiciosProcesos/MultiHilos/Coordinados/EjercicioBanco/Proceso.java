package ProgramacionServiciosProcesos.MultiHilos.Coordinados.EjercicioBanco;

public class Proceso extends Thread {

	private boolean ingreso;
	private int cantidad;
	private Cuenta cuenta;

	public Proceso(boolean ingreso, int cantidad, Cuenta cuenta) {
		this.ingreso = ingreso;
		this.cantidad = cantidad;
		this.cuenta = cuenta;
	}

	public void run() {
		synchronized (cuenta) {
			if (ingreso == true) {
				int cantidadFinal = cuenta.getSaldo() + cantidad;
				cuenta.cambioSaldo(cantidadFinal);

			} else {
				if (cantidad <= cuenta.getSaldo()) {
					int cantidadFinal = cuenta.getSaldo() - cantidad;
					cuenta.cambioSaldo(cantidadFinal);
				} else {
					System.out.println("Intentas Sacar más dinero del que se puede");
				}

			}
			
		}
	}
}
