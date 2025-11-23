package ProgramacionServiciosProcesos.Hilos.EjercicioRepaso;

public class Robot implements Runnable {

	int num;
	int contador = 0;
	boolean acabado = false;
	Robot(int num)
	{
		this.num =num;
	}
	@Override
	public void run() {
		
		try {
			
			while(acabado == false) 
			{
				Thread.sleep((int)Math.random() * (50 - 5 + 1) + 5);
				System.out.println("Esamblaje pieza " + contador +"Hecha por Robot" + num);
				contador++;
				if(contador == 3) 
				{
					System.out.println("Robot " + num + "Se apaga");
					acabado = true;
				}
			}
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
