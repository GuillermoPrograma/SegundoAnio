package DesarrolloDeInterfaces.Swing.Ejercicio1;

public class Cliente {
private String nombre;
private Localidad localidad;
private String procesador;
private String memoria;
private String discoDuro;
private String opciones[];
Cliente(String nombre, Localidad localidad, String procesador, String memoria, String discoDuro, String opciones[])
{
	this.nombre = nombre;
	this.localidad = localidad;
	this.procesador = procesador;
	this.memoria = memoria;
	this.discoDuro = discoDuro;
	this.opciones = opciones;
	}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public Localidad getLocalidad() {
	return localidad;
}
public void setLocalidad(Localidad localidad) {
	this.localidad = localidad;
}
public String getProcesador() {
	return procesador;
}
public void setProcesador(String procesador) {
	this.procesador = procesador;
}
public String getMemoria() {
	return memoria;
}
public void setMemoria(String memoria) {
	this.memoria = memoria;
}
public String getDiscoDuro() {
	return discoDuro;
}
public void setDiscoDuro(String discoDuro) {
	this.discoDuro = discoDuro;
}
public String[] getOpciones() {
	return opciones;
}
public void setOpciones(String[] opciones) {
	this.opciones = opciones;
}

}
