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
			for (int i = 0; i < 100; i++) {

				linea = br.readLine();
				num = Integer.parseInt(linea);
				if (i < 100) {
					suma += num;

				} else if (i < 200) {
					suma += num;
				}
				else if(i< 300) 
				{
					suma += num;
				}
				esle if()
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
