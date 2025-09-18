package ProgramacionServiciosProcesos.Ejercicio2;

public class personaje {

	String nombre;
	String especie;
	String planeta;
	String bando;

	personaje(String nombre, String especie, String planeta, String bando)
	{
		this.nombre = nombre;
		this.especie = especie;
		this.planeta = planeta;
		this.bando = bando;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getPlaneta() {
		return planeta;
	}

	public void setPlaneta(String planeta) {
		this.planeta = planeta;
	}

	public String getBando() {
		return bando;
	}

	public void setBando(String bando) {
		this.bando = bando;
	}

	@Override
	public String toString() {
		return "personaje [nombre=" + nombre + ", especie=" + especie + "]";
	}
	
	
	
}
