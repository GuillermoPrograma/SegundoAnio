package ProgramacionServiciosProcesos.MultiHilos.Coordinados.Ejercicio1;

import java.io.File;

public class HiloEscritor extends Thread{

	File f;
	
	public HiloEscritor(File f) 
	{
		this.f = f;
		
	}
	
	public void run() {}
	
	public synchronized void escriboArchivo() 
	{
		try(FileWrite fw = new FileWrite(f); PrintWriter pw = new PrintWriter(fw) ){}
	}
	
	
}
