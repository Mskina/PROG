package prog07.util;

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
     * @param numero
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
}
