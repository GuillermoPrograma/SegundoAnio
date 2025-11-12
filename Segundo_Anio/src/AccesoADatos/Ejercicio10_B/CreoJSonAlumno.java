package AccesoADatos.Ejercicio10_B;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.Gson;

import AccesoADatos.Ejercicio7.AlumnoEjercicio7;

public class CreoJSonAlumno {
	public static void main(String[] args) {
     int  numalumnos = 2;
     
     
     List<Map<String, Object>> alumnosLista = new ArrayList<>();
     
     
     for(int i = 0; i < numalumnos; i++ ) 
     {
    	 AlumnoEjercicio10 al = CrearAlumnos() ;
    	 alumnosLista.add(PonerAlumnoJSON(al)); //Meto todos los mapas en el el alumno
         
     }
     
     EscriboElJSON(alumnosLista);
      
  }

	private static Map<String, Object> PonerAlumnoJSON(AlumnoEjercicio10 a) {
		 Map<String, Object> alumno = new HashMap<>(); //ES UN DICCIONARIO PARA LLEGAR A UN OBJETO CON OTRO OBJETO
		
		 alumno.put("Nia", a.getNia());
		 alumno.put("Apellidos", a.getApellidos());
		 alumno.put("Genero", a.getGenero());
		 alumno.put("Fecha", a.getFechaString());
		 alumno.put("Ciclo", a.getCiclo());
		 alumno.put("Curso", a.getCurso());
		 alumno.put("Grupo", a.getGrupo());
		 
		 
		 return alumno;
	}

	private static void EscriboElJSON(List<Map<String, Object>> alumnosLista) {
		try (FileWriter writer = new FileWriter("Ejercicio10.json")) {
	          
	          Gson gson = new Gson();
	          String json = gson.toJson(alumnosLista);
	          writer.write(json);
	          System.out.println(json);
	          System.out.println(" Archivo JSON creado correctamente: personas.json");
	      } catch (IOException e) {
	          e.printStackTrace();
	      }
	}
	
	public static AlumnoEjercicio10 CrearAlumnos() 
	{
		Scanner entrada = new Scanner(System.in);
		System.out.println("Nia del nuevo alumno");
		int niaNuevo = Integer.parseInt(entrada.nextLine()); 
		System.out.println("Nombre del nuevo alumno");
		String nombreNuevo = entrada.nextLine().trim();
		System.out.println("Apellido del nuevo alumno");
		String apellidoNuevo = entrada.nextLine().trim();
		System.out.println("Genero del Nuevo alumno (M/F/N)");
		char generoNuevo = entrada.nextLine().trim().toUpperCase().charAt(0);
		System.out.println("Fecha Nac dd/MM/yyyy");
		String fechaNuevo = entrada.nextLine().trim();
		System.out.println("Ciclo del nuevo alumno");
		String ciclo = entrada.nextLine().trim();
		System.out.println("Curso del nuevo alumno");
		String curso = entrada.nextLine().trim();
		System.out.println("Grupo del nuevo alumno");
		String grupo = entrada.nextLine().trim();
		return new AlumnoEjercicio10(niaNuevo, nombreNuevo, apellidoNuevo, generoNuevo, fechaNuevo, ciclo, curso, grupo);

	}

}
