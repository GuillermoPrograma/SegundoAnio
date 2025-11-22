package DesarrolloDeInterfaces.Swing.EjemploExamen;

public class Empleado {

String genero, otrosIngresos, pueblo, nombre, apellidos ;
Double pagoSeguridadSocial,irpf,salario;


Empleado(String nombre, String apellidos, String pueblo, String genero, String otrosIngresos,
		Double pagoSeguridadSocial, Double irpf, Double salario)
{
	this.nombre = nombre; this.apellidos = apellidos; this.pueblo = pueblo; this.genero = genero; this.otrosIngresos = otrosIngresos;
	this.pagoSeguridadSocial = pagoSeguridadSocial; this.irpf = irpf; this.salario = salario;
}


public String getGenero() {
	return genero;
}


public void setGenero(String genero) {
	this.genero = genero;
}


public String getOtrosIngresos() {
	return otrosIngresos;
}


public void setOtrosIngresos(String otrosIngresos) {
	this.otrosIngresos = otrosIngresos;
}


public String getPueblo() {
	return pueblo;
}


public void setPueblo(String pueblo) {
	this.pueblo = pueblo;
}


public String getNombre() {
	return nombre;
}


public void setNombre(String nombre) {
	this.nombre = nombre;
}


public String getApellidos() {
	return apellidos;
}


public void setApellidos(String apellidos) {
	this.apellidos = apellidos;
}


public Double getPagoSeguridadSocial() {
	return pagoSeguridadSocial;
}


public void setPagoSeguridadSocial(Double pagoSeguridadSocial) {
	this.pagoSeguridadSocial = pagoSeguridadSocial;
}


public Double getIrpf() {
	return irpf;
}


public void setIrpf(Double irpf) {
	this.irpf = irpf;
}


public Double getSalario() {
	return salario;
}


public void setSalario(Double salario) {
	this.salario = salario;
}


@Override
public String toString() {
	return "Empleado [genero=" + genero + ", otrosIngresos=" + otrosIngresos + ", pueblo=" + pueblo + ", nombre="
			+ nombre + ", apellidos=" + apellidos + ", pagoSeguridadSocial=" + pagoSeguridadSocial + ", irpf=" + irpf
			+ ", salario=" + salario + "]";
}
	
}
