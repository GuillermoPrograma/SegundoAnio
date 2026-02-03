package ProgramacionServiciosProcesos.ComunicacionRedes.Ejercicio4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
public static void main(String[] args) throws UnknownHostException, IOException {
	int puerto = 6000;
	String host = "localhost";
	System.out.println("Cliente iniciado");
	Socket Cliente = new Socket(host,puerto);
	
	try(BufferedReader br = new BufferedReader(new InputStreamReader(Cliente.getInputStream())))
	{
		String linea;
		if((linea = br.readLine()) != null)
		{
			System.out.println(linea);
		}
	}
}
}
