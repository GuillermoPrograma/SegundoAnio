package ProgramacionServiciosProcesos.MultiHilos.Ejercicio8;

public class LlamoPitufoHilo {
	public static void main(String[] args) {
		String[] pitufos = { "Papá pitufo", "Pitufina", "Filósofo", "Pintor", "Gruñón", "Bromista", "Dormilón",
				"Tímido", "Tontín", "Bonachón", "Romántico" };

		for (int i = 0; i < pitufos.length; i++) {
			HiloPitufo hp = new HiloPitufo(pitufos[i]);
			hp.start();
		}
	}

}
