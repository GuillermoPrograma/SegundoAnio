package ProgramacionServiciosProcesos.MultiHilos.Coordinados.Ejercicio2_6;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Productor extends Thread {

	File f;

	public void run() 
	{
		synchronized(f)
		{
			try(FileWriter fw = new FileWriter(f);PrintWriter pw = new PrintWriter(fw, true))
			{
				
				LocalDateTime ahora = LocalDateTime.now();

		        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
				
				pw.print(ahora.format(formato));
				
				pw.flush();
				
				f.notify();
				
				try {
					f.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
}

