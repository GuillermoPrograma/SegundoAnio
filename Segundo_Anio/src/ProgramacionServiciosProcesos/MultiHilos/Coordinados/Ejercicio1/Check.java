package ProgramacionServiciosProcesos.MultiHilos.Coordinados.Ejercicio1;

import java.io.File;

public class Check {

	
	public static void main(String[] args) {
		
		File f = new File("NúmerosCheck.txt");
		Object obj = new Object();
		HiloEscritor he = new HiloEscritor(f,obj);
		HiloLector hl = new HiloLector(f,obj);
	
		
		hl.start();
		he.start();
		
	}
	
	
	
}
