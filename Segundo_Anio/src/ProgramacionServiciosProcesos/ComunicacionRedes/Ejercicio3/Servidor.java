package ProgramacionServiciosProcesos.ComunicacionRedes.Ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) throws IOException {
		int puerto = 6000;
		ServerSocket servidor = new ServerSocket(puerto, 1);
		System.out.println("Servidor escuchando en el puerto " + puerto);

		Socket cliente = servidor.accept();
		System.out.println("Cliente conectado: " + cliente.getRemoteSocketAddress());

		try (BufferedReader br = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
				PrintWriter pw = new PrintWriter(cliente.getOutputStream(), true)) { // auto-flush
			String num = br.readLine();
			System.out.println(num);
			if ((num) != null) 
			{

				int numero = Integer.parseInt(num);
				System.out.println("Pasa de aqui");
				int numeroCuadrado = numero * numero;
				pw.println(numeroCuadrado);
			}
				

		}

		cliente.close();
		servidor.close();
	}
}
