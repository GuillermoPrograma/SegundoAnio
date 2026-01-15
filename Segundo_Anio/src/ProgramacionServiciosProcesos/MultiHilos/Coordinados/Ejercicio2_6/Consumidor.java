package ProgramacionServiciosProcesos.MultiHilos.Coordinados.Ejercicio2_6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Consumidor {

	File f;

	public Consumidor(File f) {
		this.f = f;
	}

	public void run() {
		synchronized (f) {
			try (FileReader pr = new FileReader(f); BufferedReader br = new BufferedReader(pr)) {
				
				try {
					f.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
