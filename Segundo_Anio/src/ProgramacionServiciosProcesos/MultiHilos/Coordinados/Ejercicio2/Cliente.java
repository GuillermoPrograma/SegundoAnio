package ProgramacionServiciosProcesos.MultiHilos.Coordinados.Ejercicio2;

public class Cliente implements Runnable {

	Cuenta cuenta;
	int cantidad;
	int total;
	Cliente(Cuenta cuenta, int cantidad, int total)
	{
		this.cuenta = cuenta;
		this.cantidad = cantidad;	
		this.total = total;
	}
	@Override
	public void run() {
		
		cuenta.RestoSaldoCantidad(cantidad);
		
		
		
	}
	
	
}
