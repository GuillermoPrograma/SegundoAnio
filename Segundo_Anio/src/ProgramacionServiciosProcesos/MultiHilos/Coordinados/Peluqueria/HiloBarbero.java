package ProgramacionServiciosProcesos.MultiHilos.Coordinados.Peluqueria;

import java.util.ArrayList;
import java.util.List;

public class HiloBarbero extends Thread {

	Sillas silla;
	private int numero;

	List<Sillas> sillasLista = new ArrayList<>();

	public HiloBarbero(int numero, List<Sillas> sillas) {
		this.numero = numero;
		this.sillasLista = sillas;
	}

	public void run() {
		while (true)// Que no pare aunque me parece raro meter dos whiles(?){
			for (Sillas silla : sillasLista) { // Si sincronizo la lista se pararía la peluqueria todo el rato
				synchronized (silla) {
					while (!silla.isOcupada())
						try {
							silla.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					System.out.println("Soy el peluquero " + numero + "Chop Chop Chop");
					try {
						Thread.sleep(3000);
						silla.CortoPelo();
						silla.notifyAll();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}
	}

}
