package prog06;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;
import prog06.util.Validar;

/**
 * Representa la creación del concesionario. Los datos se solicitan y, junto a
 * la clase Validar, se comprueba que sean correctos.
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

        // Creamos el concesionario
        Concesionario concesionario = new Concesionario();

        System.out.println("Bienvenido a AutoGest, tu sistema de gestión del automóvil.");

        do {
            opcion = lanzarMenu();
            switch (opcion) {
                case 1:
                    nuevoVehiculo(concesionario);
                    break;
                case 2:
                    listarVehiculos(concesionario);
                    break;
                case 3:
                    buscarVehiculo(concesionario);
                    break;
                case 4:
                    modificarKmsVehiculo(concesionario);
                    break;
                case 5:
                    eliminarVehiculo(concesionario);
                    break;
                case 6:
                    System.out.println("Gracias por utilizar AutoGest.");
                    break;
                default:
                    System.out.println("Opción incorrecta. Introduce el número de la opción deseada: ");
            }
        } while (opcion != 6);
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
                + "\t 1. Nuevo vehículo \n"
                + "\t 2. Listar vehículos \n"
                + "\t 3. Buscar vehículo \n"
                + "\t 4. Modificar kms vehículo \n"
                + "\t 5. Eliminar vehículo \n"
                + "\t 6. Salir \n");
        System.out.print("Por favor, introduce el número de la opción deseada: ");
        opcion = enteroPorTeclado();
        return opcion;
    }

    /**
     * Solicita todos los datos necesarios para crear un nuevo vehículo y
     * almacenarlo en el concesionario
     *
     * @param concesionario el objeto concesionario al cual se añade el vehículo
     */
    public static void nuevoVehiculo(Concesionario concesionario) {
        String marca; // Marca del vehículo
        String matricula; // Matrícula del vehículo
        int kilometros; // Kilómetros del vehículo
        LocalDate fechaMatriculacion; // Fecha de matriculación del vehículo
        String descripcion; // Descripción del vehículo
        double precio = 0; // Precio del vehículo
        String nombrePropietario; // Nombre del propietario del vehículo
        String dniPropietario; // DNI del propietario del vehículo
        int vehiculoInsertado; // Número que indica el resultado de la operación

        System.out.println("\nIntroduce los siguientes datos:\n");

        System.out.print("Marca: ");
        marca = scan.nextLine();

        System.out.print("Matrícula: ");
        matricula = nuevoVehiculoMatricula();

        System.out.print("Kilómetros: ");
        kilometros = nuevoVehiculoKilometros();

        System.out.println("Fecha de matriculación: ");
        fechaMatriculacion = nuevoVehiculoFechaMatriculacion();

        System.out.print("Descripción: ");
        descripcion = scan.nextLine();

        System.out.print("Precio: ");
        precio = nuevoVehiculoPrecio();

        System.out.print("Nombre del propietario: ");
        nombrePropietario = nuevoVehiculoNombrePropietario();

        System.out.print("DNI del propietario: ");
        dniPropietario = nuevoVehiculoDniPropietario();

        //Con todos los datos, intentamos insertar el vehículo en el concesionario
        vehiculoInsertado = concesionario.insertarVehiculo(marca, matricula, kilometros, fechaMatriculacion, descripcion, precio, nombrePropietario, dniPropietario);
        switch (vehiculoInsertado) {
            case 0:
                System.out.println("Vehículo guardado en el concesionario.");
                break;
            case -1:
                System.out.println("Lo sentimos, el concesionario está completo.");
                break;
            case -2:
                System.out.println("Ese vehículo ya está en el concesionario.");
                break;
        }
    }

    /**
     * Solicita una matrícula y revisa si consta guardada. En caso afirmativo,
     * muestra por pantalla los datos de todos los vehículos almacenados.
     *
     * @param concesionario el objeto concesionario en el que se realiza la
     * consulta
     */
    public static void listarVehiculos(Concesionario concesionario) {
        System.out.println("\nListado actual de vehículos: ");
        if (!concesionario.listarVehiculos()) {
            System.out.println("El concesionario está vacío.");
        }
    }

    /**
     * Solicita una matrícula y revisa si consta guardada. En caso afirmativo,
     * muestra por pantalla los datos de dicho vehículo.
     *
     * @param concesionario el objeto concesionario en el que se realiza la
     * consulta
     */
    public static void buscarVehiculo(Concesionario concesionario) {
        System.out.print("Escribe la matrícula del vehículo: ");
        String matricula = scan.nextLine().toUpperCase();
        String datosVehiculo = concesionario.buscarVehiculo(matricula);
        if (datosVehiculo == null) {
            System.out.println("No existe vehículo con la matrícula introducida.");
        } else {
            System.out.println("");
            System.out.println(datosVehiculo);
        }
    }

    /**
     * Solicita una matrícula y un número de kilómetros. Si la matrícula existe,
     * actualiza el número de kilómetros de dicho vehículo
     *
     * @param concesionario el objeto concesionario en el que se realiza la
     * consulta
     */
    public static void modificarKmsVehiculo(Concesionario concesionario) {
        int kilometrosParaSumar = 0;
        System.out.print("Escribe la matrícula del vehículo: ");
        String matricula = scan.nextLine().toUpperCase();
        System.out.print("Número de kilómetros a incrementar: ");
        while (!Validar.esMayorQueCero(kilometrosParaSumar)) {
            kilometrosParaSumar = enteroPorTeclado();
            if (!Validar.esMayorQueCero(kilometrosParaSumar)) {
                System.out.print("El número debe ser mayor que cero. Escribe el número: ");
            }
        };
        if (concesionario.actualizarKms(matricula, kilometrosParaSumar)) {
            System.out.println("Vehículo actualizado.");
        } else {
            System.out.println("No existe vehículo con la matrícula introducida.");
        }
    }

    /**
     * Solicita una matrícula y revisa si consta guardada. En caso afirmativo, la elimina.
     *
     * @param concesionario el objeto concesionario en el que se realiza la consulta
     */
    public static void eliminarVehiculo(Concesionario concesionario) {
        System.out.print("Escribe la matrícula del vehículo: ");
        String matricula = scan.nextLine().toUpperCase();
        if (concesionario.eliminarVehiculo(matricula)) {
            System.out.println("Vehículo eliminado correctamente.");
        } else {
            System.out.println("No existe vehículo con la matrícula introducida.");
        }
    }

    /**
     * Solicita y valida la matrícula del vehículo
     *
     * @return matrícula del vehículo validada
     */
    public static String nuevoVehiculoMatricula() {
        String matricula = null;
        do {
            matricula = scan.nextLine();
            if (!Validar.esMatriculaCorrecta(matricula)) {
                System.out.print("La matrícula es incorrecta. Escribe una matrícula correcta: ");
            }
        } while (!Validar.esMatriculaCorrecta(matricula));
        return matricula;
    }

    /**
     * Solicita y valida (que sean mayor que 0) el número de kilómetros del
     * vehículo
     *
     * @return número de kilómetros del vehículo
     */
    public static int nuevoVehiculoKilometros() {
        int kilometros = 0;
        while (!Validar.esMayorQueCero(kilometros)) {
            kilometros = enteroPorTeclado();
            if (!Validar.esMayorQueCero(kilometros)) {
                System.out.print("El número debe ser mayor que cero. Escribe el número: ");
            }
        };
        return kilometros;
    }

    /**
     * Valida la fecha de matriculación del vehículo
     *
     * @return un objeto LocalDate con año, mes y día de matriculación
     */
    public static LocalDate nuevoVehiculoFechaMatriculacion() {
        LocalDate fechaMatriculacion = null;
        do { // Primer bucle. Encierra que la fecha sea anterior a hoy
            do { // Segundo bucle. Encierra que la fecha sea correcta.
                try {
                    fechaMatriculacion = pedirFechaMatriculacion();
                } catch (DateTimeException dte) {
                    System.out.println("La fecha que has introducido no es correcta. Por favor, escribe una fecha válida: ");
                    fechaMatriculacion = null;
                }
            } while (fechaMatriculacion == null);
            if (!Validar.esFechaCorrecta(fechaMatriculacion)) {
                System.out.println("La fecha de matriculación debe ser anterior a hoy. Escribe una fecha correcta: ");
            }
        } while (!Validar.esFechaCorrecta(fechaMatriculacion));
        return fechaMatriculacion;
    }

    /**
     * Solicita la fecha de matriculación del vehículo
     *
     * @return un objeto LocalDate con año, mes y día de matriculación
     */
    public static LocalDate pedirFechaMatriculacion() {
        System.out.print("  Día: ");
        int dayOfMonth = enteroPorTeclado();
        System.out.print("  Mes: ");
        int month = enteroPorTeclado();
        System.out.print("  Año: ");
        int year = enteroPorTeclado();
        return LocalDate.of(year, month, dayOfMonth);
    }

    /**
     * Solicita y valida (que sea mayor que 0) el precio del vehículo
     *
     * @return el precio del vehículo
     */
    public static double nuevoVehiculoPrecio() {
        double precio = 0;
        while (!Validar.esMayorQueCero(precio)) {
            precio = doublePorTeclado();
            if (!Validar.esMayorQueCero(precio)) {
                System.out.print("El precio debe ser mayor que cero. Escribe el precio: ");
            }
        };
        return precio;
    }

    /**
     * Solicita y valida el nombre y los apellidos del propietario del vehículo
     *
     * @return el nombre del propietario
     */
    public static String nuevoVehiculoNombrePropietario() {
        String nombrePropietario = null;
        do {
            nombrePropietario = scan.nextLine();
            if (!Validar.esNombreCorrecto(nombrePropietario)) {
                System.out.print("El nombre que has escrito no es correcto. Escribe el nombre del propietario: ");
            }
        } while (!Validar.esNombreCorrecto(nombrePropietario));
        return nombrePropietario;
    }

    /**
     * Solicita y valida el DNI del propietario del vehículo
     *
     * @return el DNI del propietario
     */
    public static String nuevoVehiculoDniPropietario() {
        String dniPropietario = null;
        do {
            dniPropietario = scan.nextLine();
            if (!Validar.esDniCorrecto(dniPropietario)) {
                System.out.print("DNI incorrecto. Por favor, escribe un DNI correcto: ");
            }
        } while (!Validar.esDniCorrecto(dniPropietario));
        return dniPropietario;
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
