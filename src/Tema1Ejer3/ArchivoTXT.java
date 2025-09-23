package Tema1Ejer3;

import java.io.*;

public class ArchivoTXT {
    private String path;
    private File archivo;


    // Ejercicio 1
    public ArchivoTXT(String path) {
        this.path = path;
        this.archivo = new File(path);
        System.out.println(archivo.getAbsolutePath());
        if (!archivo.exists() || !archivo.isFile()) {
            System.out.println("El archivo no existe");
        }
    }
    public void aVerso(){
        try (BufferedReader br = new BufferedReader(new FileReader(path));){
            String line;
            String outputText = "";
            while ((line = br.readLine()) != null) {
                for (char c : line.toCharArray()) {
                    if (c == '.') {
                        outputText += c + "\n";
                    } else {
                        outputText += c;
                    }
                }
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
                bw.write(outputText.trim());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    //Path: Ruta del archivo en el que escribir le resultado
    public void codifica(String path) {
        File outputFile = new File(path);
        try {
            if (outputFile.createNewFile()) {
                System.out.println("El archivo ha sido creado");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try (BufferedReader br = new BufferedReader(new FileReader(this.archivo))) {
                BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
                String line;
                while ((line = br.readLine()) != null) {
                    bw.write(modificarLinea(line));
                    bw.newLine();
                }
                bw.close();

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

    public String modificarLinea(String linea) {
        String[] vocales = {"a", "e", "i", "o", "u", "A", "E", "I", "O", "U"};
        for (String vocal : vocales) {
            if (linea.contains(vocal)) {
                linea = linea.replace(vocal, "");
            }
        }
        return linea;
    }
}
