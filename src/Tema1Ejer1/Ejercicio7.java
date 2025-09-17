package Tema1Ejer1;

import java.io.File;

public class Ejercicio7 {
    public static void main(String[] args) {
        /*
        7. Crea un método eliminarDirectorio que reciba una ruta y elimine el directorio
        indicado por ella.
        ¿Elimina directorios con contenido? ¿cómo se puede solucionar?
        Modifica el método para que elimine directorios que contengan solo archivos o
        estén vacíos e indique que no puede hacerlo si contienen otros directorios.
         */

        /*
        No lo elimina si tiene contenido. Para eliminar la carpeta hay que eliminar el contenido de forma recursiva
         */

        String rutaDirectorio =  "../AccesoADatos/src/Tema1Ejer1/CarpetaPrueba";
        eliminarDirectorio2(rutaDirectorio);

    }
    //Metodo para eliminar directorio con archivos/carpetas vacias
    public static void eliminarDirectorio(String path){
        File dir = new File(path);
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            boolean soloArchivo = true;

            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        soloArchivo = false;
                    }
                }
                if (!soloArchivo){
                    dir.delete();
                }

            } else {
                dir.delete();
            }
        } else {
            System.out.println("No se encontró el directorio");
        }
    }


    //No funciona si el directorio no está vacío
    public static void eliminarDirectorio1(String path){
        File dir = new File(path);
        if  (dir.exists()){
            System.out.println(dir.getName());
            try {
                dir.delete();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    // Este método borra la carpeta de forma recursiva, borrando todos los archivos y todos los directorios de la ruta
    public static void eliminarDirectorio2(String path){
        File dir = new File(path);
        if  (dir.exists()){
            System.out.println(dir.getName());
            File[] files = dir.listFiles();
            System.out.println(files.length);
            if (files.length != 0){
                System.out.println("La carpeta no está vacía");
                for (File e : files){
                    if (e.isFile()) {
                        e.delete();
                    } else {
                        String recPath = e.getAbsolutePath();
                        eliminarDirectorio2(recPath);
                    }
                }
                dir.delete();
            } else {
                dir.delete();
            }
        }
    }
}
