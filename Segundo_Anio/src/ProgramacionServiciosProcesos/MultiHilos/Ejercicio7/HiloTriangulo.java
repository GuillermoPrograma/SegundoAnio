package ProgramacionServiciosProcesos.MultiHilos.Ejercicio7;

public class HiloTriangulo extends Thread{

	int base;
	int altura;
	public HiloTriangulo(int base, int altura) 
	{
		this.base = base;
		this.altura = altura;
	}
	
	public void run() 
	{
		System.out.println("Este hilo tiene una base de " + base + " centimetros y una altura de " + altura + " centimetros tiene un resultado de " +(base * altura)/2 + "centimetrosCuadrados");
		
	}
	
}
