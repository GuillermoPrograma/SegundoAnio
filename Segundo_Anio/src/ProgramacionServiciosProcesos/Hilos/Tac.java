package ProgramacionServiciosProcesos.Hilos;

public class Tac extends Thread {

	public void imprimo() {
		System.out.println("Tac");
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
