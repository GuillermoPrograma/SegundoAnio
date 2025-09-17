package MovilesRepaso_Ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class inventarioApp {

	public static void main(String[] args) {
		List<Producto> productos = new ArrayList<>();

		Producto p1 = new Producto("Botellas", 20, 200);
		Producto p2 = new Producto("Pilas", 1, 300);
		Producto p3 = new Producto("Ordenador", 300, 20);
		Producto p4 = new Producto("Kleenex", 2, 400);
		Producto p5 = new Producto("Mechero", 1, 50);

		productos.add(p1);
		productos.add(p2);
		productos.add(p3);
		productos.add(p4);
		productos.add(p5);
		int preciototal = 0;
		for (Producto p : productos) {
			System.out.println(p.toString());
			preciototal += (p.getPrecio() * p.getStock());

		}
		System.out.println("Precio total es = " + preciototal);
	}

}
