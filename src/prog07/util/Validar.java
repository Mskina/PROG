package prog07.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Contiene todas las validaciones de datos necesarias para asegurar que
 * únicamente procesamos datos correctos.
 *
 * @author Iván Estévez Sabucedo
 */
public class Validar {

    /**
     * Comprueba si el número introducido es mayor que 0
     *
     * @param numero que deseamos validar
     * @return <code>true</code> si es válido y <code>false</code> en caso
     * contrario.
     */
    public static boolean esMayorQueCero(double numero) {
        return numero > 0;
    }

    /**
     * Recibe una cadena de texto y comprueba si se trata de un entero
     *
     * @param teclado cadena de texto solicitada al usuario
     * @return <code>true</code> si es entero y <code>false</code> en caso
     * contrario.
     */
    public static boolean esNumeroEntero(String teclado) {
        return teclado.matches("[+-]?\\d+");
    }

    /**
     * Recibe una cadena de texto y comprueba si se trata de un double
     *
     * @param teclado cadena de texto solicitada al usuario
     * @return <code>true</code> si es double y <code>false</code> en caso
     * contrario.
     */
    public static boolean esNumeroDecimal(String teclado) {
        boolean esNumeroDecimal;
        try {
            Double.parseDouble(teclado);
            esNumeroDecimal = true;
        } catch (NumberFormatException nfe) {
            esNumeroDecimal = false;
        }
        return esNumeroDecimal;
    }

    /**
     * Comprueba si el IBAN introducido cumple el formato
     * ESNNNNNNNNNNNNNNNNNNNN, donde N es un dígito del 0 al 9
     *
     * @param iban número de cuenta bancaria
     * @return <code>true</code> si es válido y <code>false</code> en caso
     * contrario.
     */
    public static boolean esIbanCorrecto(String iban) {
        boolean esIbanCorrecto = false;
        Pattern pat = Pattern.compile("ES[0-9]{20}");
        Matcher mat = pat.matcher(iban);
        esIbanCorrecto = mat.matches();
        return esIbanCorrecto;
    }

    /**
     * Comprueba si el DNI del propietario es válido (tan solo el formato: 7 u 8
     * dígitos seguidos de una letra)
     *
     * @param dniPropietario cadena con formato 7 u 8 números y una letra final
     * @return <code>true</code> si es válido y <code>false</code> en caso
     * contrario.
     */
    public static boolean esDniCorrecto(String dniPropietario) {
        boolean dniValido;
        Pattern pat = Pattern.compile("[0-9]{7,8}[a-zA-Z]");
        Matcher mat = pat.matcher(dniPropietario);
        dniValido = mat.matches();
        return dniValido;
    }
}
