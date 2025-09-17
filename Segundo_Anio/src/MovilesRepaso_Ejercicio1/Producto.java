package MovilesRepaso_Ejercicio1;

public class Producto {

	private String nombre;
	private double precio;
	private int stock;

	Producto(String nombre, double precio, int stock) {
		this.nombre = nombre;
		if (precio < 0 || stock < 0) {
			System.err.println("error");
		} else {
		
			this.precio = precio;
			this.stock = stock;
		}
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", precio=" + precio + ", stock=" + stock + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
