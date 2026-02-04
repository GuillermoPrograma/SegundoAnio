package ProgramacionServiciosProcesos.ComunicacionRedes.Udp.Prueba;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Receptor {
	public static void main(String[] args) {
		try {
			boolean bucle = true;
			int puerto = 6000;
			DatagramSocket socket = new DatagramSocket(puerto);
			while (bucle) {
				byte[] buffer = new byte[1024];
				DatagramPacket recibo = new DatagramPacket(buffer, buffer.length);
				System.out.println("esperando paquete Udp ...");
				socket.receive(recibo); // se queda esperando as que llegue paquete
				int bytesRec = recibo.getLength();
				String mensaje = new String(recibo.getData(), 0, bytesRec);
				System.out.println("Número de bytes recibidos: " + bytesRec);
				System.out.println("Contenido del paquete: " + mensaje);
				System.out.println("Puerto origen: " + recibo.getPort());
				System.out.println("IP origen: " + recibo.getAddress().getHostAddress());
				if (mensaje.equals("*")) {
					bucle = false;
				}

				byte[] mensajeEnMayus = mensaje.toUpperCase().getBytes();
				DatagramPacket paqueteRespuesta = new DatagramPacket(mensajeEnMayus, mensajeEnMayus.length,
						recibo.getAddress(), recibo.getPort());
				socket.send(paqueteRespuesta);
				System.out.println("Respuesta enviada al puerto: " + recibo.getPort());

			}

			socket.close();
		} catch (Exception e) {
		}
	}
}
