package Tema1Ejer1;

import java.io.File;

public class Ejercicio8 {
    public static void main(String[] args) {
        /*
        8. Crea una clase que herede de java.io.File y le añada un método que se llame
        showInfo(). Este método devolverá un String con la siguiente información del
        fichero:
        Nombre.
        Ruta.
        Ruta absoluta.
        ¿Se puede leer?
        ¿Se puede escribir?
        Tamaño.
        ¿Es un directorio? En caso afirmativo mostrará los contenidos del mismo.
        ¿Es un fichero?
        Cada elemento debe ir en una línea y llevar delante un texto que indique a qué
        se refiere.
         */

        String rutaArchivo =  "src/Tema1Ejer1/CarpetaPruebaCopia/Folder";
        ExtensionFile betterFile = new ExtensionFile(rutaArchivo);
        System.out.println(betterFile.showInfo());
        System.out.println(betterFile.length());

    }
    public static class ExtensionFile extends File{

        public ExtensionFile(String pathname) {
            super(pathname);
        }



        public String showInfo() {
            String dirText;
            String fileText = "No";
            if (this.isDirectory()) {
                String[] listFiles = this.list();
                if (listFiles.length == 0) {
                    dirText = "El directorio está vacío";
                } else {
                    dirText = "Si-> " ;
                    for (String fileName : listFiles) {
                        dirText = dirText + " " + fileName;
                    }
                }
            } else {
                dirText = "No";
                fileText = "Si";
            }

            String text = "Fichero: \n" +
                    "Nombre: " + this.getName() + "\n" +
                    "Ruta: " + this.getPath() + "\n" +
                    "Ruta Absoluta: " + this.getAbsolutePath() + "\n" +
                    "¿Se puede Leer?: " + this.canRead() + "\n" +
                    "¿Se puede Escribir?: " + this.canWrite() + "\n" +
                    "Tamaño: " + this.getDirSize() + " bytes" + "\n" +
                    "¿Es un Directorio?: " + dirText + "\n" +
                    "¿Es un Archivo?: " +  fileText + "\n"
                    ;
            return text;

        }

        public long getDirSize(){
            long totalSize = 0;
            if (this.isDirectory()) {
                totalSize += this.length();
                File[] files = this.listFiles();
                for (File f : files) {
                    ExtensionFile e = new ExtensionFile(f.getPath());
                    if (!(e.isDirectory())) {
                        totalSize += e.length();
                    }
                    else {totalSize += e.getDirSize();}
                }
            } else {
                totalSize = this.length();
            }
            return totalSize;
        }
    }
}
