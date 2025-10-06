package AccesoADatos.Ejercicio5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import AccesoADatos.Ejercicio4.Alumno;

public class AlumnoEntregaBinario {
public static void main(String[] args) throws FileNotFoundException {
	Scanner entrada = new Scanner(System.in);

	Alumno a1 = new Alumno(234567, "Guillermo", "García", 'M', "27/11/2001", "Segundo", "Curso", "A");
	Alumno a2 = new Alumno(987321, "Pilar", "Santos", 'F', "24/03/2003", "Segundo", "Curso", "A");
	Alumno a3 = new Alumno(880212, "Ayoub", "Santos", 'M', "24/03/2006", "Segundo", "Curso", "A");
	Alumno a4 = new Alumno(900000, "Daniel", "Perez", 'M', "24/03/2006", "Segundo", "Curso", "A");
	Alumno a5 = new Alumno(203944, "Cristina", "Martin", 'F', "24/03/2009", "Segundo", "Curso", "A");

	Alumno[] alumnos = { a1, a2, a3, a4, a5 };
	System.out.println("Nombre del Archivo Binario: sin la extension ");
	String nombre = entrada.nextLine();
	System.out.println("Dirección donde vaya el archivo : ");
	String direccion = entrada.nextLine();

	File f = new File(direccion +"\\" + nombre + ".dat");
	
	FileOutputStream salida = new FileOutputStream(f);
	try {
		
		ObjectOutputStream salidaDatos = new ObjectOutputStream (salida);
		for (int i = 0; i < alumnos.length; i++) 
		{
			
			
		}
		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
}
