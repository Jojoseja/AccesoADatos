package Tema1Ejer5.Pokemon;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import Tema1Ejer5.Pokemon.Pokemon;
import Tema1Ejer5.Pokemon.PokemonDAO;
import dao.pokemon.excepciones.DataAccessException;
import dao.pokemon.excepciones.DataDestFullException;
import dao.pokemon.excepciones.DataIntegrityException;
import dao.pokemon.excepciones.DuplicateKeyException;
import dao.pokemon.excepciones.IncompatibleVersionException;

import java.io.*;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sergio Cuesta
 */
public class PokemonDAOFile implements PokemonDAO {
    //Indica la ruta del archivo a usar
    private File file;

    //Indica el Máximo de pokemons permitidos en el archivo
    private int almacen;

    //Indica el número de pokemons actuales en el archivo
    private int curr_pokemon;

    public void setFile(File file) throws FileNotFoundException {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public int getAlmacen() {
        return almacen;
    }

    public void setAlmacen(int almacen) {
        this.almacen = almacen;
    }

    public int getCurr_pokemon() {
        return curr_pokemon;
    }

    public void setCurr_pokemon(int curr_pokemon) {
        this.curr_pokemon = curr_pokemon;
    }

    public PokemonDAOFile(File file, int almacen) {
        try {
            setFile(file);
            setAlmacen(almacen);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    //Comprobar si el archivo está vacío
    @Override
    public boolean estaVacio() throws DataAccessException {
        try {
            return curr_pokemon == 0;
        } catch (Exception e) {
            throw new DataAccessException();
        }
    }

    @Override
    public boolean estaLLeno() throws DataAccessException {
        try {
            return curr_pokemon == almacen;
        } catch (Exception e) {
            throw new DataAccessException();
        }
    }

    @Override
    public void aniadir(Pokemon pokemon) throws DataAccessException, DataDestFullException, DuplicateKeyException {
        if (curr_pokemon < almacen) {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
                out.writeObject(pokemon);
                curr_pokemon += 1;
            } catch (Exception e){
                throw new DataAccessException();
            }
        } else {
            throw new DataDestFullException();
        }
    }

    @Override
    public boolean eliminar(Pokemon pokemon) throws DataAccessException, DataIntegrityException {
        boolean output = false;
        int contador = 0;
        if (curr_pokemon == 0) {
            throw new DataIntegrityException();
        } else {
            ArrayList<Pokemon> pokemons = new ArrayList<>();
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                while (in.available() > 0) {
                    pokemons.add((Pokemon) in.readObject());
                }
                try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
                    for  (Pokemon p : pokemons) {
                        if (p.equals(pokemon)) {
                            output = true;
                        }
                        out.writeObject(p);
                        contador++;
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        curr_pokemon = contador;
        return output;
    }

    @Override
    public List<Pokemon> leerPokemons() throws DataAccessException, IncompatibleVersionException {
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        int contador=0;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            pokemons.add((Pokemon) in.readObject());
            contador++;
        } catch (InvalidClassException e) {
            throw new IncompatibleVersionException();
        } catch (Exception e){
            //Debug
            System.out.println(e.getMessage());
            throw new DataAccessException();
        }
        curr_pokemon = contador;
        return pokemons;
    }

    @Override
    public List<Pokemon> leerPokemons(String nombre) throws DataAccessException, IncompatibleVersionException {
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            Pokemon temp =  (Pokemon) in.readObject();
            if (temp.getName().toLowerCase().contains(nombre.toLowerCase())) {
                pokemons.add(temp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pokemons;
    }

    @Override
    public void actualizar(Pokemon p) throws DataAccessException, IncompatibleVersionException {
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            Pokemon temp = (Pokemon) in.readObject();

            if (temp.equals(p)) {
                pokemons.add(p);
            } else {
                pokemons.add(temp);
            }

            try  (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
                pokemons.add(p);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void pokemonCSV(String ruta, String name, int level, int life, int atack, int defense, int specialAttack, int specialdefense, int speed) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void imprimirPokemonCSV(String ruta) throws NoSuchFileException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void imprimirPokemon(String nombre) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
