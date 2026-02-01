package ProgramacionServiciosProcesos.MultiHilos.Coordinados.CenaFilosofos;

import java.util.ArrayList;
import java.util.List;

public class Filosofo extends Thread {

	private List<Cubiertos> cubiertos = new ArrayList<>();
	private int num;
	private Cubiertos izquierdo;
	private Cubiertos derecho;

	public Filosofo(int num, List<Cubiertos> cubiertos) {
		this.num = num;
		this.cubiertos = cubiertos;
		this.izquierdo = cubiertos.get(0);
		this.derecho = cubiertos.get(1);
	}

	public void run() {
		while (true) {
			if (izquierdo.enLaMano() == true) {
				if (derecho.enLaMano() == true) {
					pensar();
				} else {
					izquierdo.soltar(); // lo suelto y evito el deadlock
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	public void pensar() {
		System.out.println("el filosofo num " + num + " ha comido y se queda pensando");
		izquierdo.soltar();
		derecho.soltar();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
