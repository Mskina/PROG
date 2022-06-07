package concesionario.util;

import java.time.LocalDate;

/**
 *
 * @author
 */
public class Validar {

    public static boolean isMayorQueCero(Double numero) {
        return numero > 0;
    }

    public static boolean isMayorQueCero(Integer numero) {
        return numero > 0;
    }    
    public static boolean compararFecha(LocalDate fechaMatriculacion) {
        return fechaMatriculacion.isBefore(LocalDate.now());
    }

    public static boolean validarDNI(String dni) {
        return dni.matches("^[0-9]{7,8}[A-Za-z]$");  //Versión simple para validar un DNI.

    }

    public static boolean validarMatricula(String matricula) {
        return matricula.matches("^[0-9]{4}[A-Z]{3}$"); //Versión simple para validar una matrícula.
    }

    public static boolean validarNombre(String nombre) {
        boolean correcto = false;

        if (nombre.length() <= 40) {  //comprobamos que el tamaño no supera los 40 caracteres
            int posicion = nombre.indexOf(" "); //buscamos el primer espacio en blanco.

            if (posicion != -1) {
                if (nombre.indexOf(" ", posicion + 1) != -1) { //Buscamos el siguiente espacio en blanco.
                    correcto = true;
                }
            }
        }
        return correcto;
    }

}
