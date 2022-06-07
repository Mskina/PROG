package prog05;

import prog05.util.Validar;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.DateTimeException;

/**
 * Representa la creación del vehículo. Los datos se solicitan y, junto con la
 * clase Validar, se comprueba que sean correctos.
 *
 * @author Iván Estévez Sabucedo
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String marca; // Marca del vehículo
        String matricula; // Matrícula del vehículo
        int kilometros; // Kilómetros del vehículo
        LocalDate fechaMatriculacion; // Fecha de matriculación del vehículo
        String descripcion; // Descripción del vehículo
        int precio; // Precio del vehículo
        String nombrePropietario; // Nombre del propietario del vehículo
        String nifPropietario; // NIF del propietario del vehículo

        Vehiculo coche = null; // Instanciamos un vehículo vacío
        boolean salir = false; // El elemento salir se empleará para saber cuándo quiere el usuario finalizar el programa.

        Scanner scan = new Scanner(System.in); // Creamos un nuevo Scanner para los datos que vamos a solicitar por teclado

        System.out.println("Bienvenido a AutoGest, tu sistema de gestión del automóvil.");

        do {
            try {
                int opcion = lanzarMenu(); // Menú de selección de opción
                switch (opcion) { // Características de cada opción
                    case 1:
                        System.out.println("");
                        System.out.println("Introduce los siguientes datos:");
                        System.out.println("");

                        System.out.print("Marca: ");
                        marca = scan.nextLine();

                        System.out.print("Matrícula: ");
                        matricula = scan.nextLine();
                        /* Empleando un validador de matrícula
                        do {
                            matricula = scan.nextLine();
                        } while (Validar.esMatriculaCorrecta(matricula) == false);
                         */
                        System.out.print("Kilómetros: ");
                        do {
                            kilometros = Validar.obtenerEnteroPorTeclado();
                        } while (Validar.esMayorQueCero(kilometros) == false);

                        System.out.println("Fecha de matriculación: ");
                        do { // Primer bucle. Encierra que la fecha sea anterior a hoy
                            do { // Segundo bucle. Encierra que la fecha sea correcta.
                                try {
                                    fechaMatriculacion = pedirFechaMatriculacion();
                                } catch (DateTimeException e) {
                                    System.out.println("La fecha que has introducido no es correcta. Por favor, escribe una fecha válida: ");
                                    fechaMatriculacion = null;
                                }
                            } while (fechaMatriculacion == null);
                            if (!fechaMatriculacion.isBefore(LocalDate.now())) {
                                System.out.println("La fecha de matriculación debe ser anterior a hoy. Escribe una fecha correcta: ");
                            }
                        } while (!fechaMatriculacion.isBefore(LocalDate.now()));

                        System.out.print("Descripción del vehículo: ");
                        descripcion = scan.nextLine();

                        System.out.print("Precio: ");
                        do {
                            precio = Validar.obtenerEnteroPorTeclado();
                        } while (Validar.esMayorQueCero(precio) == false);

                        System.out.print("Nombre del propietario: ");
                        nombrePropietario = scan.nextLine();

                        System.out.print("NIF del propietario: ");
                        do {
                            try {
                                nifPropietario = scan.nextLine();
                                Validar.validarNIF(nifPropietario);
                            } catch (NumberFormatException nfe) {
                                nifPropietario = null;
                            }
                            System.out.print("NIF incorrecto. Por favor, escribe un NIF correcto: ");
                        } while (Validar.validarNIF(nifPropietario) == false);

                        coche = new Vehiculo(marca, matricula, kilometros, fechaMatriculacion, descripcion, precio, nombrePropietario, nifPropietario);
                        System.out.println("-- Vehículo guardado correctamente");

                        break;

                    case 2:
                        System.out.println("Matrícula del vehículo: " + coche.getMatricula());
                        break;

                    case 3:
                        if (coche.getKilometros() == 1) {
                            System.out.println("El vehículo tiene " + coche.getKilometros() + " kilómetro.");
                        } else {
                            System.out.println("El vehículo tiene " + coche.getKilometros() + " kilómetros.");
                        }
                        break;

                    case 4:
                        actualizarKilometros(coche);
                        break;

                    case 5:
                        if (coche.getAnios() == 1) {
                            System.out.println("Desde que se matriculó ha pasado " + coche.getAnios() + " año.");
                        } else {
                            System.out.println("Desde que se matriculó han pasado " + coche.getAnios() + " años.");
                        }
                        break;

                    case 6:
                        System.out.println("El propietario es " + coche.getNombrePropietario() + ", con NIF " + coche.getNifPropietario() + ".");
                        break;

                    case 7:
                        System.out.println("Vehículo " + coche.getMatricula());
                        System.out.println("- Marca: " + coche.getMarca());
                        System.out.println("- Descripción: " + coche.getDescripcion());
                        System.out.println("- Kilómetros: " + coche.getKilometros());
                        break;

                    case 8:
                        if (coche.getPrecio() == 1) {
                            System.out.println("Precio del vehículo: " + coche.getPrecio() + " euro.");
                        } else {
                            System.out.println("Precio del vehículo: " + coche.getPrecio() + " euros.");
                        }
                        break;

                    case 9:
                        salir = true;

                }
            } catch (NullPointerException npe) {
                System.out.println("No hay ningún vehículo guardado. Introduce la opción deseada: ");
            }

        } while (!salir);

        System.out.println("Gracias por utilizar AutoGest.");
        scan.close();
        System.exit(0); // Finalizamos el programa.
    }

    /**
     * Muestra el menú principal validando la opción elegida
     *
     * @return opción elegida por el usuario
     */
    public static int lanzarMenu() throws NullPointerException {
        System.out.println("");
        System.out.println("\t 1. Nuevo vehículo");
        System.out.println("\t 2. Ver matrícula");
        System.out.println("\t 3. Ver número de kilómetros");
        System.out.println("\t 4. Actualizar kilómetros");
        System.out.println("\t 5. Ver años de antigüedad");
        System.out.println("\t 6. Mostrar propietario");
        System.out.println("\t 7. Mostrar descripción");
        System.out.println("\t 8. Mostrar precio");
        System.out.println("\t 9. Salir");
        System.out.println("");
        System.out.print("Por favor, introduce el número de la opción deseada: ");

        // Pedimos opción, asegurándonos de que sea entero entre 1 y 9
        int opcion = Validar.obtenerEnteroPorTeclado();
        while (opcion < 1 || opcion > 9) {
            System.out.print("Opción incorrecta. Introduce el número de la opción deseada: ");
            opcion = Validar.obtenerEnteroPorTeclado();
        }
        return opcion;
    }

    /**
     * Solicita la fecha de matriculación del vehículo
     *
     * @return un objeto LocalDate.of con año, mes y día de matriculación
     * @throws DateTimeException
     */
    public static LocalDate pedirFechaMatriculacion() throws DateTimeException {
        Scanner scan = new Scanner(System.in);
        System.out.print("  Día: ");
        int dayOfMonth = scan.nextInt(); // Solicitamos el día
        scan.nextLine();
        System.out.print("  Mes: ");
        int month = scan.nextInt(); // Solicitamos el mes
        scan.nextLine();
        System.out.print("  Año: ");
        int year = scan.nextInt(); // Solicitamos el año
        scan.nextLine();
        return LocalDate.of(year, month, dayOfMonth);
    }

    /**
     * Actualiza el número de kilómetros del vehículo, solicitando que el
     * usuario introduzca el número de kilómetros a incrementar.
     *
     * @param coche
     */
    public static void actualizarKilometros(Vehiculo coche) {
        int kilometrosParaSumar;
        System.out.print("Número de kilómetros a incrementar: ");
        do {
            kilometrosParaSumar = Validar.obtenerEnteroPorTeclado();
        } while (Validar.esMayorQueCero(kilometrosParaSumar) == false);
        coche.addKilometros(kilometrosParaSumar);
    }
}
