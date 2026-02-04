package ProgramacionServiciosProcesos.MultiHilos.Coordinados.EjerciciosRepaso;

public class Proceso extends Thread {

	private boolean ingreso;
	private double dinero;
	private Cuenta cuenta;

	public Proceso(boolean ingreso, double dinero, Cuenta cuenta) {
		this.ingreso = ingreso;
		this.dinero = dinero;
		this.cuenta = cuenta;
	}

	public void run() {
		synchronized (cuenta) {
			if (ingreso == true) {
				cuenta.setSaldo(cuenta.getSaldo() + dinero);
			} else {
				if (dinero > cuenta.getSaldo()) {
					System.err.println("No hay tanto dinero en la cuenta");
				} else {
					cuenta.setSaldo(cuenta.getSaldo() - dinero);
				}
			}
		}

	}

}
