package Tema1Ejer5.StarWars;

import java.io.File;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.util.List;

public class CharactersMain {
    public static void main(String[] args) {
        Path p = Path.of("src", "Tema1Ejer5", "StarWars", "People.csv");
        File f = new File(p.toAbsolutePath().toString());
        CharactersDAOFile cdaof = new CharactersDAOFile(f);

        //Rey Skywalker segun starwars.fandom
        Characters rey = new Characters("Rey Skywalker", "female", "15ABY", 170, 54,
                "Brown", "Light", "Hazel","Hyperkarn", "Human");

        cdaof.leerCSV();


    }
}
