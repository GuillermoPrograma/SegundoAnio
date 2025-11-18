package ProgramacionServiciosProcesos.MultiHilos.Coordinados.Ejercicio2;

public class Cuenta {

	double saldo;
	double numero_reintegro = 0;

	Cuenta(double saldo) {
		this.saldo = saldo;

	}

	private void DevolverValorSaldo(double dinero) {
		saldo += dinero;
		numero_reintegro++;
	}

	private void RestoSaldoCantidad(double dinero) {
		if (dinero < saldo) {
			numero_reintegro++;
			saldo -= dinero;
		}
		else
			System.out.println("Saldo insuficiente");

	}
	
	private void ComprobarSaldoMenorCantidad(double saldo, double dinero) 
	{
		if(sa)
	}

}
