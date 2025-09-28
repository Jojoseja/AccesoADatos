package Tema1Ejer4;

import java.nio.file.Path;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Plato plato01 = new Plato("Carbonara", "Italia", 500, 13.99f, false, "2025-09-10");
        Plato plato02 = new Plato("Arroz con Curry", "Japon", 400, 11.99f, false, "2001-01-20");
        Plato plato03 = new Plato("Ensalada", "Mediterraneo", 200, 6.99f, true, "2018-03-11");
        Plato plato04 = new Plato("Biryani", "India/Pakistan", 300, 9.99f, true, "2016-07-13");

        ArrayList<Plato> platos = new ArrayList<>();
        platos.add(plato01); platos.add(plato02); platos.add(plato03); platos.add(plato04);

        Path p = Path.of("src", "Tema1Ejer4", "archivo");

        // Ejercicios 1-3
//        try {
//            Plato.escribirObjeto(platos, p.toString());
//            ArrayList<Plato> plato = Plato.leerObjeto(p.toString());
//            for  (Plato plato1 : plato) {
//                System.out.println(plato1);
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
        // Ejercicio 4
        try {
            Plato.escribirObjeto4(platos, p.toString());
            ArrayList<Plato> plato = Plato.leerObjeto4(p.toString());
            for  (Plato plato1 : plato) {
                System.out.println(plato1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
