package ProgramacionServiciosProcesos.MultiHilos.Coordinados.Ejercicio2_6;

import java.io.File;


public class mainHilos {

	
public static void main(String[] args) {
		
		File f = new File("NúmerosCheck.txt");
		
		
			Productor he = new Productor(f);
			Consumidor hl = new Consumidor(f);
			
			
			he.start();
			
			hl.start();
			
			
			
		
		
	}
}
