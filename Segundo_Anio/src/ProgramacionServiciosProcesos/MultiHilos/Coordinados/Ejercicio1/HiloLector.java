package ProgramacionServiciosProcesos.MultiHilos.Coordinados.Ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HiloLector extends Thread {
	Object lock;
	File f;
	static int contador = 0;

	public HiloLector(File f, Object lock) {
		this.f = f;
		this.lock = lock;
	}

	public void run() {

		leoArchivo(f);

	}

	public void leoArchivo(File f) {
		synchronized (lock) {
			try (FileReader pr = new FileReader(f); BufferedReader br = new BufferedReader(pr)) {

				for (int i = 0; i <= 1000; i++) {
					String linea = br.readLine();

					if (Integer.parseInt(linea) == contador) {
						System.out.println("Numero :" + contador + " Correcto");
					} else {
						System.out.println("Numero :" + contador + " Incorrecto");
					}
					contador++;
					lock.notify();
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
