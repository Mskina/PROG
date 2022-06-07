package prog04_ejerc3;

import java.util.Scanner;

/**
 * El ejercicio 3 de la UD4 de Programación consiste en un juego en el que el
 * usuario tiene que adivinar un número generado aleatoriamente.
 *
 * @author Iván Estévez Sabucedo
 */
public class PROG04_Ejerc3 {

    /**
     * Se lanza un juego en el que el usuario puede configurar previamente las
     * características del mismo.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Declaramos las variables por defecto
        int numInt = 5; // Intentos
        int numMax = 10; // Número mayor

        // Menú del juego
        System.out.println("Bienvenido a Adivina el número.");

        while (true) {
            int opcion = lanzarMenu(); // Menú de selección de opción
            switch (opcion) { // Características de cada opción
                case 1:
                    System.out.println("--- CONFIGURACIÓN ---");
                    System.out.print("Introduce el número de intentos que deseas tener: ");
                    numInt = obtenerEnteroPorTeclado();
                    System.out.print("Introduce el valor máximo a adivinar: ");
                    numMax = obtenerEnteroPorTeclado();
                    lanzarJuego(numInt, numMax); // Pendiente de respuesta?? foro
                    System.out.println("");
                    System.out.println("¿Otra partida?");
                    break;

                case 2:
                    System.out.println("--- INSTRUCCIONES ---");
                    System.out.printf("Tienes %d intentos \n", numInt);
                    System.out.printf("El número a advinar está entre 0 y %d. \n", numMax);
                    lanzarJuego(numInt, numMax);
                    System.out.println("");
                    System.out.println("¿Otra partida?");
                    break;

                case 3:
                    System.out.println("Gracias por jugar.");
                    System.exit(0); // Finalizamos la partida.
            }
        }
    }

    /**
     * Comprueba si la información introducida por teclado es o no un número
     * entero. En caso de introducir otro tipo de dato, vuelve a solicitar
     * introducir un dato correcto.
     *
     * @return el entero introducido por teclado.
     */
    public static int obtenerEnteroPorTeclado() {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt() == false) {
            scan.next();
            System.out.print("Opción incorrecta. Inténtalo de nuevo: ");
        }
        int numero = scan.nextInt();
        return numero;
    }

    /**
     * Genera un número aleatorio.
     *
     * @param numero es el valor máximo que puede alcanzar el número aleatorio.
     * @return el número aleatorio.
     */
    public static int generarNumero(int numero) {
        int numOculto = (int) (Math.random() * numero + 1);
        return numOculto;
    }

    /**
     * Muestra el menú del juego y pide al usuario que escriba una opción.
     *
     * @return un entero que representa la opción elegida por el jugador de
     * entre las disponibles en el menú.
     */
    public static int lanzarMenu() {
        String menuOpcion1 = "1. Configurar";
        String menuOpcion2 = "2. Jugar";
        String menuOpcion3 = "3. Salir";
        String seleccionaOpcion = "Por favor, escribe tu opción (1, 2 o 3): ";
        System.out.println(menuOpcion1 + "\n" + menuOpcion2 + "\n" + menuOpcion3);

        // Pedimos opción, asegurándonos de que sea entero entre 1 y 3
        System.out.print(seleccionaOpcion);
        int opcion = obtenerEnteroPorTeclado();
        while (opcion < 1 || opcion > 3) {
            System.out.print("Opción incorrecta. " + seleccionaOpcion);
            opcion = obtenerEnteroPorTeclado();
        }
        return opcion;
    }

    /**
     * Contiene la lógica del juego. Pide un número al usuario, si coincide con
     * el valor generado aleatoriamente muestra un mensaje con el número de
     * intentos necesitados. En caso contrario, le permite seguir jugando hasta
     * haber alcanzado el número máximo de intentos.
     *
     * @param numInt es el número de intentos que puede tener el jugador.
     * @param numMax es el valor máximo que puede tener el número a adivinar.
     */
    public static void lanzarJuego(int numInt, int numMax) {
        System.out.println("¡A JUGAR! ¿Qué número crees que debes adivinar?");
        int numOculto = generarNumero(numMax);
        int contador;
        for (contador = 1; contador <= numInt; contador++) {
            System.out.print("Escribe el número: ");
            int apuesta = obtenerEnteroPorTeclado();
            if (apuesta == numOculto) {
                System.out.printf("¡Has ganado! Has necesitado %d intento(s). \n", contador);
                break;
            } else {
                if (apuesta > numOculto) {
                    System.out.println("El número oculto es menor.");
                } else {
                    System.out.println("El número oculto es mayor.");
                }
            }
        }
        if (contador > numInt) {
            System.out.println("¡Perdiste! Intentos consumidos.");
        }
    }
}
