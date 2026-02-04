package ProgramacionServiciosProcesos.MultiHilos.Coordinados.EjercicioBanco;

import ProgramacionServiciosProcesos.MultiHilos.Coordinados.Ejercicio1.HiloEscritor;
import ProgramacionServiciosProcesos.MultiHilos.Coordinados.Ejercicio1.HiloLector;

public class Banco {
public static void main(String[] args) throws InterruptedException {
	
	Cuenta c1 = new Cuenta(100);
	
	for(int i = 0; i < 40 ; i++) 
	{
		Proceso p1 = new Proceso (true,100,c1);
		Proceso p2 = new Proceso (false,100,c1);
		p1.start();
		
		p2.start();
		
	}
	
	for(int i = 0; i < 20 ; i++) 
	{
		Proceso p3 = new Proceso (true,50,c1);
		Proceso p4 = new Proceso (false,50,c1);
		p3.start();
		p4.start();
		
	}
	for(int i = 0; i < 60 ; i++) 
	{
		Proceso p5 = new Proceso (true,20,c1);
		Proceso p6 = new Proceso (false,20,c1);
		p5.start();
		p6.start();
		
	}
	
	
	System.out.println("El saldo es :" + c1.getSaldo());
}
}
