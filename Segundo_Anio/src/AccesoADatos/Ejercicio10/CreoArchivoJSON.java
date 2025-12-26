package AccesoADatos.Ejercicio10;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
//import com.google.gson.Gson;

public class CreoArchivoJSON {
	public static void main(String[] args) {
        Map<String, Object> persona = new HashMap<>(); //ES UN DICCIONARIO PARA LLEGAR A UN OBJETO CON OTRO OBJETO
        persona.put("nombre", "Juan");
        persona.put("edad", 25);
        persona.put("lenguajes", new String[]{"Java", "Python", "C++"});
        
        
        
        Gson gson = new Gson();
        String json = gson.toJson(persona);

        System.out.println(json);
        
        try (FileWriter writer = new FileWriter("persona.json")) {
            writer.write(json);
            System.out.println(" Archivo JSON creado correctamente: personas.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
