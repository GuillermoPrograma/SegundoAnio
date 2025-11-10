package DesarrolloDeInterfaces.Swing.Entrega1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Factura {

	String asunto;
	
	int dia; int mes; int año;
	private double cantidad;
	private String tipo;

	public Factura(String asunto, int dia, int mes, int año, double cantidad, String tipo ) 
	{
		this.asunto = asunto;
		this.dia = dia;
		this.mes = mes;
		this.año = año;
		this.cantidad = cantidad;
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return  asunto +":"+ tipo + ":" + cantidad + ":" +año +"-" + mes +"-" + dia ;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
}
