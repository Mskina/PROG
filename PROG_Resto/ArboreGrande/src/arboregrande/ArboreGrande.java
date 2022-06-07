/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboregrande;

import java.util.Scanner;

/**
 *
 * @author mskin
 */
public class ArboreGrande {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.print("Introduce un número: ");
        Scanner scan = new Scanner(System.in, "ISO-8859-1"); // Para que lea acentos
        int numero = scan.nextInt(); // Conseguimos número de filas del árbol
        scan.close();

        /**
         * Lo que hace es Número de filas + 2 Eso lo divide entre 2, llamémosle
         * "resta" Para obtener el número de filas: El introducido +
         * (introducido-resta)
         */
        int resta = (numero + 2) / 2;
        int suma = numero - resta;
        int filas = numero + suma;

        int espacio = filas - 1;  // Asignamos el valor a espacio, restando 1 ya que la última fila no lleva espacios

        System.out.println(""); // Línea vacía para separar datos del árbol

        int asterisco = 0;

        for (int i = 0; i < filas; i++) { // Bucle para imprimir el árbol. La última línea es especial, de ahí la resta

            for (int j = 0; j < espacio; j++) { // Bucle de espacios a la izquierda
                System.out.print(" ");
            }

            System.out.print(crearBola()); // Bola izquierda

            for (int k = 0; k <= asterisco; k++) { // Bucle de asteriscos
                System.out.print("*");
            }
            System.out.printf(crearBola() + "\n"); // Bola derecha y salto de línea

            asterisco = asterisco + 2; // Aumentamos los asteriscos (+2 por línea)
            espacio = espacio - 1; // Reducimos el espacio (-1 por línea)
        }

        for (int l = 0; l < suma; l++) { // tronco del árbol, con un mínimo de 4 filas y un maximo de filasArbol/2
            for (int m = 0; m < (filas - 1); m++) { // bucle para los espacios
                System.out.print(" ");
            }
            System.out.printf("**\n"); // bucle para los asteriscos
        }
    }

    public static String crearBola() {
        String reset = "\u001B[0m"; // Resetea el color
        // Array de colores: rojo, verde, amarillo, azul, morado, cian
        String a[] = {"\033[31m", "\033[32m", "\033[33m", "\033[34m", "\033[35m", "\033[36m"};
        int r; // Se usará para generar un número aleatorio
        r = (int) ((Math.random()) * a.length); // color aleatorio
        String bola = a[r] + "0" + reset;
        return bola;
    }

}
