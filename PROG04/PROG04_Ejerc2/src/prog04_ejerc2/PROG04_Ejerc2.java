package prog04_ejerc2;

import java.util.Scanner;

/**
 * El ejercicio 2 de la UD4 de Programación consiste en la comprobación del
 * estatus de primo de un número introducido por teclado.
 *
 * @author Iván Estévez Sabucedo
 */
public class PROG04_Ejerc2 {

    /**
     * Dado un número introducido por teclado, mostramos por pantalla si es
     * primo o no.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int contador = 1;
        do {
            System.out.print("Escribe un número: ");
            int numero = scan.nextInt();
            if (numero < 0) {
                System.out.println("El número es negativo.");
            } else {

                boolean esPrimo = esPrimo(numero);
                if (esPrimo == true) {
                    System.out.printf("--El número %d es primo. \n", numero);
                } else {
                    System.out.printf("--El número %d no es primo. \n", numero);
                }
            }
            contador++;
        } while (contador <= 5);
        System.out.println("Gracias por utilizar este programa. Adios.");
    }

    /**
     * Calcula si un número es primo.
     *
     * @param numero es el número del cual queremos conocer si es primo.
     * @return <code>verdadero</code> si es primo y <code>falso</code> si no lo
     * es.
     */
    public static boolean esPrimo(int numero) {
        boolean esPrimo = true;
        if (numero < 2) {
            esPrimo = false;
        } else {
            for (int divisor = 2; divisor <= numero / 2 && esPrimo == true; divisor++) {
                if (numero % divisor == 0) {
                    esPrimo = false;
                    //System.out.println("Divisor: " +divisor);
                }
            }
        }
        return esPrimo;
    }
}
