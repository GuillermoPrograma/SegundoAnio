package AccesoADatos.Ejercicio11;

import java.util.ArrayList;
import java.util.List;

public class GrupoEjercicio12 {
	private static final long serialVersionUID = 123L;
	private int id;
	private String nombre;
	private List  <AlumnoEjercicio11> alumnos;
	public GrupoEjercicio12(int idGrupo, String nombreGrupo) {
        this.id = idGrupo;
        this.nombre = nombreGrupo;
        this.alumnos = new ArrayList<>();
    }
	 public void agregarAlumno(AlumnoEjercicio11 alumno) {
	        if (!alumnos.contains(alumno)) { 
	            alumnos.add(alumno);
	        }
	    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<AlumnoEjercicio11> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(List<AlumnoEjercicio11> alumnos) {
		this.alumnos = alumnos;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
