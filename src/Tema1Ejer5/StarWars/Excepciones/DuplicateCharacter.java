package Tema1Ejer5.StarWars.Excepciones;

public class DuplicateCharacter extends RuntimeException {
    public DuplicateCharacter(String message) {
        super(message);
    }
}
