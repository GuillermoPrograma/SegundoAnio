package ProgramacionServiciosProcesos.MultiHilos.Coordinados.ClienteProductos;

public class HiloCliente extends Thread {
	int numCliente;
	int intentos = 0;
	boolean tieneObjeto = false;
	Tienda tienda;

	public HiloCliente(int numCliente, Tienda tienda) {
		this.tienda = tienda;
		this.numCliente = numCliente;
	}

	public void run() {

		boolean entro = false;

		while (!entro && intentos <= 10) {
			synchronized (tienda) { //entraría si está la puerta libre

				if (tienda.CojoProducto() == true) {
					entro = true;
					tieneObjeto = true;
					System.out.println("Cliente numero " + numCliente+ " Ha cogido Producto he ido");
				}
				else 
				{
					System.out.println("Cliente numero " + numCliente+ " Ha entrado pero no tenía producto");
				}


			}
			if(!entro)  //Sino está libre
			{
				intentos++;
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		if(!entro) {System.out.println("Cliente numero " + numCliente +" se ha cansado e ido");}
		

	}
}
