/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arborenadal;

import java.util.Scanner;

/**
 *
 * @author mskin
 */
public class ArboreNadal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        String reset = "\u001B[0m";
        // rojo, verde, amarillo, azul, morado, cian
        String a[] = {"\033[31m", "\033[32m", "\033[33m", "\033[34m", "\033[35m", "\033[36m"};
        int r;

        int filas = 0;
        int asterisco = 0;
        int espacio;

        System.out.print("Introduce un número: ");
        Scanner scan = new Scanner(System.in);
        filas = scan.nextInt();
        espacio = filas - 1;
        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < espacio; j++) {
                System.out.print(" ");
            }
            r = (int) ((Math.random()) * a.length);
            System.out.print(a[r] + "0" + reset);
            for (int k = 0; k <= asterisco; k++) {
                System.out.print("*");
            }
            r = (int) ((Math.random()) * a.length);
            System.out.printf(a[r] + "0 \n" + reset);
            asterisco = asterisco + 2;
            espacio = espacio - 1;
        }

        for (int l = 0; l < Math.max(4, (filas / 2)); l++) {
            for (int m = 0; m < (filas - 1); m++) {
                System.out.print(" ");
            }
            System.out.printf("**\n");
        }
        
    }

}
