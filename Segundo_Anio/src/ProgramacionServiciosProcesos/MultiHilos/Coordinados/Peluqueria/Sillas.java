package ProgramacionServiciosProcesos.MultiHilos.Coordinados.Peluqueria;

import java.util.ArrayList;
import java.util.List;

public class Sillas {

	private boolean ocupada = false;
	Cliente c;
	
	
	public synchronized void MeSientoenSilla(Cliente c) 
	{
		
		this.c = c;
		ocupada = true;
		
		
	}
	public synchronized void CortoPelo() 
	{
		System.out.println("el cliente numero " + c.getNumero() + " se ha cortado el pelo");
		MeLevantodeSilla();
	}
	public synchronized void MeLevantodeSilla() 
	{
		ocupada = false;
	}
	public boolean isOcupada() {
		return ocupada;
	}
	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}
	
}
