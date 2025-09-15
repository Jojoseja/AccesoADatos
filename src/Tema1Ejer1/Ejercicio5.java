package Tema1Ejer1;

import java.io.File;

public class Ejercicio5 {
    public static void main(String[] args) {
        /*

        5. Crea un método renombrarArchivo que coja un archivo cuyo path absoluto se
        le pase como argumento y lo renombre añadiendo delante DAM2.
        Pruébalo con el archivo creado en el ejercicio anterior.
        El archivo antiguo, ¿desaparece?

        - El archivo creado no desaparece, solo se renombra

         */

        String absolPath = "/home/jojo/Projects/AccesoADatos/src/Tema1Ejer1/JoseJavier.txt";

        renombarArchivo(absolPath);
    }
    public static void renombarArchivo(String path) {
        File fichero = new File(path);
        if (fichero.getAbsolutePath().equals(path)) {
            System.out.println("Renombrando Archivo");
            String nombreFichero = fichero.getName();
            String rutaDirectorio = fichero.getParent();
            String DAM2 = "DAM2";

            String nuevaRuta = rutaDirectorio + File.separator + DAM2 + nombreFichero;

            System.out.println(nuevaRuta);
            fichero.renameTo(new File(nuevaRuta));
            
        } else {
            System.out.println("Error, la ruta introducida no es la ruta absoluta");
        }
    }
}
