package Tema1Ejer4;

import java.io.*;

public class Plato {
    private String nombre;
    private String origen;
    private int calorias;
    private float precio;
    private boolean aptoCeliacos;

    public Plato(String nombre, String origen, int calorias, float precio, boolean aptoCeliacos) {
        this.nombre = nombre;
        this.origen = origen;
        this.calorias = calorias;
        this.precio = precio;
        this.aptoCeliacos = aptoCeliacos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public boolean isAptoCeliacos() {
        return aptoCeliacos;
    }

    public void setAptoCeliacos(boolean aptoCeliacos) {
        this.aptoCeliacos = aptoCeliacos;
    }

    public String toCSV(){
        return this.nombre + ";" + this.origen + ";" + this.calorias + ";" + this.precio + ";" + this.aptoCeliacos;
    }

    public void escribirObjeto(String path) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(path))) {
            dos.writeUTF(this.getNombre());
            dos.writeUTF(this.getOrigen());
            dos.writeInt(this.getCalorias());
            dos.writeFloat(this.getPrecio());
            dos.writeBoolean(this.isAptoCeliacos());
        }
    }
}
