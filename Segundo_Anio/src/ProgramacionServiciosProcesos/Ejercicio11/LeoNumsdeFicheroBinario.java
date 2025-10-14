package ProgramacionServiciosProcesos.Ejercicio11;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeoNumsdeFicheroBinario {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		File f = new File("C:\\Users\\alumno\\git\\SegundoAnio2\\Segundo_Anio\\"
				+ "src\\ProgramacionServiciosProcesos\\Ejercicio11\\numeros.dat");
		Scanner entrada = new Scanner(System.in);
		int contadorSuma = 0;

		try {
			if (!f.exists()) {
				throw new FileNotFoundException("Fichero no existe");
			}

			System.out.println("Dime por cual número quieres empezar :");
			int numEmp = entrada.nextInt();
			System.out.println("En que número quieres acabar");
			int numAcab = entrada.nextInt();

			try (DataInputStream entradaDatos = new DataInputStream(new FileInputStream(f))) {
				if (numEmp < numAcab) {
					List<Integer> numerosBinarios = new ArrayList<>();
					while (entradaDatos.available() > 0) {
						numerosBinarios.add(entradaDatos.readInt());
					}

					for (int i = numEmp - 1; i <= numAcab; i++) {
						contadorSuma += numerosBinarios.get(i);

					}
				} else {
					System.out.println("El primer número no puede ser mayor al segundo");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} finally {
			System.out.println("El resultado es : " + contadorSuma);
			entrada.close();
		}

	}
}
