package Tema1Ejer4;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Plato plato01 = new Plato("Carbonara", "Italia", 500, 13.99f, false);
        Plato plato02 = new Plato("ArrozconCurry", "Japon", 400, 11.99f, false);
        Plato plato03 = new Plato("Ensalada", "Mediterraneo", 200, 6.99f, true);
        Plato plato04 = new Plato("Biryani", "India/Pakistan", 300, 9.99f, true);


        Path p = Path.of("src", "Tema1Ejer3", "archivo");

        //plato01.escribirObjeto(p.toString());
    }
}
