/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog05.util;

import java.util.Scanner;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Validar {

    /**
     * Comprueba si la información introducida por teclado es un entero. En caso
     * de introducir otro tipo de dato, vuelve a solicitar introducir un dato
     * correcto.
     *
     * @return el entero introducido por teclado.
     */
    public static int obtenerEnteroPorTeclado() {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt() == false) {
            scan.nextLine();
            System.out.print("Opción incorrecta. Por favor, escribe un número: ");
        }
        int numero = scan.nextInt();
        return numero;
    }

    // DNI es el documento mientras que NIF es la numeración
    private static final String LETRAS = "TRWAGMYFPDXBNJZSQVHLCKE";

    private static char calcularLetraNIF(int nif) {
        char letra;
        letra = LETRAS.charAt(nif % 23); // Con módulo 23 calculamos la letra del NIF
        return letra;
    }

    private static char extraerLetraNIF(String nif) {
        char letra = nif.charAt(nif.length() - 1);
        return letra;
    }

    private static int extraerNumeroNIF(String nif) {
        int numero = Integer.parseInt(nif.substring(0, nif.length() - 1));
        return numero;
    }

    /**
     * Valida si un NIF introducido es válido o no. Separa números y letra;
     * calcula la letra que debería tener.
     *
     * @param nif es una cadena con formato 8 números y una letra
     * @return <code>true</code> si el NIF es válido y <code>false</code> en
     * caso contrario.
     */
    public static boolean validarNIF(String nif) {
        boolean valido = true; // Por defecto, consideramos que es correcto
        char letraCalculada;
        char letraLeida;
        int nifLeido;
        if (nif == null) { // El campo no puede estar vacío
            valido = false;
        } else if (nif.length() < 8 || nif.length() > 9) { //Número de caracteres
            valido = false;
        } else {
            letraLeida = extraerLetraNIF(nif); //Extraemos la letra
            nifLeido = extraerNumeroNIF(nif); //Extraemos el número
            letraCalculada = calcularLetraNIF(nifLeido);  //Calculamos la letra de NIF a partir del número extraído
            if (letraLeida == letraCalculada) {  // Comparamos la letra extraída con la calculada
                valido = true; // Todas las comprobaciones han resultado válidas. El NIF es válido.
            } else {
                valido = false;
            }
        }
        return valido;
    }
}
