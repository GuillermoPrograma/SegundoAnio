package ProgramacionServiciosProcesos.ComunicacionRedes.Ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class Servidor {
    public static void main(String[] args) throws IOException {
        int puerto = 6000;
        ServerSocket servidor = new ServerSocket(puerto, 1);
        System.out.println("Servidor escuchando en el puerto " + puerto);

        Socket cliente = servidor.accept();
        System.out.println("Cliente conectado: " + cliente.getRemoteSocketAddress());

        try (BufferedReader br = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
             PrintWriter pw = new PrintWriter(cliente.getOutputStream(), true)) { // auto-flush

            String linea = br.readLine(); // solo una línea
            if (linea != null) {
                pw.println(linea.toUpperCase());
            }
        }

        cliente.close();
        servidor.close();
    }
}
