package ProgramacionServiciosProcesos.EjercicioRepaso1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Cuenta_Bancaria {

	private String numCuentas;
	private double saldo;
	private ArrayList<Usuario> titulares = new ArrayList<>();
	Scanner entrada = new Scanner(System.in);

	Cuenta_Bancaria(String numCuentas, double saldo, Usuario usuario) {
		this.numCuentas = numCuentas;
		this.saldo = saldo;
		Anado_usuarios(usuario); 
	}

	ArrayList<Usuario> Anado_usuarios(Usuario usuario) {
		if (titulares.size() < 3)
			titulares.add(usuario);
		else
			System.err.println("Solo hasta 3 personas están en la cuenta");

		return titulares;
	}

	void borro_usuarios(Usuario usuario) {
		if (titulares.size() > 1) {
			Iterator<Usuario> it;
			it = titulares.iterator();
			while (it.hasNext()) {
				Usuario u = it.next();
				if (u.equals(usuario))
					it.remove();
			}
		}
		else
			System.err.println("Solo tienes un usuario en esta cuenta");
	}

	public void IngresarDinero() {
		System.out.println("¿Cuanto dinero quieres ingresar?");
		double dineroAIngresar = entrada.nextDouble();
		saldo += dineroAIngresar;
		System.out.println("Tienes de Saldo " + this.saldo + " euros");

	}

	public void RetirarDinero() {
		System.out.println("Tienes un Saldo de " + this.saldo + "\n");
		System.out.println("¿Cuanto dinero quieres retirar?");
		double dineroARetirar = entrada.nextDouble();
		if (this.saldo <= dineroARetirar) {
			this.saldo -= dineroARetirar;
		} else
			System.out.println("No hay suficiente dinero");

	}

	public String getNumCuentas() {
		return numCuentas;
	}

	public double getSaldo() {
		return saldo;
	}

	public ArrayList<Usuario> getTitulares() {
		return titulares;
	}

}
