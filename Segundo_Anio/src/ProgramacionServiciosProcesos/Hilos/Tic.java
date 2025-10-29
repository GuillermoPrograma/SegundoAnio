package ProgramacionServiciosProcesos.Hilos;

public class Tic extends Thread{

	
	
	public void imprimo()  
	{
		System.out.println("Tic");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void run() {
		this.imprimo();
	}
}
