package Tema1Ejer1;

import java.io.File;

public class Ejercicio2 {
    public static void main(String[] args) {
        String rutaRepo = System.getProperty("user.dir");
        //Usando System.getProperty para el directorio actual

        String relative = "../AccesoADatos";
        String rel= "./";

        String rutaDirectorioActual = rutaRepo + "/Tema1Ejer1";
        //Especificando la carpeta "Tema1"

        File directorioActual = new File(rutaDirectorioActual);
        // ruta del directorio actual

        /*
        2. Crea un método listarDirectorio(String directorio) que devuelva una
        array con el listado del contenido del directorio indicado como argumento siempre
        y cuando este sea un directorio y no un archivo. Pruébalo pasándole al menos
        una ruta absoluta y una relativa.
        ¿Qué devolvería en caso de que la ruta que nos proporcionan no se correspondiera con un directorio?
         */
        String[] archivos = listarDirectorio(relative);
        for (String archivo : archivos) {
            System.out.println(archivo);
        }
    }

    // Método Ejercicio 2
    public static String[] listarDirectorio(String path) {
        File currentDir = new File(path);
        String[] files = {"La Ruta no es un Directorio"};
        if  (currentDir.isDirectory()) {
            System.out.println(currentDir.getName());
            files = currentDir.list();
        } else {
            System.out.println("La dirección no es un directorio o la dirección es incorrecta");
        }
        return files;
    }


}