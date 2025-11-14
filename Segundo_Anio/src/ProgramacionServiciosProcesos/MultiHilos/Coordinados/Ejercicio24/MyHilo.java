package ProgramacionServiciosProcesos.MultiHilos.Coordinados.Ejercicio24;

/**Para suspender de forma segura el hilo se debe introducir en el hilo una vble, por ej, suspender
*y comprobar su valor dentro del método run(), es lo que se hace en la llamada al 
*método esperandoParaReanudar() de este código.
*El método Suspende del hilo da valor true a la variable para suspender el hilo.
*El método Reanuda da el valor false para que detenga la suspensión y continue
*ejecutándose el hilo.
**/

public class MyHilo extends Thread {
	int contador = 0;
	int maximo = 100;
	
	private SolicitaSuspender suspender = new SolicitaSuspender();
	
	public void Suspende() {
		suspender.set(true);//petición de suspender hilo
	}
	public void Reanuda() {
		suspender.set(false);//petición de continuar
	}
	
	public void run (){
		try {
			while (contador <= maximo) {
				
				suspender.esperandoParaReanudar();//comprobar
				System.out.println(contador);
				contador++;
				Thread.sleep(1000);
			}
		}catch (InterruptedException exception) {}
	}

}