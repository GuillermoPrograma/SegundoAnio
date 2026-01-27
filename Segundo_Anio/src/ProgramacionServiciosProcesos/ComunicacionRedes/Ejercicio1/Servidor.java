package ProgramacionServiciosProcesos.ComunicacionRedes.Ejercicio1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException {
		int Puerto = 6000;// Puerto
		ServerSocket Servidor = new ServerSocket(Puerto,2);
		System.out.println("Escuchando en " + Servidor.getLocalPort());
		Socket cliente1= Servidor.accept();//esperando a un cliente
		System.out.println("puerto local es de cliente1" +cliente1.getLocalPort());
		//realizar acciones con cliente1
		Socket cliente2 = Servidor.accept();//esperando a otro cliente
		System.out.println("puerto local es de cliente2" +cliente2.getLocalPort());
		//realizar acciones con cliente2
		Servidor.close(); //cierro socket servidor
	}
}
