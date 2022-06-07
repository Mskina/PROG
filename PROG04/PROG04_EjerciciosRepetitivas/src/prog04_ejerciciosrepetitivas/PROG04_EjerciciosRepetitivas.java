/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog04_ejerciciosrepetitivas;

import java.util.Scanner;

/**
 *
 * @author mskin
 */
public class PROG04_EjerciciosRepetitivas {

    static Scanner scan = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // EJERCICIO 9
        /**
         * Crea un programa en Java que muestre los números del 1 a un número
         * mayor introducido por teclado empleando la sentencia for (repite el
         * ejercicio con while y con do..while). Salida: Primero muestra cada
         * número en una línea y a continuación los muestra en la misma línea
         * separados por un espacio en blanco.
         */
        /* FOR
        int contador;
        System.out.print("Escribe un número: ");
        int numero = scan.nextInt();
        
        
        for (contador = 1; contador <= numero; contador++) {
            System.out.println(contador);
        }
        for (contador = 1; contador <= numero; contador++) {
            System.out.print(contador + " ");
        }*/

 /* WHILE
        int contador = 1;

        System.out.print("Escribe un número: ");
        int numero = scan.nextInt();
        
        while (contador <= numero) {
            System.out.println(contador);
            contador++;
        }
        
        contador = 1;
        
        while (contador <= numero) {
            System.out.print(contador + " ");
            contador++;
        }*/
 /* DO WHILE
        int contador = 1;

        System.out.print("Escribe un número: ");
        int numero = scan.nextInt();
        
        do {
            System.out.println(contador);
            contador++;
        } while (contador <= numero);
        
        contador = 1;
        
        do {
            System.out.print(contador + " ");
            contador++;
        } while (contador <= numero);
         */
        // 
        // EJERCICIO 10
        //
        /**
         * Crea un programa en Java que muestre los números del 100 al 1
         * empleando la sentencia while (repite el ejercicio con for y con
         * do..while) Salida: Primero muestra cada número en una línea y a
         * continuación los muestra en la misma línea separados por un espacio
         * en blanco.
         */
        /* WHILE
        int contador = 100;
         
        while (contador >= 1) {
            System.out.println(contador);
            contador--;
        }
        contador = 100;
        while (contador >= 1) {
            System.out.print(contador + " ");
            contador--;
        }*/
 /* FOR
        int contador;

        for (contador = 100; contador >= 1; contador--) {
            System.out.println(contador);
        }
        
        for (contador = 100; contador >= 1; contador--) {
            System.out.print(contador + " ");
        }*/
 /* DO WHILE
        int contador = 100;

        do {
            System.out.println(contador);
            contador--;
        } while (contador >= 1);
        
        contador = 100;
        do {
            System.out.print(contador + " ");
            contador--;
        } while (contador >= 1);*/
        //
        // EJERCICIO 11
        /**
         * Crea un programa en Java que muestre los números desde un número
         * introducido por teclado hasta el 1, descendiendo de 1 en 1, y
         * empleando la sentencia do-while (repite el ejercicio con for y con
         * while) Salida: Primero muestra cada número en una línea y a
         * continuación los muestra en la misma línea separados por un espacio
         * en blanco.
         */
        /*DO WHILE
        System.out.print("Escribe un número: ");
        int numero = scan.nextInt();
        
        int escritoLinea = numero;

        do {
            System.out.println(escritoLinea);
            escritoLinea--;
        } while (escritoLinea >= 1);
        
        int escritoSeguido = numero;
        
        do {
            System.out.print(escritoSeguido + " ");
            escritoSeguido--;
        } while (escritoSeguido >= 1);
         */
 /* FOR
        int contador;
        System.out.print("Escribe un número: ");
        int numero = scan.nextInt();
        for (contador = numero; contador >= 1; contador --) {
            System.out.println(contador);
        }
        
        for (contador = numero; contador >= 1; contador --) {
            System.out.print(contador + " ");
        }*/
//
        /* WHILE
        System.out.print("Escribe un número: ");
        int numero = scan.nextInt();
        int contador = numero;
        while (contador >= 1) {
            System.out.println(contador);
            contador--;
        }
        contador = numero;
        
        while (contador >= 1) {
            System.out.print(contador + " ");
            contador--;
        }*/
//
        // EJERCICIO 12
        /**
         * Crea un programa en Java que muestre los números desde un número
         * mayor hasta otro menor introducidos por teclado, empleando la
         * sentencia for. Comprueba que el primer número es mayor que el
         * segundo, y si no lo es, muestra un mensaje y finaliza el programa
         * (repite el ejercicio con while y con do..while). Salida: Primero
         * muestra cada número en una línea y a continuación los muestra en la
         * misma línea separados por un espacio en blanco.
         */
        /*int contador;
        
        System.out.print("Escribe el número mayor: ");
        int numMayor = scan.nextInt();
        System.out.print("Escribe el número menor: ");
        int numMenor = scan.nextInt();
        if (numMayor <= numMenor) {
            System.out.print("El primer número no es mayor que el segundo.");
        } else {
            for (contador = numMayor; contador >= numMenor; contador--) {
                System.out.println(contador);
            }
            for (contador = numMayor; contador >= numMenor; contador--) {
                System.out.print(contador + " ");
            }
            
        }*/
 /*int contador;
        
        System.out.print("Escribe el número primero: ");
        int num1 = scan.nextInt();
        System.out.print("Escribe el número segundo: ");
        int num2 = scan.nextInt();
        
        int numMayor = num1 > num2 ? num1 : num2;
        int numMenor = num2 <= num1 ? num2 : num1;
        if (numMayor == numMenor) {
            System.out.print("Oops son iguales.");
        } else {
            for (contador = numMayor; contador >= numMenor; contador--) {
                System.out.println(contador);
            }
            for (contador = numMayor; contador >= numMenor; contador--) {
                System.out.print(contador + " ");
            }
            
        }*/
        //WHILE
        /*int contador;
        
        System.out.print("Escribe el número mayor: ");
        int numMayor = scan.nextInt();
        System.out.print("Escribe el número menor: ");
        int numMenor = scan.nextInt();
        contador = numMayor;
        if (numMayor <= numMenor) {
            System.out.print("El primer número no es mayor que el segundo.");
        } else {
            while (contador >= numMenor) {
                System.out.println(contador);
                contador--;
            }
            
            contador = numMayor;
            while (contador >= numMenor) {
                System.out.print(contador + " ");
                contador--;
            }
            
        }*/
        // DO WHILE
        /*int contador;

        System.out.print("Escribe el número mayor: ");
        int numMayor = scan.nextInt();
        System.out.print("Escribe el número menor: ");
        int numMenor = scan.nextInt();
        contador = numMayor;
        if (numMayor <= numMenor) {
            System.out.print("El primer número no es mayor que el segundo.");
        } else {
            do {
                System.out.println(contador);
                contador--;
            } while (contador >= numMenor);
        }
        
        contador = numMayor;
        if (numMayor <= numMenor) {
            System.out.print("El primer número no es mayor que el segundo.");
        } else {
            do {
                System.out.print(contador + " ");
                contador--;
            } while (contador >= numMenor);
        }*/
        // EJERCICIO 13
        /**
         * Crea un programa en Java que muestre el producto de los 10 primeros
         * números impares utilizando un bucle for (repite el ejercicio con
         * while y con do..while).
         */
        
        // FOR
        /*int contador;
        int numero = 1;
        int producto = 1;

        for (contador = 1; contador <= 10; contador++) {
            producto *= numero; // producto = producto*numero
            numero += 2;
        }
        System.out.println(producto);*/
        
        // WHILE
        
        /*int contador = 1;
        int numero = 1;
        int producto = 1;

        while (contador <= 10) {
            if (numero % 2 != 0) {
                producto *= numero;
                contador++;
            }
            numero++;
            //producto *= numero;
            //numero += 2;
            //contador++;
        }
        System.out.println(producto);
        */
        
        // DO WHILE
        
        int contador = 1;
        int numero = 1;
        int producto = 1;

        do {
            numero += 2;
            producto *= numero;
            contador++;
        } while (contador < 10); // así hago 10 vueltas
                
        System.out.println(producto);
        
        
    }

}
