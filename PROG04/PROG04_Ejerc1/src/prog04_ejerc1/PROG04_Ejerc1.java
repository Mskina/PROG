package prog04_ejerc1;

import java.util.Scanner;

/**
 * El ejercicio 1 de la UD4 de Programación muestra la tabla de multiplicar de
 * un número leído desde teclado empleando tres bucles distintos.
 * 
 * @author Iván Estévez Sabucedo
 */
public class PROG04_Ejerc1 {

    /**
     * Solicita el número por teclado, comprueba que se encuentra entre los
     * valores admitidos y muestra por pantalla la tabla de multiplicar
     * empleando tres métodos distintos.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        System.out.print("Introduce un número entre 1 y 30: ");
        int numero = scan.nextInt();
        if (numero > 30 || numero <= 0) {
            System.out.println("No has escrito un número correcto. Adios.");
        } else {
            // Bucle FOR
            System.out.println("--- Bucle FOR ---");
            int contador;
            for (contador = 1; contador <= 10; contador++) {
                int resultado = contador * numero;
                System.out.println(numero + " x " + contador + " = " + resultado);
            }
            // Bucle WHILE
            System.out.println("--- Bucle WHILE ---");
            contador = 1;
            while (contador <= 10) {
                int resultado = contador * numero;
                System.out.println(numero + " x " + contador + " = " + resultado);
                contador++;
            }
            // Bucle DO...WHILE
            System.out.println("--- Bucle DO...WHILE ---");
            contador = 1;
            do {
                int resultado = contador * numero;
                System.out.println(numero + " x " + contador + " = " + resultado);
                contador++;
            } while (contador <= 10);
        }
    }

}
