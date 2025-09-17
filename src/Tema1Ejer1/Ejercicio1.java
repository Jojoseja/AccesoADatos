package Tema1Ejer1;

import java.io.File;

public class Ejercicio1 {
    public static void main(String[] args) {
        /*
        1. Crea un metodo listarDirectorio() que devuelva una array con el listado del
        contenido (archivos y carpetas) del directorio actual.
        ¿Este metodo debería ser dinámico o estático? ¿por qué?


         */
        String[] archivos = listarDirectorio();

        for (String e: archivos){
            System.out.println(e);
        }

    }

    //Metodo que devuelve un array con el nombre del contenido
    public static String[] listarDirectorio(){
        String path = System.getProperty("user.dir");
        File dir = new File(path);
        String[] archivos = dir.list();
        return archivos;
    }
}
