/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog02_ejerc1;

/**
 *
 * @author mskin
 */
public class PROG02_Ejerc1 {
    public enum Sexo {H, M};
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final short VALOR = 5000; // Utilizo short porque abarca hasta 2^15
        boolean carnetConducir = true; // Solo hay dos opciones de sí y no
        byte mesNumero = 12; //Al solo haber 12 posibilidades, byte es suficiente para almacenar el dato.
        String mesNombre = "Diciembre"; //Un mes del año en formato numérico y como cadena.
        String nombrePersona = "Iván Estévez Sabucedo"; // Uso String porque me permite escribir una cadena de texto.
        Sexo sexoPersona = Sexo.H;  // Uso enum porque me permite restringir valores
        long milisegundos = 1608336000000L; // Uso long porque con int no me alcanza para representar el número.
        float saldoCuenta = 1027.23f; // Uso float porque es suficiente para el saldo de una cuenta bancaria que puede poseer decimales
        int distanciaJupiter = 588000000; // short se quedaría corto y long sería demasiado amplio para representar este valor.
        
        System.out.print(VALOR);
        System.out.print("\n"+carnetConducir);
        System.out.print("\n"+mesNumero);
        System.out.print("\n"+mesNombre);//
        System.out.print("\n"+nombrePersona);//
        System.out.print("\n"+sexoPersona);
        System.out.print("\n"+milisegundos+" ms");//milisegundos 
        System.out.print("\n"+saldoCuenta+" €"); //saldo
        System.out.print("\n"+distanciaJupiter+" km\n"); //distancia
        

// Muestra el valor de cada variable en pantalla de forma que
// cada valor aparezca en una línea,
//teniendo en cuenta que NO puedes utilizar la orden println.

     

    }
    
}
