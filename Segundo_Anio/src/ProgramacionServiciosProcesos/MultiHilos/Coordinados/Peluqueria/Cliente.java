package ProgramacionServiciosProcesos.MultiHilos.Coordinados.Peluqueria;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Thread {
	private int numero;

	List<Sillas> sillasLista = new ArrayList<>();

	public Cliente(int numero, List<Sillas> sillas) {
		this.numero = numero;
		this.sillasLista = sillas;
	}

	public void run() {
		for (Sillas silla : sillasLista) { //Si sincronizo la lista se pararía la peluqueria todo el rato
				synchronized (silla) {
				if (silla.isOcupada() == false) {
					silla.MeSientoenSilla(this);
					silla.notifyAll(); //pongo el notifyAll porque el notify puede despertar a un cliente
					break;
				}
				
			}
		}

	}

	public int getNumero() {
		return numero;
	}

}
