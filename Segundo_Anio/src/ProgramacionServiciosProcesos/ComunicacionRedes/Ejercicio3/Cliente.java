package ProgramacionServiciosProcesos.ComunicacionRedes.Ejercicio3;

import java.io.BufferedReader;
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
		int puerto = 6000;// puerto remoto
		System.out.println("PROGRAMA CLIENTE INICIADO....");
		Socket cliente = new Socket(host, puerto);

		System.out.println("dime número");
		int num = Integer.parseInt(entrada.nextLine());

		try (BufferedReader br = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
				PrintWriter pw = new PrintWriter(cliente.getOutputStream(), true)) {
			// importante meter en el mismo try el bufferedreader y el printwriter porque
			// sino se cierra el servidor
			pw.println(num);
			pw.flush();

			String linea;
			if ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}

		}
	}
}