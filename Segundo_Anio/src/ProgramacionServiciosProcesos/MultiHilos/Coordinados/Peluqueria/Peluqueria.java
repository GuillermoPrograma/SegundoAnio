package ProgramacionServiciosProcesos.MultiHilos.Coordinados.Peluqueria;

import java.util.ArrayList;
import java.util.List;

public class Peluqueria {
	static int numeroBarberos = 5;
	static int numSillas = 7;
	static int numClientes = 60;

	public static void main(String[] args) {
		List<Sillas> sillas = new ArrayList<Sillas>();

		InstancioSillas(sillas);
		InstancioBarberos(sillas);
		InstancioClientes(sillas);

	}

	private static void InstancioClientes(List<Sillas> sillas) {
		for (int i = 0; i < numClientes; i++) {
			new Cliente(i, sillas).start();
			;

		}
	}

	private static void InstancioBarberos(List<Sillas> sillas) {
		for (int i = 0; i < numeroBarberos; i++) {
			new HiloBarbero(i, sillas).start();

		}
	}

	private static void InstancioSillas(List<Sillas> sillas) {
		for (int i = 0; i < numSillas; i++) {
			sillas.add(new Sillas());
		}
	}
}
