package ProgramacionServiciosProcesos.MultiHilos.Coordinados.CenaFilosofos;

public class Cubiertos {

	private boolean ocupado;
	private int num;
	
	public Cubiertos(int num) 
	{
		this.num = num;
	}
	
	public synchronized boolean enLaMano() 
	{
		if (ocupado == false) {
            ocupado = true;
            System.out.println(Thread.currentThread().getName() + " coge " + num); //o lo intenta coger o se va
            return true;
        }
		return false;
		
		
	}
	public synchronized boolean soltar() 
	{
		ocupado = false;
		 System.out.println(Thread.currentThread().getName() + " suelta " + num); //o lo intenta coger o se va
		return ocupado;
	}
	public boolean isOcupado() {
		return ocupado;
	}
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	public int getNombre() {
		return num;
	}
	public void setNombre(int num) {
		this.num = num;
	}
	
}
