package ProgramacionServiciosProcesos.MultiHilos.Ejercicio8;

public class HiloPitufo extends Thread {

	String nombre;
	int vezComida;

	public HiloPitufo(String nombre) {
		this.nombre = nombre;
	}

	public void run() {
		for (int i = 1; i <= 3; i++) {
			vezComida++;
			System.out.println(nombre + "Se come un " + vezComida + "º Pan con queso");
		}

		System.out.println(nombre + "ha acabado de comer");

	}
}
