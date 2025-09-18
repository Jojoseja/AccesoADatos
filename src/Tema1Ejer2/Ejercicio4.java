package Tema1Ejer2;

// 4. ¿Qué salida producirá el siguiente código?

// d es capturada en Base b


public class Ejercicio4 {
    static class Base extends Exception {}
    static class Derivada extends Base {}

    public static void main(String[] args) {
        // código.....
        try {
        /// más código.....
            throw new Derivada();
        }
        catch(Base b) {
            System.out.println("Capturada excepción Base.");
        }
        /*
        catch(Derivada d) {

            System.out.println("Capturada excepción Derivada.");
        }
        */
    }
}
