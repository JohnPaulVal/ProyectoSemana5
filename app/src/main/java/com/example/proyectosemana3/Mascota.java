package com.example.proyectosemana3;

public class Mascota {
    private int foto;
    private String nombre;
    private int valoreRaiting;


    public Mascota(int foto, String nombre, int valoreRaiting) {
        this.foto = foto;
        this.nombre = nombre;
        this.valoreRaiting = valoreRaiting;
    }

    public int getFoto() {
        return foto;
    }

    public String getNombre() {
        return nombre;
    }

    public int getValoreRaiting() {
        return valoreRaiting;
    }


    public void setFoto(int foto) {
        this.foto = foto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setValoreRaiting(int valoreRaiting) {
        this.valoreRaiting = valoreRaiting;
    }
}
