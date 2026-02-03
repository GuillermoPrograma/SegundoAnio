package ProgramacionServiciosProcesos.ComunicacionRedes.Udp.Ejercicio5;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Emisor {
public static void main(String[] args) throws IOException {
	Scanner entrada = new Scanner(System.in);
	DatagramSocket socket = new DatagramSocket();
	byte[] mensaje = entrada.nextLine().getBytes();
	DatagramPacket paquete = new DatagramPacket(mensaje,mensaje.length, InetAddress.getByName("localhost"),6000);
	socket.send(paquete);
	socket.close();
}
}
