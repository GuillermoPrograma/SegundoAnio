package ProgramacionServiciosProcesos.MultiHilos.Coordinados.Ejercicio2_6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Consumidor extends Thread {

	File f;

	public Consumidor(File f) {
		this.f = f;
	}

	public void run() {
		synchronized (f) {
			LeoInforme();
		}
	}

	private synchronized void LeoInforme() {
		try (FileReader pr = new FileReader(f); BufferedReader br = new BufferedReader(pr)) {
			String linea;

			int contador = 0;
			while (contador < 5) {

				contador++;
				linea = br.readLine();
				System.out.println(linea);
				f.notifyAll();
				try {
					f.wait();
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
