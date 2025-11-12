package AccesoADatos.Ejercicio10_B;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class LeoElJsonEjercicio10 {
	public static void main(String[] args) {

		Gson gson = new Gson();
		List<Map<String, Object>> alumnosLista = new ArrayList<>();

		try (FileReader reader = new FileReader("persona.json")) {
			
			alumnosLista = gson.fromJson(reader, Map<String, Object>);

			for (Map<String, Object> alumno : alumnosLista) {
				

				System.out.println("Nombre: " + alumno.get("nombre"));
				System.out.println("Edad: " + alumno.get("edad"));
				System.out.println("Lenguajes: " + alumno.get("lenguajes"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
