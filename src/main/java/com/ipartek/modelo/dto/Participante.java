package com.ipartek.modelo.dto;

public class Participante {

    int id;
    String nombre;
    String apellidos;
    int edad;

    public Participante() {
	super();
	this.id = 0;
	this.nombre = "";
	this.apellidos = "";
	this.edad = 0;
    }

    public Participante(int id, String nombre, String apellidos, int edad) {
	super();
	this.id = id;
	this.nombre = nombre;
	this.apellidos = apellidos;
	this.edad = edad;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
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

    public int getEdad() {
	return edad;
    }

    public void setEdad(int edad) {
	this.edad = edad;
    }

    @Override
    public String toString() {
	return "participante [nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + "]";
    }

}
