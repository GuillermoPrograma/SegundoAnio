package ProgramacionServiciosProcesos.ComunicacionRedes.Ejercicio2;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Scanner entrada = new Scanner(System.in);
		String host = "localhost";
		int puerto = 6000;//puerto remoto
		System.out.println("PROGRAMA CLIENTE INICIADO....");
		Socket cliente = new Socket(host,puerto);
		
		System.out.println("dime texto");
		String texto = entrada.nextLine();
		
		try(PrintWriter pw = new PrintWriter (cliente.getOutputStream()))
		{
			pw.println(texto);
		}
		
		try(BufferedReader br = new BufferedReader (new InputStreamReader(cliente.getInputStream())))
		{
			
		}
		
	}
}
