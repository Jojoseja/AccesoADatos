package Tema1Ejer1;

import java.io.File;

public class Ejercicio3 {
    public static void main(String[] args) {
        /*
        3. Crea un método existeFichero(String directorio, String fichero) que
        compruebe si existe dicho fichero en el directorio indicado.
         */
        String rutaDir = "../AccesoADatos/src/Tema1Ejer1";
        String nombreFichero = "Ejercicio3.java";

        boolean respuesta = existeFichero(rutaDir, nombreFichero);
        System.out.println(respuesta);
    }

    public static boolean existeFichero(String directorio, String fichero) {
        boolean existe = false;
        File rutaDirectorio = new File(directorio);
        File rutaFichero = new File(directorio + "/" + fichero);
        if (rutaDirectorio.exists() && rutaDirectorio.isDirectory()) {
            System.out.println("Existe el directorio");
            if (rutaFichero.exists()) {
                System.out.println("Existe el fichero");
                existe = true;
            } else {
                System.out.println("No existe el fichero dentro del directorio");
            }
        } else {
            System.out.println("No existe el directorio");
        }
        return existe;
    }

}
