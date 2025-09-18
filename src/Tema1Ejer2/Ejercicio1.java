package Tema1Ejer2;

//1. Prueba a dividir dos variables. El divisor debe ser cero. ¿Qué sucede? Soluciónalo.

//ArithmeticException -> Can't divide by 0

public class Ejercicio1 {
    public static void main(String[] args) {
        try {
            long number = 8/0;
            System.out.println(number);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("hello");
        }
    }
}
