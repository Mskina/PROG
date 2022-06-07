/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog04_ejerciciosselectivas;

import java.util.Scanner;

/**
 *
 * @author mskin
 */
public class PROG04_EjerciciosSelectivas {

    static Scanner scan = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // Ejercicio 1:
        // Crea un proyecto en Java que pida por teclado un número entero
        // y que lo muestre por pantalla solamente si es par.
        /*System.out.printf("Introduce un número: ");
        int numero = scan.nextInt();
        if (numero % 2 == 0) {
            System.out.println("El número es par.");
        }*/
        // Ejercicio 2
        // Crea un proyecto en Java que pida dos números por teclado
        // y que muestre por pantalla al menor de los dos.
        /*System.out.printf("Introduce el primer número: ");
        int numero1 = scan.nextInt();
        System.out.printf("Introduce el segundo número: ");
        int numero2 = scan.nextInt();
        if (numero1 > numero2) {
            System.out.printf("El número %d es el menor de los dos. \n", numero2);
        } else {
            System.out.printf("El número %d es el menor de los dos. \n", numero1);
        }*/
        // Ejercicio 3
        // Crea un proyecto en Java que pida un número por teclado
        // y que muestre por pantalla un mensaje indicando
        // si es positivo o negativo.
        // Considera el número 0 como positivo.
        /*System.out.printf("Introduce un número: ");
        int numero = scan.nextInt();
        if (numero >=0) {
            System.out.println("El número es positivo");
        } else {
            System.out.println("El número es negativo");
        }*/
        // Crea un proyecto en Java que pida tres números por teclado
        // y muestre por pantalla el mayor de los tres.
        /*System.out.print("Escribe el primer número: ");
        int num1 = scan.nextInt();
        System.out.print("Escribe el segundo número: ");
        int num2 = scan.nextInt();
        System.out.print("Escribe el tercer número: ");
        int num3 = scan.nextInt();
        if (num1>num2 && num1>num3) {
            System.out.printf("El número %d es el mayor de los tres. \n", num1);
        }
        else if (num2>num1 && num2>num3) {
            System.out.printf("El número %d es el mayor de los tres. \n", num2);
        }
        else {
            System.out.printf("El número %d es el mayor de los tres. \n", num3);
        }*/
        
        //Crea un proyecto en Java que pida un año por teclado y que indique si es bisiesto o no.
        //Un año es bisiesto si es múltiplo de 4,
        //exceptuando a los múltiplos de 100,
        //que sólo son bisiestos cuando son múltiplos además de 400
        //(por ejemplo: el año 1900 no fue bisiesto pero el año 2000, sí)
        /*System.out.print("Escribe el primer número: ");
        int anho = scan.nextInt();
        if (anho % 4 == 0 && anho % 100 != 0 || anho % 400 == 0) {
            System.out.print("El año es bisiesto.");
        }*/
        // Ejercicio 6
        // Modifica el ejercicio 3 de la tarea anterior que indica
        // si un número es positivo o negativo para que además
        // indique si el número es cero
        
        /*System.out.printf("Introduce un número: ");
        int numero = scan.nextInt();
        if (numero >0) {
            System.out.println("El número es positivo");
        } else if (numero <0){
            System.out.println("El número es negativo");
        } else {
            System.out.println("El número es 0");
        }*/
        
        // Ejercicio 7
        // Crea un proyecto en Java que pida un número del 1 al 12
        // por teclado y que muestre por pantalla el nombre del mes correspondiente
        
        /*System.out.printf("Introduce un número: ");
        int num = scan.nextInt();
        
        switch (num) {
            case 1:
                System.out.println("Enero");
                break;
            case 2:
                System.out.println("Febrero");
                break;
            case 3:
                System.out.println("Marzo");
                break;
            case 4:
                System.out.println("Abril");
                break;
            case 5:
                System.out.println("Feliz cumple");
                break;
            case 6:
                System.out.println("Juni");
                break;
            case 7:
                System.out.println("Julio");
                break;
            case 8:
                System.out.println("Agosto");
                break;
            case 9:
                System.out.println("Septiembre");
                break;
            case 10:
                System.out.println("Octubre");
                break;
            case 11:
                System.out.println("Noviembre");
                break;
            case 12:
                System.out.println("Diciembre");
                break;
        }*/
        
        // Ejercicio 8
        // Crea un proyecto en Java que pida el día, mes y año de una fecha correcta
        // y muestre la fecha del día siguiente.
        // Suponer que todos los meses tienen 30 días.
        
        System.out.printf("Introduce o día: ");
        int dia = scan.nextInt();
        System.out.printf("Introduce o mes: ");
        int mes = scan.nextInt();
        System.out.printf("Introduce o ano: ");
        int ano = scan.nextInt();
        /*if (dia < 30) {
            System.out.printf("El día siguiente es: %d de %d de %d \n", ++dia,mes,anho);
        }
        if (dia == 30 && mes <= 11) {
            System.out.printf("El día siguiente es: 1 de %d de %d \n", ++mes,anho);
        }
        if (dia==30 && mes==12) {
            System.out.printf("El día siguiente es: 1 de 1 de %d \n", ++anho);
        }*/
        
        switch (dia) {
            case 30:
                dia = 1;
                switch (mes) {
                    case 12:
                        mes = 1;
                        ano++;
                        break;
                    default:
                        mes++;
                }
                break;
            default:
                dia++;
                break;
        }

        System.out.printf("A data seguinte é: día %d do mes %d do ano %d \n", dia, mes, ano);

    }
}
