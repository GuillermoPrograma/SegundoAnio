package ProgramacionServiciosProcesos.MultiHilos.Coordinados.ClienteProductos;

public class Tienda {

int productos = 100;

public synchronized boolean CojoProducto() //Habia que hacer syncronized para que funcionase
{
	
	if(productos > 0) 
	{
		productos--;
		return true;
	}
	else return false;
}
}


