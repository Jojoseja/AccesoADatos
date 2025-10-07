package Tema1Ejer4;

import java.io.*;
import java.util.ArrayList;

public class Plato implements Externalizable {
    private String nombre;
    private String origen;
    private int calorias;
    private float precio;
    private boolean aptoCeliacos;
    // Añadido para el ejercicio 3
    private static final long SerialVersionUID = 2;
    private String fecha;

    // Para usar externalizable se requiere de un constructor sin argumentos
    public Plato() {
    }

    public Plato(String nombre, String origen, int calorias, float precio, boolean aptoCeliacos, String fecha) {
        this.nombre = nombre;
        this.origen = origen;
        this.calorias = calorias;
        this.precio = precio;
        this.aptoCeliacos = aptoCeliacos;
        this.fecha = fecha;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Plato{" +
                "nombre='" + nombre + '\'' +
                ", origen='" + origen + '\'' +
                ", calorias=" + calorias +
                ", precio=" + precio +
                ", aptoCeliacos=" + aptoCeliacos +
                ", fecha='" + fecha + '\'' +
                '}';
    }

    // Modificado para el ejercicio 3
    public String toCSV(){
        return this.nombre + ";" + this.origen + ";" + this.calorias + ";" + this.precio + ";" + this.aptoCeliacos + ";" + this.fecha;
    }


//    Ejercicio 1
//    public void escribirObjeto(String path) throws IOException {
//        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(path, true))) {
//            dos.writeUTF(this.getNombre());
//            dos.writeUTF(this.getOrigen());
//            dos.writeInt(this.getCalorias());
//            dos.writeFloat(this.getPrecio());
//            dos.writeBoolean(this.isAptoCeliacos());
//        }
//    }

//  Ejercicio 3 - ej1Modificado
    public void escribirObjeto(String path) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(path, true))) {
            dos.writeUTF(this.getNombre());
            dos.writeUTF(this.getOrigen());
            dos.writeInt(this.getCalorias());
            dos.writeFloat(this.getPrecio());
            dos.writeBoolean(this.isAptoCeliacos());
            //Añadido fecha
            dos.writeUTF(this.getFecha());
        }
    }

//    Ejercicio 2 -> Escribir Lista de Objetos
//    public static void escribirObjeto(ArrayList<Plato> platos, String path) throws IOException {
//        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(path, true))) {
//            for (Plato plato : platos) {
//                dos.writeUTF(plato.getNombre());
//                dos.writeUTF(plato.getOrigen());
//                dos.writeInt(plato.getCalorias());
//                dos.writeFloat(plato.getPrecio());
//                dos.writeBoolean(plato.isAptoCeliacos());
//            }
//        }
//    }

//  Ejercicio 3 -> Ej2 Modificado
    public static void escribirObjeto(ArrayList<Plato> platos, String path) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(path, true))) {
            for (Plato plato : platos) {
                dos.writeUTF(plato.getNombre());
                dos.writeUTF(plato.getOrigen());
                dos.writeInt(plato.getCalorias());
                dos.writeFloat(plato.getPrecio());
                dos.writeBoolean(plato.isAptoCeliacos());
                // Añadido campo Fecha
                dos.writeUTF(plato.getFecha());
            }
        }
    }
//    Ejercicio 3 -> Leer Objetos de archivo binario
//    public static ArrayList<Plato> leerObjeto(String path) throws IOException {
//        ArrayList<Plato> platos = new ArrayList<>();
//        try (DataInputStream dis = new DataInputStream(new FileInputStream(path))) {
//            while (dis.available() > 0) {
//                String nombre = dis.readUTF();
//                String origen = dis.readUTF();
//                int calorias = dis.readInt();
//                float precio = dis.readFloat();
//                boolean aptoCeliacos = dis.readBoolean();
//                Plato plato = new Plato(nombre,  origen, calorias, precio, aptoCeliacos);
//                platos.add(plato);
//            }
//        }
//        return platos;
//    }

    //Ejercicio 3 -> Modificación del Ej2
    public static ArrayList<Plato> leerObjeto(String path) throws IOException {
        ArrayList<Plato> platos = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream(new FileInputStream(path))) {
            while (dis.available() > 0) {
                String nombre = dis.readUTF();
                String origen = dis.readUTF();
                int calorias = dis.readInt();
                float precio = dis.readFloat();
                boolean aptoCeliacos = dis.readBoolean();
                String fecha = dis.readUTF();
                Plato plato = new Plato(nombre, origen, calorias, precio, aptoCeliacos, fecha);
                platos.add(plato);
            }
        }
        return platos;
    }

    // Ejercicio 4
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(this.getNombre());
        out.writeUTF(this.getOrigen());
        out.writeInt(this.getCalorias());
        out.writeFloat(this.getPrecio());
        out.writeBoolean(this.isAptoCeliacos());
        out.writeUTF(this.getFecha());
    }

    // Ejercicio 4
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        nombre = in.readUTF();
        origen = in.readUTF();
        calorias = in.readInt();
        precio = in.readFloat();
        aptoCeliacos = in.readBoolean();
        fecha = in.readUTF();
    }

    // Ejercicio 4 -> Usar Externalizable -> En vez de DataOutputStream usar ObjectOutputStream
    public void escribirObjeto4(String path) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path, true))) {
            oos.writeObject(this);
        }
    }
    // Ejercicio 4
    public static void escribirObjeto4(ArrayList<Plato> platos, String path) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path, true))) {
            for (Plato plato : platos) {
                oos.writeObject(plato);
            }
        }
    }
    // Ejercicio 4
    public static ArrayList<Plato> leerObjeto4(String path) throws IOException, ClassNotFoundException {
        ArrayList<Plato> platos = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            while (true) {
                Plato plato;
                plato = (Plato)ois.readObject();
                platos.add(plato);
            }
        }
        catch (EOFException e) {
            System.out.println(e.getMessage());
        }
        return platos;
    }
}
