package ProgramacionServiciosProcesos.MultiHilos.Coordinados.CenaFilosofos;

import java.util.ArrayList;
import java.util.List;

public class Cena {
	public static void main(String[] args) {

		List<Cubiertos> todosLosCubiertos = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			todosLosCubiertos.add(new Cubiertos(i));
		}

		for (int i = 0; i < 5; i++) {

			List<Cubiertos> cubiertosFilosofo = new ArrayList<>();

			cubiertosFilosofo.add(todosLosCubiertos.get(i)); // izquierdo
			cubiertosFilosofo.add(todosLosCubiertos.get((i + 1) % 5)); // derecho, da resto 1 2 3 4 y en el 5 d resto uno y asi la mesa es redonda

			Filosofo f = new Filosofo(i, cubiertosFilosofo); //no hago notify ni wait porque el filosofo deja los cubiertos
			f.start();
		}

	}
}
