package Tema1Ejer3;

public class Main {
    public static void main(String[] args) {
        String path = "src/Tema1Ejer3/Lorem ipsum.txt";
        String path2 = "src/Tema1Ejer3/Destino.txt";
        ArchivoTXT text = new  ArchivoTXT(path);
        text.codifica(path2);
    }
}
