package ProgramacionServiciosProcesos.MultiHilos.Coordinados.ClienteProductos;

public class ManejoTienda {
public static void main(String[] args) {
	Tienda tienda = new Tienda();
	
	for(int i = 0 ; i < 300; i++) 
	{
		new HiloCliente(i,tienda).start();
	}
}
}
