package AccesoADatos.Ejercicio4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class AlumnoABinario {

	public static void main(String[] args) throws FileNotFoundException {

		/**
		*@author Guillermo
		*
		*Version 1.0
		*/
		
		
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

		File f = new File(direccion +"\\" + nombre + ".dat"); // Puede fallar

		FileOutputStream salida = new FileOutputStream(f);

		DataOutputStream salidaDatos = null;

		try {
			salidaDatos = new DataOutputStream(salida);
			for (int i = 0; i < alumnos.length; i++) {
				Alumno a = alumnos[i];

				salidaDatos.writeInt(a.getNia());
				salidaDatos.writeUTF(a.getNombre());
				salidaDatos.writeUTF(a.getApellidos());
				salidaDatos.writeChar(a.getGenero());
				salidaDatos.writeUTF(a.getFechaString());
				salidaDatos.writeUTF(a.getCiclo());
				salidaDatos.writeUTF(a.getCurso());
				salidaDatos.writeUTF(a.getGrupo());
				salidaDatos.flush();
			}
			salidaDatos.close();
		}

		catch (Exception e) {
			 e.printStackTrace();
		}
		
		FileInputStream ficheroEntrada = new FileInputStream(f);
		
		DataInputStream entradaDatos = null;
		
		try {
			entradaDatos = new DataInputStream(ficheroEntrada);
			int nia;
			String nombreAl;
			String apellidos;
			char genero;
			String fecha_nac;
			String ciclo;
			String curso;
			String grupo;
			while(entradaDatos.available() > 0) 
			{
				nia = entradaDatos.readInt();
				nombreAl = entradaDatos.readUTF();
				apellidos = entradaDatos.readUTF();
				genero = entradaDatos.readChar();
				fecha_nac = entradaDatos.readUTF();
				ciclo = entradaDatos.readUTF();
				curso = entradaDatos.readUTF();
				grupo = entradaDatos.readUTF();
				System.out.println("NIA : " + nia + "\n" 
				+ "nombreAl : " + nombreAl + "\n" +
				"apellidos : " + apellidos + "\n" +
				"genero : " + genero + "\n" +                                    
				"fecha Nacimiento :" + fecha_nac + "\n" +
				 "Ciclo : " + ciclo + "\n" + 
				"Curso : " + curso + "\n" + 
				 "Grupo : " + grupo);
				
				
			}
			
			ficheroEntrada.close();
			
		} catch (Exception e) {
			System.out.println("Fallo en el archivo");
		}

	}
}
