/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog02_ejerc8;

/**
 *
 * @author mskin
 */
public class PROG02_Ejerc8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        float alumnosProg = 23;
        float alumnosED = 33;
        float alumnosBD = 27;
        float alumnosTotales = alumnosProg+alumnosED+alumnosBD;
        float porcientoProg = (alumnosProg/alumnosTotales)*100;
        float porcientoED = alumnosED/alumnosTotales*100;
        float porcientoBD = alumnosBD/alumnosTotales*100;
        System.out.printf("Alumnos en Programación: %.1f %%\n",porcientoProg);
        System.out.printf("Alumnos en Entornos de Desarrollo: %.1f %%\n",porcientoED);
        System.out.printf("Alumnos en Base de datos: %.1f %%\n",porcientoBD);
        
                
    }
    
}

/**
 * Diseña un programa Java denominado PROG02_Ejerc8 que
 * dados el número de alumnos matriculados en Programación,
 * número de alumnos matriculados  en Entornos de Desarrollo y
 * número de alumnos matriculados en Base de datos,
 * el programa deberá mostrar el % de alumnos matriculados en cada uno
 * de los tres módulos. Se supone que un alumno sólo puede estar matriculado
 * en un módulo. Trata de mostrar un sólo decimal en los porcentajes.
 */