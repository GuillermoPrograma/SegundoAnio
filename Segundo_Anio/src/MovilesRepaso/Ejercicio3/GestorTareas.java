package MovilesRepaso.Ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class GestorTareas {

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

}
