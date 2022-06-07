/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog02_ejerc6;

/**
 *
 * @author mskin
 */
public class PROG02_Ejerc6 {
    public enum Razas {MASTIN, TERRIER, BULLDOG, PEKINES, CANICHE, GALGO};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
        * Esta parte la hice antes de buscar información para encontrar
        * la posición de los elementos y el total de valores. No la elimino
        * para poder tener la referencia de cómo conseguir el mismo resultado
        * de forma mucho más eficiente
       
        Razas var1 = Razas.TERRIER;
        Razas var2 = Razas.BULLDOG;
        String cadena;
        cadena=(var1==var2)?"la misma raza":"razas distintas";
        System.out.printf(var1 +" y "+var2+" son %s.\n",cadena);
        */
        
        Razas var1 = Razas.TERRIER;
        Razas var2 = Razas.BULLDOG;

        System.out.println("Comparación entre terrier y bulldog = " +var1.compareTo(var2));
        //Esta otra opción ofrece el resultado como booleano
        //System.out.println("Comparación entre terrier y bulldog = " +var1.equals(var2));
        System.out.println("Terrier está en la posición " +var1.ordinal()); // Empieza en 0
        System.out.println("Bulldog está en la posición " + var2.ordinal()); //Empieza en 0
        System.out.println("Razas en total: " +Razas.values().length);
    }
    
}

/**
*6.- Diseña un programa Java  denominado PROG02_Ejerc6
*que cree un tipo enumerado para las siguientes razas de perro:
*Mastín, Terrier, Bulldog, Pekines, Caniche y Galgo.
*El programa debe realizar las siguientes operaciones:

*Crea una variable denominada var1 del tipo enumerador. Asígnale un valor.
*Crea una variable denominada var2 del tipo enumerador. Asígnale un valor.
*Muestra por pantalla el valor obtenido de comparar ambas variables.
*Investiga sobre la posibilidad de averiguar la posición que
*ocupa un determinado valor en el enumerado así como
*mostrar la cantidad de valores que contiene.
*Si lo consigues, muestra la posición de las dos variables en el tipo enumerado.
*/
