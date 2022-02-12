package prog07;

import java.util.Scanner;
import prog07.util.Validar;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Principal {
    
    static Scanner scan = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcion; // opción elegida del menú
        
        // Creamos el Banco
        
        
        System.out.println("Bienvenido a GestBanca, tu sistema de gestión bancaria.");
        do {
            opcion = lanzarMenu();
            switch (opcion) {
                case 1:
                    //Abrir una nueva cuenta
                    break;
                case 2:
                    //Ver un listado de las cuentas disponibles (código de cuenta, titular y saldo actual)
                    break;
                case 3:
                    //Obtener los datos de una cuenta concreta
                    break;
                case 4:
                    //Realizar un ingreso en una cuenta
                    break;
                case 5:
                    //Retirar efectivo de una cuenta
                    break;
                case 6:
                    //Consultar el saldo actual de una cuenta
                    break;
                case 7:
                    System.out.println("Gracias por utilizar GestBanca.");
                    break;
                default:
                    System.out.println("Opción incorrecta. Introduce el número de la opción deseada: ");
            }
        } while (opcion != 7);
        scan.close();
    }
    
    /**
     * Muestra el menú principal
     *
     * @return opción elegida por el usuario
     */
    public static int lanzarMenu() {
        int opcion;
        System.out.println("\n"
                + "\t 1. Abrir una nueva cuenta \n"
                + "\t 2. Ver un listado de las cuentas disponibles \n"
                + "\t 3. Obtener los datos de una cuenta concreta \n"
                + "\t 4. Realizar un ingreso en una cuenta \n"
                + "\t 5. Retirar efectivo de una cuenta \n"
                + "\t 6. Consultar el saldo actual de una cuenta \n"
                + "\t 7. Salir de la aplicación \n");
        System.out.print("Por favor, introduce el número de la opción deseada: ");
        opcion = enteroPorTeclado();
        return opcion;
    }
    
    
    
    
    
    
    
    
    
    
    /**
     * Solicita y valida que el usuario introduzca un entero
     *
     * @return un entero
     */
    public static int enteroPorTeclado() {
        String teclado = null;
        do {
            teclado = scan.nextLine();
            if (!Validar.esNumeroEntero(teclado)) {
                System.out.print("Escribe un número correcto: ");
            }
        } while (!Validar.esNumeroEntero(teclado));
        int numero = Integer.parseInt(teclado);
        return numero;
    }

    /**
     * Solicita y valida que el usuario introduzca un decimal
     *
     * @return un decimal
     */
    public static double doublePorTeclado() {
        String teclado = null;
        do {
            teclado = scan.nextLine();
            if (!Validar.esNumeroDecimal(teclado)) {
                System.out.print("Escribe un número correcto: ");
            }
        } while (!Validar.esNumeroDecimal(teclado));
        double numero = Double.parseDouble(teclado);
        return numero;
    }
    
}
