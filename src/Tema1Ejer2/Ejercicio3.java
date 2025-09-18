package Tema1Ejer2;

// 3. ¿Qué salida producirá el siguiente código?

// Se ejecutará el bloque catch y el bloque finally

public class Ejercicio3 {

    static class Prueba extends Exception{}

    public static void main(String[] args) {
        try {
            throw new Prueba();
        }
        catch(Prueba ex) {
            System.out.println("Se produjo una excepción Prueba.");
        }
        finally {
            System.out.println("Estoy dentro del bloque finally.");
        }
    }
}

