package Tema1Ejer1;

import java.io.File;

public class Ejercicio4 {
    /*
    4. Crea un metodo generarArchivo que a partir de una ruta que se le pase como
    argumento, cree un archivo txt con nombre TunombreTuapellido en la ruta en la
    que se le ha proporcionado. Presta atención a los posibles errores que puedan
    darse.
    ¿Qué pasa si la ruta no existe? ¿puedes solucionarlo?
     */
    //Si la ruta no existe no se puede crear el archivo.

    public static void main(String[] args) {
        String rutaRel = "../AccesoADatos/src/Tema1Ejer1";
        generarArchivo(rutaRel);
    }
    public static void generarArchivo(String ruta){
        File directorio = new File(ruta);
        String nombreFichero = "JoseJavier.txt";
        if (directorio.isDirectory()) {
           File rutaArchivo = new File(directorio + File.separator + nombreFichero);
           try {
               if(rutaArchivo.createNewFile()){
                   System.out.println("Archivo creado");
               } else {
                   System.out.println("Error al crear el archivo, ya existe un archivo con ese nombre");
               }
           } catch (Exception e) {
               System.out.println(e.getMessage());
           }

        } else {
            System.out.println("La ruta no existe");
        }
    }
}
