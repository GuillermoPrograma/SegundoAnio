package MovilesRepaso.Ejercicio3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class GestorTareas {

	
	File archivo = new File ("ListaTareas.txt");
	private List<Tarea> tareas = new ArrayList<>();

	public void AgregarTarea(Tarea t1) {
		tareas.add(t1);
	}

	public void eliminarTarea(int index) {

		try {
			tareas.remove(index);
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Index fuera de la lista");
		}
	}

	public void buscarPrioridad(int priori) {
		for (Tarea t : tareas) {
			if (t.getPrioridad() == priori) {
				System.out.println(t.toString());
			}
		}
	}

	public void buscarDescripcion(String palabra) {
		for (Tarea t : tareas) {
			if (t.getDescripcion().contains(palabra)) {
				System.out.println(t.toString());
			}

		}
	}
	public void BuscarcompletoIncompleto(int compl) 
	{
		for(Tarea t: tareas) 
		{
			if(compl == 1 && t.isCompletada() == true) 
			{
				t.toString();
			}
			if(compl == 0 && t.isCompletada() == false) 
			{
				t.toString();
			}
		}
		
		
	}
	public void ImprimirInformacion() 
	{
		try(FileWriter fw = new FileWriter(archivo); PrintWriter pw = new PrintWriter (fw))
		{
			for(Tarea t: tareas)
			pw.println(t.toString());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
