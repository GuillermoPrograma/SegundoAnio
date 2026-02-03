package ProgramacionServiciosProcesos.ComunicacionRedes.Ejercicio4;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
public static void main(String[] args) throws IOException {
	int num = 1;
	int puerto = 6000;
	boolean activo = true;
	
	System.out.println("servidor escuchando puerto");
	while(activo)
	{
		try(ServerSocket servidor = new ServerSocket(puerto,4);
				Socket cliente= servidor.accept();
				PrintWriter pw = new PrintWriter(cliente.getOutputStream(),true);)
			{
				pw.println(num);
				num++;
			}
	}
	
	
}
}
