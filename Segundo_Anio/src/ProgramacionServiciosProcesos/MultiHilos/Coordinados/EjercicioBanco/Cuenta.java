package ProgramacionServiciosProcesos.MultiHilos.Coordinados.EjercicioBanco;

public class Cuenta {

	private int saldo;
public Cuenta(int saldo) 
{
	this.saldo = saldo;
}
public int getSaldo() {
	return saldo;
}
public void cambioSaldo(int procesoSaldo) {
	this.saldo = procesoSaldo;
	}

	
}
