/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog02_ejerc9;

/**
 *
 * @author mskin
 */
public class PROG02_Ejerc9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int year = 3900;
        if(year%4==0 && year%100!=0 || year%400==0) {
            System.out.printf("%d es un año bisiesto.",year);
        } 
        else {
            System.out.printf("%d no es un año bisiesto.",year);
        }
   }
    
}

/**
 * Aunque aparentemente los años bisiestos son aquellos que son múltiplos de 4,
 * no es del todo preciso, ya que años como 1900 y como 2100 no fueron,
 * ni serán, bisiestos respectivamente. Existe una explicación física que
 * tiene que ver con que el año del calendario no coincide exactamente,
 * en duración, con el año solar. Así, un cálculo más exacto indica que
 * la duración real de un año es de 365,2425 días. Para corregir este desfase,
 * se utiliza el criterio de que se considerará año bisiesto aquel que sea
 * divisible por 4 pero no por 100 salvo que sea divisible por 400.
 * Por esto 1900 no es bisiesto, 1904 sí y 2000 también.
 * Diseña un programa Java, denominado PROG02_Ejerc9,
 * que dado un año indique si es bisiesto o no
 */