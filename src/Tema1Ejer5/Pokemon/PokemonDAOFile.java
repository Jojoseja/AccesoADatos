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
        if (curr_pokemon <= almacen) {
            ArrayList<Pokemon> lista = new ArrayList<>();
            if (!this.estaVacio()) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.getFile()))) {
                    while (ois.available() > 0) {
                        Pokemon p = (Pokemon) ois.readObject();
                        lista.add(p);
                    }
                    if (lista.contains(pokemon)) {
                        throw new DuplicateKeyException();
                    }
                } catch (IOException e){
                    throw new DataAccessException();
                } catch (ClassNotFoundException e) {
                    e.getMessage();
                }
            }

            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
                out.writeObject(pokemon);
                curr_pokemon += 1;
            } catch (IOException e){
                throw new DataAccessException();
            }

        } else {
            throw new DataDestFullException();
        }
    }

    public void aniadir(List<Pokemon> pokelista) throws DataAccessException, DataDestFullException, DuplicateKeyException {
        if (curr_pokemon <= almacen) {
            ArrayList<Pokemon> lista = new ArrayList<>();
            if (!this.estaVacio()) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.getFile()))) {
                    while (ois.available() > 0) {
                        Pokemon p = (Pokemon) ois.readObject();
                        lista.add(p);
                    }
                } catch (IOException e){
                    throw new DataAccessException();
                } catch (ClassNotFoundException e) {
                    e.getMessage();
                }
            }

            for (Pokemon pokemon : pokelista) {
                lista.add(pokemon);
            }


            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
                out.writeObject(lista);
            } catch (IOException e){
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
                    for (Pokemon p : pokemons) {
                        if (p.equals(pokemon)) {
                            output = true;
                        }
                        out.writeObject(p);
                        contador++;
                    }
                }
            catch (IOException e){
                throw new DataAccessException();
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
        } catch (ClassNotFoundException e) {
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
            Pokemon temp = (Pokemon) in.readObject();
            if (temp.getName().toLowerCase().contains(nombre.toLowerCase())) {
                pokemons.add(temp);
            }
        } catch (IOException e){
            throw new DataAccessException();
        } catch (ClassNotFoundException e){
            throw new IncompatibleVersionException();
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

            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
                for  (Pokemon p1 : pokemons) {
                    out.writeObject(p1);
                }
            } catch(IOException e){
                throw new DataAccessException();
            }
        } catch (IOException e) {
            throw new DataAccessException();
        } catch (ClassNotFoundException e){
            throw new IncompatibleVersionException();
        }
    }

    @Override
    public void pokemonCSV(String ruta, String name, int level, int life, int attack, int defense, int specialAttack, int specialdefense, int speed) {
        File file = new File(ruta);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.write(name+";"+level+";"+life+";"+attack+";"+defense+";"+specialAttack+";"+specialdefense+";"+speed);
            bw.newLine();
        } catch (Exception e) {
            e.getMessage();
        }

    }

    @Override
    public void imprimirPokemonCSV(String ruta) throws NoSuchFileException {
        File file = new File(ruta);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parte =  line.split(";");
                System.out.println("--- --- ---");
                System.out.println("Name: "+parte[0]);
                System.out.println("level: "+parte[1]);
                System.out.println("HP: "+parte[2]);
                System.out.println("attack: "+parte[3]);
                System.out.println("defense: "+parte[4]);
                System.out.println("Special Attack: "+parte[5]);
                System.out.println("Special Defense: "+parte[6]);
                System.out.println("speed: "+parte[7]);
                System.out.println("--- --- ---");

            }
        } catch (FileNotFoundException e){
            throw new NoSuchFileException("File not found");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void imprimirPokemon(String nombre) {
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            while(in.available()>0) {
                pokemons.add((Pokemon) in.readObject());
            }

            for(Pokemon p : pokemons) {
                if (p.getName().toLowerCase().contains(nombre.toLowerCase())) {
                    System.out.println("--- --- ---");
                    System.out.println("Name: "+p.getName());
                    System.out.println("level: "+p.getLevel());
                    System.out.println("attack: "+p.getAttack());
                    System.out.println("defense: "+p.getDefense());
                    System.out.println("Special Attack: "+p.getSpecialAttack());
                    System.out.println("special Defense: "+p.getSpecialDefense());
                    System.out.println("speed: "+p.getSpeed());
                    System.out.println("--- --- ---");
                }
            }
        } catch (ClassNotFoundException | IOException e){
            System.out.println(e.getMessage());
        }
    }

    //Metodo para facilitar la transaccion de CSV a DAT
    public List<Pokemon> getPokemonsCSV(String ruta) {
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parte =  line.split(";");
                Pokemon temp = new Pokemon();
                temp.setName(parte[0]);
                temp.setLevel(Integer.parseInt(parte[1]));
                temp.setLife(Integer.parseInt(parte[2]));
                temp.setAttack(Integer.parseInt(parte[3]));
                temp.setDefense(Integer.parseInt(parte[4]));
                temp.setSpecialAttack(Integer.parseInt(parte[5]));
                temp.setSpecialDefense(Integer.parseInt(parte[6]));
                temp.setSpeed(Integer.parseInt(parte[7]));
                pokemons.add(temp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pokemons;
    }

}
