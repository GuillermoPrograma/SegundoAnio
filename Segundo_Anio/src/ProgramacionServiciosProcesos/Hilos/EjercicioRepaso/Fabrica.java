package ProgramacionServiciosProcesos.Hilos.EjercicioRepaso;

public class Fabrica {
	public static void main(String[] args) {

		Thread r1 = new Thread(new Robot(1));
		Thread r2 = new Thread(new Robot(2));
		Thread r3 = new Thread(new Robot(3));

		Thread[] robot = { r1, r2, r3 };

		for(int i = 0; i < robot.length; i++) 
		{
			robot[i].start();
			System.out.println(robot[i].getState());
			try {
				robot[i].join();
				 
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		System.out.println("Han acabado todos");
	}
}
