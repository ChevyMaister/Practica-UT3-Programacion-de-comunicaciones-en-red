package org.educa.game;

public class Jugador {
    private String nombre;
    private String direccion;
    private int puerto;

    public Jugador(String nombre, String direccion, int puerto) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.puerto = puerto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }
}
