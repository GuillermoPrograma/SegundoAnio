package AccesoADatos.Ejercicio6;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class AlumnoEj6 implements Serializable {

	private static final long serialVersionUID = 123L;

	private int nia;

	private char genero;

	private String nombre, apellidos, ciclo, curso, grupo;

	private transient Scanner entrada = new Scanner(System.in); //EL TRANSIENT ES PARA QUE NO SE GUARDE EN LA SERIALIZACIÓN

	private boolean generoCorrecto = false;

	private static final DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private LocalDate fecha;

	public AlumnoEj6(int nia, String nombre, String apellidos, char genero, String fecha_Nac, String ciclo,
			String curso, String grupo)

	{

		this.nia = nia;
		this.nombre = nombre;

		this.apellidos = apellidos;

		this.ciclo = ciclo;

		this.curso = curso;

		this.grupo = grupo;

		while (generoCorrecto == false) {

			if (genero == 'M' || genero == 'F' || genero == 'N')

			{

				this.genero = genero;

				this.generoCorrecto = true;

			}

			else

			{

				System.out.println("El genero solo puede ser Masculino- M / Femenino- F / Otros- N");

				genero = entrada.next().charAt(0);

			}

		}

		try

		{

			this.fecha = LocalDate.parse(fecha_Nac, formato);

		}

		catch (DateTimeParseException e)

		{

			System.out.println("Formato invalido");

		}

	}

	public int getNia() {
		return nia;
	}

	public void setNia(int nia) {
		this.nia = nia;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public String getCurso() {
		return curso;
	}

	public String getFechaString() {

		return fecha.format(formato);
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public boolean isGeneroCorrecto() {
		return generoCorrecto;
	}

	public void setGeneroCorrecto(boolean generoCorrecto) {
		this.generoCorrecto = generoCorrecto;
	}

	public DateTimeFormatter getFormato() {
		return formato;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "alumno [nia=" + nia + ", genero=" + genero + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", ciclo=" + ciclo + ", curso=" + curso + ", grupo= " + grupo + " fecha=" + fecha + "]";
	}

}
