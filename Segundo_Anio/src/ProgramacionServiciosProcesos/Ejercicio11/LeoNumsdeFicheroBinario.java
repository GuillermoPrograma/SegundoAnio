package ProgramacionServiciosProcesos.Ejercicio11;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class LeoNumsdeFicheroBinario {
	
	public static void main(String[] args) {
		
		File f = new File("C:\\Users\\alumno\\git\\SegundoAnio2\\Segundo_Anio\\"
				+ "src\\ProgramacionServiciosProcesos\\Ejercicio11\\numeros.dat");
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Dime por cual número quieres empezar :");
		int numEmp = entrada.nextInt();
		System.out.println("En que número quieres acabar");
		int numAcab = entrada.nextInt();
		
		try(InputStream = new DataInputStream(new FileInputStream(f))){}
		for(int i = numEmp; i <= numAcab; i++) 
		{
			
			
		}
		
	}
}
