package Tema1Ejer5.StarWars;

import Tema1Ejer5.StarWars.Excepciones.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CharactersDAOFile implements CharactersDAO{
    File file;

    public CharactersDAOFile(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    //Metodo para obtener todos los personajes del CSV como lista
    private List<Characters> getCharacters(){
        ArrayList<Characters> characters = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            int contador_linea=0;

            while ((linea = br.readLine()) != null) {
                String[] parts = new String[10];
                int contador = 0;
                contador_linea++;

                if (contador_linea!=1){

                    if (linea.contains("\"")) {
                        boolean comillas = false;
                        String campo = "";

                        for (int i = 0; i < linea.length(); i++) {
                            char c = linea.charAt(i);

                            if (c == '"' && !comillas) {
                                campo+='"';
                                comillas = true;
                            } else if (c == '"' && comillas) {
                                campo+='"';
                                comillas = false;
                            }
                            else if (c == ',' && !comillas) {
                                parts[contador] = campo;
                                campo = "";
                                contador++;
                            } else if (i == linea.length()-1) {
                                campo+=c;
                                parts[contador] = campo;
                                campo = "";
                            }
                            else {
                                campo+=c;
                            }
                        }
                        characters.add(new Characters(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]), Double.parseDouble(parts[4]), parts[5],
                                parts[6],parts[7], parts[8], parts[9]));
                    }
                    //En caso de que el personaje NO tenga "" en su contenido
                    else {
                        parts = linea.split(",");
                        characters.add(new Characters(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]), Double.parseDouble(parts[4]), parts[5],
                                parts[6],parts[7], parts[8], parts[9]));
                    }
                }
                //En caso que el personaje tenga "" en su contenido

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return characters;
    }

    //Metodo para escribir Listas en CSV
    private void writeCharacters(List<Characters> chList){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            String header ="name,gender,birth_year,height,mass,hair_color,skin_color,eye_color,planet,species";
            bw.write(header);
            bw.newLine();
            for (Characters characters : chList) {
                bw.write(characters.toCSV());
                bw.newLine();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean estaVacio() {
        return file.length()==0;
    }

    //Create
    @Override
    public void addCSV(Characters characters) throws DuplicateCharacter {
        List<Characters> chList = getCharacters();
        if (chList.contains(characters)) {
            throw new DuplicateCharacter("Character already exists");
        } else {
            chList.add(characters);
            this.writeCharacters(chList);
        }

    }

    //Update
    @Override
    public void updateCSV(Characters characters) throws CharacterNotFound {
        List<Characters> chList = getCharacters();
        if (!chList.contains(characters)) {
            throw new CharacterNotFound("Character not found");
        } else {
            int index = 0;
            for (Characters ch : chList) {
                if (ch.equals(characters)) {
                    index = chList.indexOf(ch);
                }
            }
            chList.set(index, characters);
            this.writeCharacters(chList);
        }
    }

    //Read
    @Override
    public void leerCSV() {
        if (this.estaVacio()) {
            System.out.println("El archivo está vacío");
        } else {
            List<Characters> chList = getCharacters();
            for (Characters ch : chList) {
                System.out.println("--- --- ---");
                System.out.println(ch);
                System.out.println("--- --- ---");
            }
        }


    }

    //Delete
    @Override
    public boolean deleteCSV(Characters characters) throws CharacterNotFound {
        if (this.estaVacio()) {
            System.out.println("El archivo está vacío");
        } else {
            List<Characters> chList = getCharacters();
            if (!chList.contains(characters)) {
                throw new CharacterNotFound("Character not found");
            } else {
                chList.remove(characters);
                this.writeCharacters(chList);
                return true;
            }
        }
        return false;
    }

    //Find
    @Override
    public void findCSV(String text) throws CharacterNotFound {
        List<Characters> matches = new ArrayList<>();
        if (!this.estaVacio()) {
            List<Characters> chList = getCharacters();

            for (Characters characters : chList) {
                if (characters.getName().toLowerCase().contains(text.toLowerCase())) {
                    matches.add(characters);
                }
            }
            for (Characters characters : matches) {
                System.out.println("--- --- ---");
                System.out.println(characters.toString());
                System.out.println("--- --- ---");
            }

        } else {
            System.out.println("El archivo está vacío");
        }
    }
}
