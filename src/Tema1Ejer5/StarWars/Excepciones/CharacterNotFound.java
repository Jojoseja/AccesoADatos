package Tema1Ejer5.StarWars.Excepciones;

public class CharacterNotFound extends RuntimeException {
    public CharacterNotFound(String message) {
        super(message);
    }
}
