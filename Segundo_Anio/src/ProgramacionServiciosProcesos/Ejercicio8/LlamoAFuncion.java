package ProgramacionServiciosProcesos.Ejercicio8;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

public class LlamoAFuncion {

	public static void main(String[] args) throws IOException {
		
		if(args.length < 2) 
		{
			System.err.println("Dos enteros");
			return;
		}
		
		Process p =  new ProcessBuilder ("java","ProgramacionServiciosProcesos.Ejercicio8.SumoNumero").start();
		
		try(PrintWriter pw = new PrintWriter(p.getOutputStream(), true)) //Si lo hago de esta manera tiene que haber un escaner en la otra clase por el system.in
		{
			pw.println(args[0]);
			pw.println(args[1]);
		}
		try(InputStream is =  p.getInputStream())
		{
			int c;
			while ((c = is.read()) != -1) 
			{
			 System.out.print((char)c); //Leo lo que le pasa el hijo
			}
			
		}
		try(InputStream err =  p.getErrorStream())
		{
			int c;
			while ((c = err.read()) != -1) 
			{
			 System.out.print((char)c); //Leo lo que le pasa si tiene error el hijo
			}
			
		}
		catch(Exception e) 
		{
			System.err.println("No se encuentra");
		}
		
	}
	
	
}
