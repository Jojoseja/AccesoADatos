package Tema1Ejer3;

import java.io.*;
import java.nio.file.Path;
import java.rmi.server.ExportException;
import java.util.ArrayList;

public class Ejercicio11 {
    public static void main(String[] args) {
        Plato plato01 = new Plato("Carbonara", "Italia", 500, 13.99f, false);
        Plato plato02 = new Plato("ArrozconCurry", "Japon", 400, 11.99f, false);
        Plato plato03 = new Plato("Ensalada", "Mediterraneo", 200, 6.99f, true);
        Plato plato04 = new Plato("Biryani", "India/Pakistan", 300, 9.99f, true);

        ArrayList<Plato> platos = new ArrayList<>();

        Plato plato05 = new Plato("Paella", "Valencia", 400, 15.99f, true);

        platos.add(plato01);
        platos.add(plato02);
        platos.add(plato03);
        platos.add(plato04);

        Path archivoCSV = Path.of("src", "Tema1Ejer3", "plato.csv");
        String ruta = "src/Tema1Ejer3/plato.csv";
        File f2 = new  File(ruta);
        File file = new File(archivoCSV.toString());
        //escribirCSV(file);
        //writeToCSV(file, platos);
        //writeFinalCSV(file, plato05);
        //readCSV(file);

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(f2))){
            for (Plato temp : platos) {
                bw.write(temp.toCSV() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Ejercicio 12
    public static void writeFinalCSV(File archivo, Plato p){
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(archivo, true)))) {
            StringBuffer linea = new StringBuffer();
            String CSVSeparator = ";";
            linea.append(p.nombre);
            linea.append(CSVSeparator);
            linea.append(p.origen);
            linea.append(CSVSeparator);
            linea.append(p.calorias);
            linea.append(CSVSeparator);
            linea.append(p.precio);
            linea.append(CSVSeparator);
            linea.append(p.aptoCeliacos);
            out.write(linea.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void readCSV(File archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] linea = line.split(";");
                StringBuilder builder = new StringBuilder();
                builder.append("Nombre: ").append(linea[0]).append(", ");
                builder.append("Origen: ").append(linea[1]).append(", ");
                builder.append("Calorias: ").append(linea[2]).append(", ");
                builder.append("Precio: ").append(linea[3]).append(", ");
                builder.append("AptoCeliacos: ").append(linea[4]);

                System.out.println(builder);


            }
        } catch (Exception e) {

        }
    }

    public static void writeToCSV(File archivo, ArrayList<Plato> lista){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Plato p : lista) {
                String CSVSeparator = ";";
                StringBuffer linea = new StringBuffer();
                linea.append(p.nombre);
                linea.append(CSVSeparator);
                linea.append(p.origen);
                linea.append(CSVSeparator);
                linea.append(p.calorias);
                linea.append(CSVSeparator);
                linea.append(p.precio);
                linea.append(CSVSeparator);
                linea.append(p.aptoCeliacos);
                bw.write(linea.toString());
                bw.newLine();

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static class Plato {
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

        public String toCSV(){
            return this.nombre + ";" + this.origen + ";" + this.calorias + ";" + this.precio + ";" + this.aptoCeliacos;
        }
    }
}
