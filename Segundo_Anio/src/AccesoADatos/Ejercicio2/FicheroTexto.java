package AccesoADatos.Ejercicio2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FicheroTexto {

	public static void main(String[] args) {

		try (FileReader pr = new FileReader("src/AccesoADatos/Ejercicio2/Texto.txt"); BufferedReader br = new BufferedReader(pr)) {
			String linea;
			while((linea =br.readLine()) != null) 
			{
				System.out.println(linea);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
