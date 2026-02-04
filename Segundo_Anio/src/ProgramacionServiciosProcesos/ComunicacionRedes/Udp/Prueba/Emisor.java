package ProgramacionServiciosProcesos.ComunicacionRedes.Udp.Prueba;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Emisor {
public static void main(String[] args) throws IOException {
	int puerto = 6000;
	Scanner entrada = new Scanner(System.in);
	DatagramSocket socket = new DatagramSocket();
	String msg ="";
	
	while(!msg.equals("*")) 
	{
		System.out.println("que mensaje mandamos a Udp para que nos lo devuelva en mayusculas");
		 msg = entrada.nextLine();
		 byte[] mensaje = msg.getBytes();
		DatagramPacket paquete = new DatagramPacket(
		    mensaje, mensaje.length,
		    InetAddress.getByName("localhost"), puerto);
		socket.send(paquete);
		
		//ahora recibe
		try {
		byte[] buffer = new byte[1024];
		DatagramPacket recibo = new DatagramPacket(buffer,buffer.length);
		System.out.println("Espero la respuesta...");
		socket.receive(recibo);
		int bytesRec = recibo.getLength();
		String mensajeEnMayus = new String(recibo.getData(),0,bytesRec);
		System.out.println(mensajeEnMayus);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	socket.close();
}
}
