package ProgramacionServiciosProcesos.ComunicacionRedes.Udp.Ejercicio5;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receptor {
	public static void main(String[] args) throws IOException {
		int puerto = 6000;
		DatagramSocket socket = new DatagramSocket(puerto);
		byte[] buffer = new byte[1024];
		DatagramPacket recibido = new DatagramPacket(buffer,buffer.length);
		System.out.println("esperando paquete");
		socket.receive(recibido);
		String mensaje = new String (recibo.)
		
	}
}
