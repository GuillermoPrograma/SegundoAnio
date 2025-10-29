package DesarrolloDeInterfaces.Swing.Ejercicio1;

import java.util.List;

public class Venta {
private String nombre;
private Localidad localidad;
private String procesador;
private String memoria;
private String discoDuro;
private List<String> opciones;
Venta(String nombre, Localidad localidad, String procesador, String memoria, String discoDuro, List<String> opciones)
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
public List<String> getOpciones() {
	return opciones;
}
public void setOpciones(List<String> opciones) {
	this.opciones = opciones;
}
@Override
public String toString() {
	return "Cliente [nombre=" + nombre + ", localidad=" + localidad + ", procesador=" + procesador + ", memoria="
			+ memoria + ", discoDuro=" + discoDuro + ", opciones=" + opciones + "]";
}


}
