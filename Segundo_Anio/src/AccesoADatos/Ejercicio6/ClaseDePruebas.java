package AccesoADatos.Ejercicio6;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.nio.file.Path;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;



class ClaseDePruebas {

	

	  // Con tempDir creo directorio temporal
    @TempDir
    Path temporal; //El path se borra despues de que se haya utilzado

    @Test
    void testCrearYLeerAlumno() throws Exception {
       
        String nombreArchivo = "testAlumnos";
        String ruta = temporal.toString(); //Asi le puedo decir la ruta de donde me lo ha creado

        String datosAlumno = String.join("\n",
            "12345",          
            "Juan",           
            "García",         
            "M",              
            "10/10/2000",     
            "DAM",           
            "2",              
            "B"               
        );
        //Como es una simulación no puedo meterle un Scanner asi que lo simulo junto al input
        String inputSimulado = nombreArchivo + "\n" + ruta + "\n" + datosAlumno + "\n";

        Scanner entrada = new Scanner(new ByteArrayInputStream(inputSimulado.getBytes()));

        GestionFichero gestion1 = new GestionFichero();

       
        gestion1.Generofichero(entrada);

        File fichero = new File(ruta + File.separator + nombreArchivo + ".dat");
        assertTrue(fichero.exists(), "El archivo debe haberse creado");

       
        ByteArrayOutputStream baos = new ByteArrayOutputStream(); //Creo un espacio para la salida del binario
        PrintStream salidaOriginal = System.out; 
        System.setOut(new PrintStream(baos)); 

        gestion1.MostrarAlumnos();

        System.setOut(salidaOriginal); // la salida de la consola es la salida del gestion1 creo(?)

        String salida = baos.toString();

        
        assertTrue(salida.contains("Juan"), "Debe mostrar el nombre del alumno");
        assertTrue(salida.contains("12345"), "Debe mostrar el NIA del alumno");
    }

    @Test
    void testPasoAlumnoABinario() throws Exception {
        // Creo un archivo temporal y un alumno
        GestionFichero gf = new GestionFichero();
        File f = new File(temporal.toFile(), "directo.dat");

        // Usamos reflexión para asignar el archivo (porque es private)
        var field = GestionFichero.class.getDeclaredField("archivo"); //ESTO NO LO ENTIENDO BIEN
        field.setAccessible(true);
        field.set(gf, f);

        AlumnoEj6 alumno = new AlumnoEj6(
                9999, "Ana", "López", 'F', "05/05/2001", "ASIR", "1", "A");

        gf.PasoAlumnoABinario(alumno);

        // Verifico que el archivo contiene un AlumnoEj6
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            Object obj = ois.readObject();
            assertTrue(obj instanceof AlumnoEj6);
            AlumnoEj6 a = (AlumnoEj6) obj;
            assertEquals("Ana", a.getNombre());
            assertEquals('F', a.getGenero());
        }
    }
}
