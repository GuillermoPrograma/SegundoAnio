package AccesoADatos.Ejercicio4;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

import AccesoADatos.Ejercicio1.alumno;

public class AlumnoABinario {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner entrada = new Scanner(System.in);
		
		alumno a1 = new alumno(234567, "Guillermo", "García", 'M', "27/11/2001", "Segundo", "Curso", "A");
		alumno a2 = new alumno(987321, "Pilar", "Santos", 'F', "24/03/2003", "Segundo", "Curso", "A");
		alumno a3 = new alumno(880212, "Ayoub", "Santos", 'M', "24/03/2006", "Segundo", "Curso", "A");
		alumno a4 = new alumno(900000, "Daniel", "Perez", 'M', "24/03/2006", "Segundo", "Curso", "A");
		alumno a5 = new alumno(203944, "Cristina", "Martin", 'F', "24/03/2009", "Segundo", "Curso", "A");

		alumno [] alumnos = {a1,a2,a3,a4,a5};
		System.out.println("Nombre del Archivo Binario: sin la extension ");
		String nombre = entrada.next();
		System.out.println("Dirección donde vaya el archivo : ");
		String direccion = entrada.next();
		
		File f = new File(direccion + nombre + ".dat"); //Puede fallar
	
		FileOutputStream salida = new FileOutputStream(f,true);
			
		DataOutputStream salidaDatos = null;
	
		try 
		{
			salidaDatos = new DataOutputStream(salida);
			for(int i = 1; i <= 6; i++) 
			{
				alumno a = alumnos[i];
				
				salidaDatos.writeInt(a.getNia());
				
			}
		}
		catch(Exception e) 
		{
			
		}
		
	}
}
