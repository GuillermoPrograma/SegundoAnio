package ProgramacionServiciosProcesos.MultiHilos.Coordinados.Ejercicio1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HiloEscritor extends Thread {
	Object lock;
	File f;
	int contador = 0;

	public HiloEscritor(File f, Object lock) {
		this.f = f;
		this.lock = lock;
	}

	public void run() {
		try { Thread.sleep(50); } catch (InterruptedException e) {}
		escriboArchivo(lock);

	}

	public void escriboArchivo(Object lock) {

		try (FileWriter fw = new FileWriter(f); PrintWriter pw = new PrintWriter(fw)) {
			for (int i = 0; i <= 1000; i++) {
				synchronized (lock) {
					pw.println(contador);
					pw.flush();
					contador++;
					lock.notify();
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
