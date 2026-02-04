package ProgramacionServiciosProcesos.MultiHilos.Coordinados.Ejercicio2_6;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Productor extends Thread {

	File f;

	Productor(File f) {
		this.f = f;
	}
	
	public synchronized void Escribo(File f) 
	{
		try (FileWriter fw = new FileWriter(f); PrintWriter pw = new PrintWriter(fw, true)) {
			int contador = 0;
			while (contador < 5) {

				contador++;
				LocalDateTime ahora = LocalDateTime.now();

				DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
				System.out.println("contador " + contador);
				pw.print(ahora.format(formato));

				pw.flush();
				Thread.sleep(50);
				f.notifyAll();
				

				try {
					f.wait();

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		synchronized (f) {
			
			Escribo(f);
		}

	}

}
