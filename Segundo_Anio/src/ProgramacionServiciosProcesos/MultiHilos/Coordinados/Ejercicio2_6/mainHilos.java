package ProgramacionServiciosProcesos.MultiHilos.Coordinados.Ejercicio2_6;

import java.io.File;

import ProgramacionServiciosProcesos.MultiHilos.Coordinados.Ejercicio1.HiloEscritor;
import ProgramacionServiciosProcesos.MultiHilos.Coordinados.Ejercicio1.HiloLector;

public class mainHilos {

	
public static void main(String[] args) {
		
		File f = new File("NúmerosCheck.txt");
		Object obj = new Object();
		Productor he = new Productor(f);
		Consumidor hl = new Consumidor(f);
	
		
		hl.start();
		he.start();
		
	}
}
