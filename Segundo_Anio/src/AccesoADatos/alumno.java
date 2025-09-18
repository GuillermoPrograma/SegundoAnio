package AccesoADatos;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

import java.time.format.DateTimeParseException;
import java.util.Comparator;
import java.util.Scanner;

public class alumno {

	private int nia;

	private char genero;

	private String nombre, apellidos, fecha_nac, ciclo, curso, grupo;

	private Scanner entrada = new Scanner(System.in);

	private boolean generoCorrecto = false;


	private static final DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private LocalDate fecha;

	public alumno(int nia, String nombre, String apellidos, char genero, String fecha_Nac, String ciclo, String curso,
			String grupo)

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

	public static class CompararPorNia implements Comparator<alumno> {
		@Override
		public int compare(alumno a1, alumno a2) {
			return Integer.compare(a1.nia, a2.nia);
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

	public String getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(String fecha_nac) {
		this.fecha_nac = fecha_nac;
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

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public Scanner getEntrada() {
		return entrada;
	}

	public void setEntrada(Scanner entrada) {
		this.entrada = entrada;
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
				 + ", ciclo=" + ciclo + ", curso=" + curso + ", grupo= " + grupo
				 + " fecha=" + fecha + "]";
	}

}
