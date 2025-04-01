package com.example.basededatos2025.database;

public class Cliente {
    //Atributos del cliente
    private int clave;
    private String nombre;
    private float sueldo;

    //constructor vacio


    public Cliente() {
    }
    //contructor sobrecargado

    public Cliente(int clave, String nombre, float sueldo) {
        this.clave = clave;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }
    // Lista de metodos getter y setter

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }
}
