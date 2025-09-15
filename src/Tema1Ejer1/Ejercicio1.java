package Tema1Ejer1;

import java.io.File;

public class Ejercicio1 {
    public static void main(String[] args) {
        /*
        1. Crea un método listarDirectorio() que devuelva una array con el listado del
        contenido (archivos y carpetas) del directorio actual.
        ¿Este método debería ser dinámico o estático? ¿por qué?

        Este método debería ser estático ya que se tiene que acceder

         */
        String[] archivos = listarDirectorio();

        for (String e: archivos){
            System.out.println(e);
        }

    }
    public static String[] listarDirectorio(){
        String path = System.getProperty("user.dir");
        File dir = new File(path);
        String[] archivos = dir.list();
        return archivos;
    }
}
