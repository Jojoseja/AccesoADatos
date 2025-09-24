package Tema1Ejer3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

public class Ejercicios1_3 {
    public static void main(String[] args) {
        Path path = Path.of(".","src", "Tema1Ejer3", "Lorem ipsum.txt");
        Path ejer3 = Path.of(".", "src", "Tema1Ejer3", "Ejercicio3.txt");
        Path path4 = Path.of(".","src", "Tema1Ejer3","NewFolder", "Lorem ipsum.txt");
        Path path5 = Path.of(".","src", "Tema1Ejer3","NewerFolder", "Lorem ipsum.txt");



        ArchivoTXT archivo = new ArchivoTXT(path.toString());

        //Ejercicio 2
        //String algo = archivo.aVerso();
        //System.out.println(algo);


        //Ejercicio 3
        //archivo.codifica3(ejer3.toString());

        //Ejercicio 4
        //ArchivoTXT archivo2 = new ArchivoTXT(path4.toString());
        //archivo2.mover(path5.toString());

        //Ejercicio 5a
        //System.out.println(archivo.contar());
        //System.out.println(archivo.contarLetras());
        //System.out.println(archivo.contarPuntuacion());

        //Ejercicio 6
        //System.out.println(archivo.cuentaLineas());

        //Ejercicio 7
        //System.out.println(archivo.cuentaPalabras());

        //Ejercicio 8 y 9
        //archivo.cuentaVocales();
    }

    public static class ArchivoTXT{
        private Path path;
        private File file;

        //Ejercicio 1
        public ArchivoTXT(String path) {
            try {
                File file = new File(path);
                if (!file.exists()) {
                    throw new FileNotFoundException("Archivo no encontrado");
                } else if (file.isDirectory()) {
                    throw new PathIsADirectory("El archivo es un directorio");
                } else {
                    this.path = Paths.get(path);
                    this.file = new File(path);
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        //Ejercicio 2
        public String aVerso() {
            StringBuilder sb = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new FileReader(this.file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    line = line.replaceAll("[.]", "\n");
                    line = line.trim();
                    sb.append(line);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return sb.toString();
        }

        // Ejercicio 3a
        public void codifica1(String path) {
            try {
                File file = new File(path);
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                try (FileReader fr = new FileReader(this.file)) {
                    FileWriter fw = new FileWriter(file);
                    int c;
                    String[] vocales = {"A", "E", "I", "O", "U"};
                    while ((c = fr.read()) != -1) {
                        if (!Arrays.asList(vocales).contains(String.valueOf((char)c).toUpperCase())) {
                            fw.append(String.valueOf((char)c));

                        }
                    }


                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        // Ejercicio 3b
        public void codifica2(String path) {
            try {
                File file = new File(path);
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                try (BufferedReader br = new BufferedReader(new FileReader(this.file))) {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                    String[] vocales = {"A", "E", "I", "O", "U", "a", "e", "i", "o", "u"};
                    String line;
                    while ((line = br.readLine()) != null) {
                        for (String vocale : vocales) {
                            if (line.contains(vocale)) {
                                line = line.replace(vocale, "");
                            }
                        }
                        System.out.println(line);
                        bw.append(line);
                        bw.newLine();
                    }
                    //bw.flush();
                    bw.close();


                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        //Ejercicio 3c
        public void codifica3(String path) {
            try {
                File file = new File(path);
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                try (BufferedReader br = Files.newBufferedReader(this.file.toPath())) {
                    BufferedWriter bw = Files.newBufferedWriter(file.toPath());
                    String[] vocales = {"A", "E", "I", "O", "U", "a", "e", "i", "o", "u"};
                    String line;
                    while ((line = br.readLine()) != null) {
                        for (String vocale : vocales) {
                            if (line.contains(vocale)) {
                                line = line.replace(vocale, "");
                            }
                        }
                        System.out.println(line);
                        bw.append(line);
                        bw.newLine();
                    }
                    //bw.flush();
                    bw.close();


                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        //Ejercicio 4
        public void mover(String path) {
            try {
                Files.move(this.file.toPath(), Path.of(path), StandardCopyOption.REPLACE_EXISTING);
                if (this.file.getParentFile().list().length == 0) {
                    this.file.getParentFile().delete();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        //Ejercicio 5a
        public int contar(){
            int counter = 0;
            try (FileReader fr = new FileReader(this.file)) {
                int c;
                while ((c = fr.read()) != -1) {
                    counter++;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return counter;
        }

        //Ejercicio 5b
        public int contarLetras(){
            int counter = 0;
            try (FileReader fr = new FileReader(this.file)) {
                int c;
                String regex = "[a-zA-Z]";
                while ((c = fr.read()) != -1) {
                    if (String.valueOf((char)c).matches(regex)) {
                        counter++;
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return counter;
        }

        //Ejercicio 5c
        public int contarPuntuacion(){
            int counter = 0;
            try (FileReader fr = new FileReader(this.file)) {
                int c;
                String regex = "[.]";
                while ((c = fr.read()) != -1) {
                    if (String.valueOf((char)c).matches(regex)) {
                        counter++;
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return counter;
        }

        //Ejercicio 6
        public int cuentaLineas(){
            return this.aVerso().split("\n").length-1;
        }

        //Ejercicio 7
        public int cuentaPalabras(){
            int counter = 0;
            try (BufferedReader br = new BufferedReader(new FileReader(this.file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    counter += line.split(" ").length;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return counter;
        }

        //Ejercicio 8 y 9
        public void cuentaVocales(){
            int contA = 0;
            int contE = 0;
            int contI = 0;
            int contO = 0;
            int contU = 0;

            try (BufferedReader br = new BufferedReader(new FileReader(this.file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    for (int i = 0; i < line.length(); i++) {
                        Character c = line.charAt(i);
                        //Para el 9 [ÁAáa] [ÉEée] [ÍIíi] [ÓOóo] [ÚUúuü]
                        if (c.toString().matches("[Aa]")) {
                            contA++;
                        } else if (c.toString().matches("[Ee]")) {
                            contE++;
                        } else if (c.toString().matches("[Ii]")) {
                            contI++;
                        } else if (c.toString().matches("[Oo]")) {
                            contO++;
                        } else if (c.toString().matches("[Uu]")) {
                            contU++;
                        }
                    }
                }


                try (BufferedWriter bw = Files.newBufferedWriter(Path.of(this.file.getParentFile().getPath(), "numVocales.txt"))) {
                    bw.write("A: " + contA + " E: " + contE + " I: " + contI + " O: " + contO + " U: " + contU);
                    bw.flush();
                    bw.close();
                }




            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

        //Ejercicio 10
        public void frecuenciaLetras(){
            try (BufferedReader br = new BufferedReader(new FileReader(this.file))) {

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
