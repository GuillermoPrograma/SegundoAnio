package ProgramacionServiciosProcesos.MultiHilos.Coordinados.Ejercicio2;

public class Cuenta {

	double saldo;
	double numero_reintegro = 0;

	Cuenta(double saldo) {
		this.saldo = saldo;

	}

	public void DevolverValorSaldo(double dinero) {
		saldo += dinero;
		numero_reintegro++;
	}

	public void RestoSaldoCantidad(double dinero) {
		if (ComprobarSaldoMenorCantidad(dinero)){
			numero_reintegro++;
			saldo -= dinero;
		}
		else
			System.out.println("Saldo insuficiente");

	}
	
	private boolean ComprobarSaldoMenorCantidad(double dinero) 
	{
		
		if(dinero < saldo) 
		{
		return true;	
		}
		else
		return false;
	}

}
