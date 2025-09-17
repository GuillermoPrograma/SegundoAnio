package ProgramacionServiciosProcesos.EjercicioRepaso1;

public class Gestion_Banco {

	public static void main(String[] args) {

		Usuario usuario1 = new Usuario("0573175G", "Garcia", 68754398);
		Usuario usuario2 = new Usuario("0573175G", "Garcia", 68754398);
		Usuario usuario3 = new Usuario("0573175G", "Garcia", 68754398);
		Usuario usuario4 = new Usuario("0573175G", "Garcia", 68754398);

		Cuenta_Bancaria c1 = new Cuenta_Bancaria("ES89763521", 200, usuario1);

		c1.Anado_usuarios(usuario4);
		for (Usuario u : c1.getTitulares()) {
			System.out.println(u);

		}

		c1.borro_usuarios(usuario4);
		c1.borro_usuarios(usuario1);
	}

}
