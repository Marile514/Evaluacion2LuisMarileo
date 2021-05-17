package com.example.evaluacion2luismarileo;

public class Producto {
    private String ID;
    private String nombre;
    private String tipo;
    private String estado;

    public Producto(String ID, String nombre, String tipo, String estado) {
        this.ID = ID;
        this.nombre = nombre;
        this.tipo = tipo;
        this.estado = estado;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
