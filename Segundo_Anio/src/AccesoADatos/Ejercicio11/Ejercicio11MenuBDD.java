package AccesoADatos.Ejercicio11;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.Gson;

public class Ejercicio11MenuBDD {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		File archivo = new File("AlumnosEjercicio11.dat");

		boolean bucle = true;
		List<AlumnoEjercicio11> listaAlumnos = new ArrayList();
		while (bucle) {

			System.out.println("1- Insertar un nuevo alumno.\r\n" + "\n"
					+ "2- Mostar todos los alumnos (en consola).\r\n" + "\n"
					+ "3- Guardar todos los alumnos en un fichero (formato binario).\r\n" + "\n"
					+ "4- Leer alumnos de un fichero (con el formato anterior), y guardarlo en una BD.\r\n" + "\n"
					+ "5- Modificar el nombre de un alumno guardado en la base de datos a partir de su NIA.\r\n" + "\n"
					+ "6- Eliminar un alumno a partir de su (PK).\r\n" + "\n"
					+ "7- Eliminar los alumnos que su apellido contengan la palabra dada por el usuario.\r\n" + "\n"
					+ "8- Guardar todos los alumnos en un fichero XML o JSON.\r\n" + "\n"
					+ "9- Leer un fichero XML o JSON de alumnos (con en formato anterior) y guardarlos en la BD."
					+ "\n");
			
			
			int numEleg = entrada.nextInt();
			switch (numEleg) {
			case (1):
				listaAlumnos.add(CrearAlumnos());
				break;
			case (2):
				LlamoAlumnos(listaAlumnos);
				break;
			case (3):
				MetoAlumnosEnBinario(listaAlumnos, archivo);
				break;
			case (4):
				LeoObjetoBinario(archivo);
				break;
			case (5):
				System.out.println("Dime el nia del alumno que buscas");
				int elegirNia = entrada.nextInt();
				ModificoNombre(elegirNia);
				break;
			case (6):
				System.out.println("Dime el nia del alumno que buscas eliminar");
				int elegirNiaRemove = entrada.nextInt();
				eliminoAlumno(elegirNiaRemove);
				break;
			case (7):
				System.out.println(
						"Apellido que quieres eliminar (Se eliminarán todos los apellidos que contengan esa secuencia)");
				String apellidoElegir = entrada.next();
				eliminoPorApellido(apellidoElegir);
				break;
			case (8):
				BuscoAlumnoParaJson();
				break;
			case (9):
				LeoJSON();
				break;
			default:
				bucle = false;
				System.out.println("Se cierra el Sistema");
				break;
			}
		}

	}

	private static void eliminoPorApellido(String apellido) {
		String sql = "Delete from alumnosEjercicio11 where Apellidos Like ?";
		try (Connection conexion = ConexionBDD(); PreparedStatement ps = conexion.prepareStatement(sql)) {

			ps.setString(1, "%" + apellido + "%");

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void eliminoAlumno(int nia) {
		String sql = "Delete from alumnosEjercicio11 where Nia=?";
		try (Connection conexion = ConexionBDD(); PreparedStatement ps = conexion.prepareStatement(sql)) {
			ps.setInt(1, nia);
			ps.executeUpdate();
			System.out.println("Se ha borrado el alumno con Nia :" + nia);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void ModificoNombre(int nia) {
		String sql = "Update alumnosEjercicio11 set Nombre=? where Nia=?";

		try (Connection conexion = ConexionBDD(); PreparedStatement ps = conexion.prepareStatement(sql)) {
			Scanner entrada = new Scanner(System.in);

			System.out.println("Dime a que nombre quieres cambiar");
			String nombre = entrada.nextLine();
			ps.setString(1, nombre);
			ps.setInt(2, nia);

			int filasActualizadas = ps.executeUpdate();
			System.out.println("Filas actualizadas: " + filasActualizadas);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static Connection ConexionBDD() {
		// Cargar el driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Establecemos la conexión con la BD en nuestro servidor local con el usuario y
			// la password
			return DriverManager.getConnection("jdbc:mysql://localhost/ejercicio11", "root", "Manager");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	private static void LeoObjetoBinario(File archivo) {
		try (ObjectInputStream entradaDatos = new ObjectInputStream(new FileInputStream(archivo))) {

			while (true) // Bucle infinito para que salga por el catch, no sé si hay otrta manera
			{
				try {
					AlumnoEjercicio11 a = (AlumnoEjercicio11) entradaDatos.readObject();

					InsertoAlumnoBasedeDatos(a);
				}

				catch (EOFException eof) {
					// SALE POR AQUI
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Archivo no inicializado");
		}
	}

	private static void InsertoAlumnoBasedeDatos(AlumnoEjercicio11 a) {
		String sql = "Insert Into alumnosEjercicio11 VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection conexion = ConexionBDD(); PreparedStatement ps = conexion.prepareStatement(sql)) {

			ps.setInt(1, a.getNia());
			ps.setString(2, a.getNombre());
			ps.setString(3, a.getApellidos());
			ps.setString(4, String.valueOf(a.getGenero()));

			ps.setDate(5, Date.valueOf(a.getFecha()));
			ps.setString(6, a.getCiclo());
			ps.setString(7, a.getCurso());
			ps.setString(8, a.getGrupo());

			ps.executeUpdate();

			conexion.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void MetoAlumnosEnBinario(List<AlumnoEjercicio11> listaAlumnos, File archivo) {

		try (FileOutputStream salida = new FileOutputStream(archivo);
				ObjectOutputStream salidaDatos = new ObjectOutputStream(salida);) {

			for (AlumnoEjercicio11 a : listaAlumnos)
				salidaDatos.writeObject(a);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void LlamoAlumnos(List<AlumnoEjercicio11> listaAlumnos) {
		for (AlumnoEjercicio11 a : listaAlumnos)
			System.out.println(a);
	}

	public static AlumnoEjercicio11 CrearAlumnos() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Nia del nuevo alumno");
		int niaNuevo = Integer.parseInt(entrada.nextLine());
		System.out.println("Nombre del nuevo alumno");
		String nombreNuevo = entrada.nextLine().trim();
		System.out.println("Apellido del nuevo alumno");
		String apellidoNuevo = entrada.nextLine().trim();
		System.out.println("Genero del Nuevo alumno (M/F/N)");
		char generoNuevo = entrada.nextLine().trim().toUpperCase().charAt(0);
		System.out.println("Fecha Nac yyyy-MM-dd");
		String fechaNuevo = entrada.nextLine().trim();
		System.out.println("Ciclo del nuevo alumno");
		String ciclo = entrada.nextLine().trim();
		System.out.println("Curso del nuevo alumno");
		String curso = entrada.nextLine().trim();
		System.out.println("Grupo del nuevo alumno");
		String grupo = entrada.nextLine().trim();
		return new AlumnoEjercicio11(niaNuevo, nombreNuevo, apellidoNuevo, generoNuevo, fechaNuevo, ciclo, curso,
				grupo);

	}

	private static void BuscoAlumnoParaJson() {
		String sql = "select Nia,Nombre,Apellidos,Genero,Fecha,Ciclo,Curso,Grupo from alumnosejercicio11";
		try (Connection conexion = ConexionBDD();
				PreparedStatement ps = conexion.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			List<Map<String, Object>> alumnosLista = new ArrayList<>();
			while (rs.next()) {
				Map<String, Object> alumno = new HashMap<>();
				alumno.put("Nia", rs.getInt("Nia"));
				alumno.put("Nombre", rs.getString("Nombre"));
				alumno.put("Apellidos", rs.getString("Apellidos"));
				alumno.put("Genero", rs.getString("Genero"));
				alumno.put("Fecha", rs.getDate("Fecha").toString());
				alumno.put("Ciclo", rs.getString("Ciclo"));
				alumno.put("Curso", rs.getString("Curso"));
				alumno.put("Grupo", rs.getString("Grupo"));
				alumnosLista.add(alumno);
			}
			EscriboElJSON(alumnosLista);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void EscriboElJSON(List<Map<String, Object>> alumnosLista) {
		try (FileWriter writer = new FileWriter("Ejercicio11.json")) {

			Gson gson = new Gson();
			String json = gson.toJson(alumnosLista);
			writer.write(json);
			System.out.println(json);
			System.out.println(" Archivo JSON creado correctamente: personas.json");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void LeoJSON() {

		try (FileReader reader = new FileReader("Ejercicio11.json")) {
			Gson gson = new Gson();
			Map[] alumnos = gson.fromJson(reader, Map[].class); // METO TODOS EN UNA ARRAY DE MAPS Y LUEGO CON EL FOR
																// EACH DESGLOSO
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
