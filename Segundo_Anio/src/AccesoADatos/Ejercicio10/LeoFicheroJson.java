package AccesoADatos.Ejercicio10;
import com.google.gson.Gson;
import java.io.FileReader;
import java.util.Map; 

public class LeoFicheroJson {
	 public static void main(String[] args) {
		
		 Gson gson = new Gson();
		 
		 try (FileReader reader = new FileReader("persona.json")) {
	         
	            Map persona = gson.fromJson(reader, Map.class);

	            System.out.println("Nombre: " + persona.get("nombre"));
	            System.out.println("Edad: " + persona.get("edad"));
	            System.out.println("Lenguajes: " + persona.get("lenguajes"));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
