package ProgramacionServiciosProcesos.Ejercicio10;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class LlamoALaMedia {

	public static void main(String[] args) throws IOException {
	Scanner entrada = new Scanner(System.in);
	File f  = new File (".");
	
	Process p = new ProcessBuilder("java","ProgramacionServiciosProcesos.Ejercicio10.MediaNumeros").directory(f).start();
	
	try(PrintWriter pw = new PrintWriter (p.getOutputStream()))
	{
		int numElegido;
		double contadorSuma = 0;
		int contador = 0;
		while((numElegido =entrada.nextInt()) != 0) 
		{
		contador ++;
		contadorSuma += numElegido;
		}
		
		pw.println(contador);
		pw.println(contadorSuma);
		
		InputStream is = p.getInputStream();
		int c;
		while ((c = is.read()) != -1)
		{
			System.out.println((char)c);
		} 
	}
	catch(Exception e) 
	{
		System.err.println("No está bien");
	}
	
	
	
	
	}
	
	
}
