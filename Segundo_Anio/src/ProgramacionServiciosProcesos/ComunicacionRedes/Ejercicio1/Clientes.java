package ProgramacionServiciosProcesos.ComunicacionRedes.Ejercicio1;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Clientes {
public static void main(String[] args) throws UnknownHostException, IOException {
	String host = "localhost";
	int puerto = 6000;//puerto remoto
	System.out.println("PROGRAMA CLIENTE INICIADO....");
	Socket cliente = new Socket(host,puerto);
	
}
}
