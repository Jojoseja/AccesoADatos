package Tema1Ejer1;

import java.io.File;

public class Ejercicio6 {
    public static void main(String[] args) {
        /*
        6. Crea un metodo que se llame borrarArchivo que reciba un path absoluto y
        elimine el archivo indicado.
        Pruébalo con el archivo del ejercicio anterior.
        En la clase File hay métodos para cambiar los atributos del archivo. Prueba a
        modificar el metodo haciendo el archivo de solo lectura antes de eliminarlo. ¿Qué
        sucede? ¿por qué?
         */

        //Se puede eliminar puesto que el borrado depende de los permisos de la carpeta, no del archivo

    String rutaArchivo = "/home/jojo/Projects/AccesoADatos/src/Tema1Ejer1/CarpetaPruebaCopia/Otra/texto2.txt";

    cambiarPrivilegios(rutaArchivo);
    borrarArchivo(rutaArchivo);

    }
    public static void borrarArchivo(String rutaDir) {
        File fileDir = new File(rutaDir);
        if (fileDir.getAbsolutePath().equals(rutaDir)){
            try {
                boolean delete = fileDir.delete();
                if (!delete){
                    System.out.println("Error al borrar el archivo");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static void cambiarPrivilegios(String rutaDir){
        File fileDir = new File(rutaDir);
        if (fileDir.getAbsolutePath().equals(rutaDir)){
            try {
                fileDir.setReadOnly();
                System.out.println("Execute: " + fileDir.canExecute()
                                    + " Write: " + fileDir.canWrite()
                                    + " Read: " + fileDir.canRead());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
