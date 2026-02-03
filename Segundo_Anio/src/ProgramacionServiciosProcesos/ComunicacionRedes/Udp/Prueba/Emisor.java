package ProgramacionServiciosProcesos.ComunicacionRedes.Udp.Prueba;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Emisor {
public static void main(String[] args) throws IOException {
	DatagramSocket socket = new DatagramSocket();
	byte[] mensaje = "Hola UDP".getBytes();
	DatagramPacket paquete = new DatagramPacket(
	    mensaje, mensaje.length,
	    InetAddress.getByName("localhost"), 6000
	);
	socket.send(paquete);
	socket.close();
}
}
