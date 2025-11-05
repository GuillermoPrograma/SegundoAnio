package ProgramacionServiciosProcesos.MultiHilos.Ejercicio7;

public class LlamoAAreaTriangulo {

	public static void main(String[] args) {
		
		for(int i = 0; i <= 9; i++) 
		{
			int base =(int) (Math.random()*25+1);
			int altura = (int) (Math.random()*25+1);
			HiloTriangulo ht = new HiloTriangulo(base,altura);
			ht.start();
		}
	}
}
