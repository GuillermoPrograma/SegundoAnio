package ProgramacionServiciosProcesos.EjercicioRepaso1;

public class Usuario {

	private String dni;
	private String apellidos;
	private double telefono;
	
	Usuario(String dni, String apellidos, double telefono )
	{
		this.dni = dni;
		this.apellidos = apellidos;
		this.telefono = telefono;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public double getTelefono() {
		return telefono;
	}

	public void setTelefono(double telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Usuario [dni=" + dni + ", apellidos=" + apellidos + ", telefono=" + telefono + "]";
	};
	
	
}
