package ProgramacionServiciosProcesos.MultiHilos.Ejercicio9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HiloSumatorio extends Thread {

	int n;
	int num;
	int suma = 0;

	public HiloSumatorio(int n) {
		this.n = n;
	}

	public void run() {

		try (FileReader fr = new FileReader("numeros.dat"); BufferedReader br = new BufferedReader(fr)) {
			String linea;
			int contador = 0;
			while ((linea = br.readLine()) != null) 
			{
				
				num = Integer.parseInt(linea);
				int ini = (n-1)*100;
				int f = n * 100; // si le paso 2 tiene que ir hasta 200 para limite
				if(ini <= contador && f > contador) 
				{
					suma += num;
				}
				
				contador++;
			}

				System.out.println("Suma total del hilo " + n + " es de " + suma);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
