package arborenadalconnome;

import java.util.Scanner;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class ArboreNadalConNome {

    /**
     * Crea un árbol de navidad con un nombre en la línea inferior. Las bolas de navidad tienen color aleatorio.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int asterisco = 0;

        System.out.print("Introduce un número: ");
        Scanner scan = new Scanner(System.in, "ISO-8859-1"); // Para que lea acentos
        int filas = scan.nextInt(); // Conseguimos número de filas del árbol
        int espacio = filas - 1; // Asignamos el valor a espacio, restando 1 ya que la última fila no lleva espacios
        System.out.print("Escribe tu nombre: ");
        String nombre = scan.next(); // Conseguimos nombre
        int nombreTamanho = nombre.length(); // Número de caracteres del nombre
        scan.close();

        System.out.println(""); // Línea vacía para separar datos del árbol

        for (int i = 0; i < filas - 1; i++) { // Bucle para imprimir el árbol. La última línea es especial, de ahí la resta

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

        // Fila final con nombre
        int asteriscosTotal = ((filas * 2) - 3); // Número de asteriscos (-1 general, -2 por los ceros, de ahí el -3)
        int asteriscosSinNombre = asteriscosTotal - nombreTamanho; // Número de asteriscos una vez descontado el número de caracteres del nombre
        int asteriscosIzquierda = asteriscosSinNombre / 2; // Calculamos a la izquierda. Es INT, por lo que da entero
        int asteriscosDerecha = asteriscosSinNombre - asteriscosIzquierda; // El resto van a la derecha

        System.out.print(crearBola()); // Bola izquierda

        for (int k = 0; k <= asteriscosIzquierda; k++) { // bucle de asteriscos izquierda
            System.out.print("*");
        }

        System.out.print(nombre); // Imprimimos el nombre

        for (int k = 0; k <= asteriscosDerecha; k++) { // bucle de asteriscos derecha
            System.out.print("*");
        }

        System.out.printf(crearBola() + "\n"); // Bola derecha y salto de línea

        for (int l = 0; l < Math.max(4, (filas / 2)); l++) { // tronco del árbol, con un mínimo de 4 filas y un maximo de filasArbol/2
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
