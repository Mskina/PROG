package prog04_ejerc4;

import java.util.Scanner;

/**
 * El ejercicio 4 de la UD4 de Programación muestra el resultado de la división
 * de dos enteros solicitados al usuario por teclado.
 *
 * @author Iván Estévez Sabucedo
 */
public class PROG04_Ejerc4 {

    /**
     * Se solicitan por teclado dos enteros al usuario y se calcula el resultado
     * de dividir el primero entre el segundo, comprobando que no se intente
     * hacer una división entre 0. El programa finaliza únicamente cuando
     * dividendo y divisor son ambos -1.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int dividendo = 1;
        int divisor = 1;
        int resultado = 0;
        int contador;

        Scanner scan = new Scanner(System.in);

        for (contador = 0; dividendo != -1 || divisor != -1; contador++) {
            try {
                System.out.println("---DIVISIÓN " + (contador+1) + " ---");
                System.out.print("Introduce el dividendo: ");
                dividendo = scan.nextInt();
                System.out.print("Introduce el divisor: ");
                divisor = scan.nextInt();
                resultado = dividendo / divisor;
                System.out.println("El resultado de dividir " + dividendo + " entre " + divisor + " es: " + resultado);
            } catch (ArithmeticException errorDivisor) {
                System.err.println("No puedes dividir entre cero. Prueba otra vez.");
                System.out.println("");
            }
        }
        System.out.println("Gracias por usar nuestro programa.");
        System.out.println("Divisiones calculadas: " + contador);
    }

}
