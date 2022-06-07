/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio;

/**
 *
 * @author mskin
 */
public class Principal {
    
    public static void main(String[] args) {
        
        Fecha objFecha1 = new Fecha(Fecha.EnumMes.febrero);
        objFecha1.setDia(20);
        objFecha1.setAnio(2000);
        System.out.println("Primera fecha, inicializada con el primer constructor");
        // String cadena = objFecha1.toString();
        // Este paso se omite  llamando  directamente al objFecha1.toString()
        System.out.printf("La fecha es: %s \n",objFecha1.toString());
        boolean esVerano1 = (objFecha1.isSummer()==true);
        String verano1 = (esVerano1)?"Es verano":"No es verano";
        System.out.println(verano1);
        System.out.println();
        
        Fecha objFecha2 = new Fecha(15, Fecha.EnumMes.julio, 2021);
        System.out.println("Segunda fecha, inicializada con el segundo constructor");
        System.out.println("La fecha 2 contiene el año " +objFecha2.getAnio());
        System.out.printf("La fecha es: %s \n",objFecha2.toString());
        boolean esVerano2 = (objFecha2.isSummer()==true);
        String verano2 = (esVerano2)?"Es verano":"No es verano";
        System.out.println(verano2);
        
    }
}
