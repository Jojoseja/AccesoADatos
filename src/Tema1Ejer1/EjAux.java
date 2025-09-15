package Tema1Ejer1;

import java.io.File;

public class EjAux {
    public static void main(String[] args) {
        String rutaDirectorio =  "../AccesoADatos/src/Tema1Ejer1/CarpetaPruebas";
    }
    public static void generarArchivo(String ruta){
        //Generar Directorio
        File  directorio = new File(ruta);
        if (directorio.exists()) {
            System.out.println("El directorio existe");
        }
    }
}
