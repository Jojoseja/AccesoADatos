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

import java.io.File;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;

/**
 *
 * @author Sergio Cuesta
 */
public class PokemonDAOFile implements PokemonDAO {
    File file;


    @Override
    public boolean estaVacio() throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean estaLLeno() throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void aniadir(Pokemon pokemon) throws DataAccessException, DataDestFullException, DuplicateKeyException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean eliminar(Pokemon pokemon) throws DataAccessException, DataIntegrityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Pokemon> leerPokemons() throws DataAccessException, IncompatibleVersionException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Pokemon> leerPokemons(String nombre) throws DataAccessException, IncompatibleVersionException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void actualizar(Pokemon p) throws DataAccessException, IncompatibleVersionException {
        throw new UnsupportedOperationException("Not supported yet.");
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
