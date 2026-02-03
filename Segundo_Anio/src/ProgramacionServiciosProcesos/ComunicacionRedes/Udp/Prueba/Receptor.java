package ProgramacionServiciosProcesos.ComunicacionRedes.Udp.Prueba;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receptor {
	public static void main(String[] args) {
		try {
			int puerto = 6000;

			DatagramSocket socket = new DatagramSocket(puerto);

			byte[] buffer = new byte[1024];
			DatagramPacket recibo = new DatagramPacket(buffer, buffer.length);

			System.out.println("esperando paquete Udp ...");

			socket.receive(recibo); //se queda esperando as que llegue paquete

			int bytesRec = recibo.getLength();
			String mensaje = new String(recibo.getData(), 0, bytesRec);

			System.out.println("Número de bytes recibidos: " + bytesRec);
			System.out.println("Contenido del paquete: " + mensaje);
			System.out.println("Puerto origen: " + recibo.getPort());
			System.out.println("IP origen: " + recibo.getAddress().getHostAddress());

			socket.close();
		} catch (Exception e) {
		}
	}
}
