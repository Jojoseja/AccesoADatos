package Tema1Ejer2;

// 5. ¿Qué salida producirá el siguiente código?

// Se ejecutará el primer print, el bloque catch y el bloque finally

public class Ejercicio5 {
    public static void main(String[] args) {
        try {
            int a = 0;
            System.out.println ("a = " + a);
            int b = 20 / a;
            System.out.println ("b = " + b);
        }
        catch(ArithmeticException e) {
            System.out.println ("Error al dividir entre cero.");
        }
        finally {
            System.out.println ("Estoy dentro del bloque finally.");
        }
    }
}
