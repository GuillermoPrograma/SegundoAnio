package ProgramacionServiciosProcesos.MultiHilos.Coordinados.Ejercicio1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HiloEscritor extends Thread{

	File f;
	
	public HiloEscritor(File f) 
	{
		this.f = f;
		
	}
	
	public void run() {}
	
	public synchronized void escriboArchivo() 
	{
		try(FileWriter fw = new FileWriter(f); PrintWriter pw = new PrintWriter(fw) )
		{
			
			
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
