/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Tema1Ejer5.Pokemon;

import java.io.*;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 *
 * @author Sergio Cuesta
 */
public class PokemonMain {

    public static void main(String[] args) throws NoSuchFileException, dao.pokemon.excepciones.DataDestFullException, dao.pokemon.excepciones.DataAccessException, dao.pokemon.excepciones.DuplicateKeyException, dao.pokemon.excepciones.IncompatibleVersionException {
        //Ruta Archivo DAT
        Path rutaDAT = Path.of("src", "Tema1Ejer5", "Pokemon", "archivo.dat");
        File archivoDAT = new File(rutaDAT.toString());

        //Ruta Archivo CSV
        Path rutaCSV = Path.of("src", "Tema1Ejer5", "Pokemon", "archivo.csv");
        File archivoCSV = new File(rutaCSV.toString());

        //El número es el máximo en el almacen
        PokemonDAOFile pdaof = new PokemonDAOFile(archivoDAT, 10);
        ArrayList<Pokemon> pokeList = (ArrayList<Pokemon>) pdaof.getPokemonsCSV(archivoCSV.toString());


//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoDAT))) {
//            oos.writeObject(pokeList);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        for (Pokemon p : pdaof.leerPokemons()) {
            System.out.println(p.getName());
        }


    }
}
