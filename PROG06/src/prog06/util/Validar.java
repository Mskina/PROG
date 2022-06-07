package prog06.util;

import java.time.LocalDate;
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
     * @param numero
     * @return <code>true</code> si es válido y <code>false</code> en caso
     * contrario.
     */
    public static boolean esMayorQueCero(double numero) {
        return numero > 0;
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

    /**
     * Comprueba si la fecha de matriculación es anterior a la fecha actual
     *
     * @param fechaMatriculacion
     * @return <code>true</code> si es válida y <code>false</code> en caso
     * contrario.
     */
    public static boolean esFechaCorrecta(LocalDate fechaMatriculacion) {
        return fechaMatriculacion.isBefore(LocalDate.now());
    }

    /**
     * Comprueba si la matrícula del vehículo es correcta
     *
     * @param matricula cadena con formato 4 números y 4 letras mayúsculas
     * @return <code>true</code> si es válido y <code>false</code> en caso
     * contrario.
     */
    public static boolean esMatriculaCorrecta(String matricula) {
        boolean matriculaValida;
        Pattern pat = Pattern.compile("[0-9]{4}[A-Z]{3}");
        Matcher mat = pat.matcher(matricula);
        matriculaValida = mat.matches();
        return matriculaValida;
    }

    /**
     * Comprueba si el nombre del propietario es correcto: un mínimo de 3
     * palabras y un máximo de 40 caracteres
     *
     * @param nombrePropietario nombre y apellidos del propietario del vehículo
     * @return <code>true</code> si es válido y <code>false</code> en caso
     * contrario.
     */
    public static boolean esNombreCorrecto(String nombrePropietario) {
        boolean nombreCorrecto = false;
        int numeroPalabras = nombrePropietario.split(" ").length;
        if (nombrePropietario.length() <= 40 && numeroPalabras >= 3) {
            nombreCorrecto = true;
        }
        return nombreCorrecto;
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
