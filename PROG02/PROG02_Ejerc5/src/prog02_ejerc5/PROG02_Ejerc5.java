/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog02_ejerc5;

/**
 *
 * @author mskin
 */
public class PROG02_Ejerc5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int segundos = 44477431;
        int dias = (segundos/86400);
        int horas = ((segundos-(dias*86400))/3600);
        int minutos = ((segundos-(dias*86400)-(horas*3600))/60);
        System.out.printf("%d segundos son %d días, %d horas y %d minutos.", segundos,dias,horas,minutos);
        
        
        
        
        //dado un número de segundos,
        //muestre en pantalla cuántos minutos, horas y días contiene
    }
    
}
