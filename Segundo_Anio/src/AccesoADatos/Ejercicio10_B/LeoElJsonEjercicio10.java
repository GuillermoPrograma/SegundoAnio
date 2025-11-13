package AccesoADatos.Ejercicio10_B;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class LeoElJsonEjercicio10 {
	public static void main(String[] args) { // El JSON no puede leer de uno en uno hay que hacer array

		Gson gson = new Gson();
		List<Map<String, Object>> alumnosLista = new ArrayList<>();
		LeoJSON(gson);
	}

	private static void LeoJSON(Gson gson) {
		try (FileReader reader = new FileReader("Ejercicio10.json")) {

			Map[] alumnos = gson.fromJson(reader, Map[].class); //METO TODOS EN UNA ARRAY DE MAPS Y LUEGO CON EL FOR EACH DESGLOSO
			for (Map alumno : alumnos) {
				System.out.println("Nombre " + alumno.get("Nombre"));
				System.out.println("Apellidos " + alumno.get("Apellidos"));
				System.out.println("Nia " + alumno.get("Nia"));
				System.out.println("Genero " + alumno.get("Genero"));
				System.out.println("Fecha " + alumno.get("Fecha"));
				System.out.println("Ciclo " + alumno.get("Ciclo"));
				System.out.println("Curso " + alumno.get("Curso"));
				System.out.println("Grupo " + alumno.get("Grupo"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
