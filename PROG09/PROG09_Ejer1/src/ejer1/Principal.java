package ejer1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import util.Validar;

/**
 * Representa la creación de un banco, donde se almacenan hasta 100 cuentas.
 * Permite operar con ellas y mostrar diversa información
 *
 * @author Iván Estévez Sabucedo
 */
public class Principal {

    static Scanner scan = new Scanner(System.in); // Se inicia el escáner

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcion; // opción elegida del menú

        // Creamos el Banco
        Banco banco = new Banco();

        // Cargamos el fichero, si existe
        cargarFichero(banco);

        System.out.println("Bienvenido a GestBanca, tu sistema de gestión bancaria.");
        System.out.println("Número de cuentas registradas actualmente: " + banco.cuentas.size() + ".");
        do {
            opcion = lanzarMenu();
            switch (opcion) {
                case 1:
                    abrirCuenta(banco);
                    break;
                case 2:
                    listarCuentas(banco);
                    break;
                case 3:
                    obtenerDatosCuenta(banco);
                    break;
                case 4:
                    realizarIngreso(banco);
                    break;
                case 5:
                    retirarEfectivo(banco);
                    break;
                case 6:
                    consultarSaldo(banco);
                    break;
                case 7:
                    eliminarCuenta(banco);
                    break;
                case 8:
                    exportarListado(banco);
                    break;
                case 9:
                    guardarDatosFichero(banco);
                    System.out.println("Gracias por utilizar GestBanca.");
                    break;
                default:
                    System.out.println("Opción incorrecta. Introduce el número de la opción deseada: ");
            }
        } while (opcion != 9);
        scan.close(); // Se cierra el escáner
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
                + "\t 7. Eliminar una cuenta \n"
                + "\t 8. Listado clientes \n"
                + "\t 9. Guardar y salir \n");
        System.out.print("Por favor, introduce el número de la opción deseada: ");
        opcion = enteroPorTeclado();
        return opcion;
    }

    /**
     * Solicita todos los datos necesarios para crear una cuenta y almacenarla
     * en el banco
     *
     * @param banco el objeto banco al cual se añade la cuenta
     */
    public static void abrirCuenta(Banco banco) {
        Persona titular;
        CuentaBancaria cuenta = null;
        String nombre; // Nombre del titular
        String apellidos; // Apellidos del titular
        String dni; // DNI del titular
        double saldo; // Saldo inicial de la cuenta
        String iban; // Código IBAN de la cuenta
        double tipoInteresAnual; // Interés anual de remuneración
        double comisionMantenimiento; // Cantidad fija anual
        String listaEntidadesAutorizadas; // Entidades autorizadas para domiciliar recibos
        double tipoInteresDescubierto; // Interés que se cobra por estar en descubierto
        double maximoDescubiertoPermitido; // Cantidad máxima en descubierto
        double comisionPorDescubierto; //Cantidad fija que se cobra por cada descubierto que se tenga
        boolean cuentaCreada; // indica si ha sido o no exitoso
        int tipoCuenta; // selector del tipo de cuenta
        System.out.println("\nIntroduce los siguientes datos:\n");

        System.out.print("Nombre: ");
        nombre = scan.nextLine();

        System.out.print("Apellidos: ");
        apellidos = scan.nextLine();

        System.out.print("DNI: ");
        dni = abrirCuentaDNI();

        titular = new Persona(nombre, apellidos, dni); // Aquí almacenamos la información en un objeto de la clase persona, que posteriormente formará parte del objeto cuenta

        System.out.println("Tipos de cuenta: \n"
                + "\t 1. Cuenta de ahorro \n"
                + "\t 2. Cuenta corriente personal \n"
                + "\t 3. Cuenta corriente de empresa");
        do {
            System.out.print("Por favor, introduce el número de la opción deseada: ");
            tipoCuenta = enteroPorTeclado();
        } while (tipoCuenta < 1 || tipoCuenta > 3); // No permitimos una elección incorrecta

        System.out.print("Saldo inicial: ");
        saldo = -1; // Lo inicio a -1 para que entre en el bucle y solicite un saldo correcto
        while (!Validar.esMayorOIgualQueCero(saldo)) {
            saldo = doublePorTeclado();
            if (!Validar.esMayorOIgualQueCero(saldo)) {
                System.out.print("El número no puede ser negativo. Escribe un saldo correcto: ");
            }
        }

        System.out.print("Número de cuenta: ");
        iban = abrirCuentaIban();

        if (tipoCuenta == 1) { //Datos cuenta de ahorro
            System.out.print("Tipo de interés de remuneración: ");
            tipoInteresAnual = doublePorTeclado();
            cuenta = new CuentaAhorro(titular, saldo, iban, tipoInteresAnual);
        }
        if (tipoCuenta == 2) { //Cuenta corriente personal
            System.out.print("Tipo de interés: ");
            comisionMantenimiento = doublePorTeclado();

            //System.out.print("Entidades autorizadas: ");
            listaEntidadesAutorizadas = null; // Entidades autorizadas para domiciliar recibos. Se inicia a null en perspectiva de posibles aumentos en tareas posteriores

            cuenta = new CuentaCorrientePersonal(titular, saldo, iban, listaEntidadesAutorizadas, comisionMantenimiento);
        }
        if (tipoCuenta == 3) { //Cuenta corriente empresa
            //System.out.print("Entidades autorizadas: ");
            listaEntidadesAutorizadas = null; // Entidades autorizadas para domiciliar recibos. Se inicia a null en perspectiva de posibles aumentos en tareas posteriores

            System.out.print("Tipo de interés por descubierto: ");
            tipoInteresDescubierto = doublePorTeclado();

            System.out.print("Máximo descubierto permitido: ");
            maximoDescubiertoPermitido = doublePorTeclado();

            System.out.print("Comisión por cada descubierto: ");
            comisionPorDescubierto = doublePorTeclado();

            cuenta = new CuentaCorrienteEmpresa(titular, saldo, iban, listaEntidadesAutorizadas, tipoInteresDescubierto, maximoDescubiertoPermitido, comisionPorDescubierto);
        }
        // Una vez creada la cuenta, la almacenamos en el banco        
        cuentaCreada = banco.abrirCuenta(cuenta);

        if (cuentaCreada) {
            System.out.println("Cuenta creada exitosamente.");
        } else {
            System.out.println("Lo sentimos, no se ha podido crear la cuenta.");
        }
    }

    /**
     * Solicita y valida el DNI del titular
     *
     * @return el DNI del titular
     */
    public static String abrirCuentaDNI() {
        String dni = null;
        do {
            dni = scan.nextLine();
            if (!Validar.esDniCorrecto(dni)) {
                System.out.print("DNI incorrecto. Por favor, escribe un DNI correcto: ");
            }
        } while (!Validar.esDniCorrecto(dni));
        return dni;
    }

    /**
     * Solicita y valida el IBAN de la nueva cuenta
     *
     * @return el IBAN de la nueva cuenta
     */
    public static String abrirCuentaIban() {
        String iban = null;
        do {
            iban = scan.nextLine();
            if (!Validar.esIbanCorrecto(iban)) {
                System.out.print("IBAN incorrecto. Por favor, escribe un IBAN correcto: ");
            }
        } while (!Validar.esIbanCorrecto(iban));
        return iban;
    }

    /**
     * Obtiene y muestra por pantalla la información de todas las cuentas
     * almacenadas en el banco
     *
     * @param banco el objeto banco en el que se hace la consulta
     */
    public static void listarCuentas(Banco banco) {
        String[] listadoCuentas = banco.listadoCuentas();
        if (listadoCuentas.length == 0) {
            System.out.println("No hay cuentas guardadas");
        } else {
            for (String listadoCuenta : listadoCuentas) { // Equivalente a (int i = 0; i < listadoCuentas.length; i++)
                System.out.println(listadoCuenta);
            }
        }
    }

    /**
     * Solicita un IBAN y, sobre él, consulta la información almacenada de la
     * cuenta asociada
     *
     * @param banco el objeto banco en el que se hace la consulta
     */
    public static void obtenerDatosCuenta(Banco banco) {
        System.out.print("Escribe el IBAN: ");
        String iban = scan.nextLine();
        if (banco.informacionCuenta(iban) == null) {
            System.out.println("No hemos encontrado esa cuenta.");
        } else {
            System.out.println(banco.informacionCuenta(iban));
        }
    }

    /**
     * Solicita un IBAN y una cantidad. Si la cuenta existe, aumenta el saldo
     * disponible en ella
     *
     * @param banco el objeto banco en el que se hace la operación
     */
    public static void realizarIngreso(Banco banco) {
        System.out.print("Escribe el IBAN: ");
        String iban = scan.nextLine();
        System.out.print("Escribe la cantidad que deseas ingresar: ");
        double cantidad = 0; // Cantidad de dinero a ingresar iniciada a 0, valor no permitido
        while (!Validar.esMayorQueCero(cantidad)) {
            cantidad = doublePorTeclado();
            if (!Validar.esMayorQueCero(cantidad)) {
                System.out.print("El número debe ser mayor que cero. Escribe el número: ");
            }
        }
        if (banco.ingresoCuenta(iban, cantidad)) {
            System.out.println("Operación realizada correctamente");
        } else {
            System.out.println("No se ha podido llevar a cabo el ingreso.");
        }
    }

    /**
     * Solicita un IBAN y una cantidad. Si la cuenta existe, intenta retirar la
     * cantidad solicitada, siempre que haya saldo o el descubierto permitido
     * sea el suficiente
     *
     * @param banco el objeto banco en el que se hace la operación
     */
    public static void retirarEfectivo(Banco banco) {
        System.out.print("Escribe el IBAN: ");
        String iban = scan.nextLine();
        System.out.print("Escribe la cantidad que deseas retirar: ");
        double cantidad = 0; // Cantidad de dinero a retirar iniciada a 0, valor no permitido
        while (!Validar.esMayorQueCero(cantidad)) {
            cantidad = doublePorTeclado();
            if (!Validar.esMayorQueCero(cantidad)) {
                System.out.print("El número debe ser mayor que cero. Escribe el número: ");
            }
        }
        if (banco.retiradaCuenta(iban, cantidad)) {
            System.out.println("Operación realizada correctamente");
        } else {
            System.out.println("No se ha podido llevar a cabo la retirada.");
        }
    }

    /**
     * Solicita un IBAN y, si la cuenta existe, muestra el saldo disponible en
     * la misma
     *
     * @param banco el objeto banco en el que se hace la operación
     */
    public static void consultarSaldo(Banco banco) {
        System.out.print("Escribe tu IBAN: ");
        String iban = scan.nextLine();
        if (banco.obtenerSaldo(iban) == -1) {
            System.out.println("No hemos encontrado esa cuenta.");
        } else {
            System.out.println("Saldo " + banco.obtenerSaldo(iban) + " €.");
        }
    }

    /**
     * Solicita un IBAN y, si la cuenta existe y tiene saldo 0, la elimina.
     *
     * @param banco el objeto banco en el que se hace la operación
     */
    public static void eliminarCuenta(Banco banco) {
        System.out.print("Escribe el IBAN: ");
        String iban = scan.nextLine();
        if (!banco.eliminarCuenta(iban)) {
            System.out.println("No hemos podido eliminar esa cuenta.");
        } else {
            System.out.println("Cuenta eliminada.");
        }
    }

    /**
     * Genera el archivo ListadoClientesCCC.txt con el propietario y el IBAN de
     * cada cuenta almacenada, así como el número total de cuentas.
     *
     * @param banco el objeto banco en el que se hace la operación
     */
    public static void exportarListado(Banco banco) {
        try {
            FileWriter archivo = new FileWriter("ListadoClientesCCC.txt");
            PrintWriter pw = new PrintWriter(archivo);
            for (CuentaBancaria cuenta : banco.cuentas) {
                pw.println(cuenta.iban + ": " + cuenta.titular.getNombre() + " " + cuenta.titular.getApellidos());
            }
            pw.println("Total: " + banco.cuentas.size());
            pw.close();
            archivo.close();
            System.out.println("Archivo exportado correctamente");
        } catch (IOException e) {
            System.out.println("No se ha podido exportar el archivo");
        }
    }

    /**
     * Crea o sobreescribe el fichero datoscuentasbancarias.dat con la
     * información contenida en el banco.
     *
     * @param banco el objeto banco en el que se hace la operación
     */
    public static void guardarDatosFichero(Banco banco) {
        try {
            FileOutputStream file = new FileOutputStream("datoscuentasbancarias.dat");
            ObjectOutputStream oos = new ObjectOutputStream(file);
            oos.writeInt(banco.cuentas.size());
            for (CuentaBancaria cuenta : banco.cuentas) {
                oos.writeObject(cuenta);
            }
            oos.close();
            file.close();
        } catch (IOException e) {
            System.out.println("Error al guardar el fichero");
        }
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

    /**
     * Si existe, carga el fichero datoscuentasbancarias.dat y vuelca su
     * contenido al banco.
     * 
     * @param banco el objeto banco en el que se hace la operación
     */
    public static void cargarFichero(Banco banco) {
        try {
            FileInputStream file = new FileInputStream("datoscuentasbancarias.dat");
            ObjectInputStream ois = new ObjectInputStream(file);
            int numCuentas = ois.readInt();
            for (int i = 0; i < numCuentas; i++) {
                CuentaBancaria cuenta = (CuentaBancaria) ois.readObject();
                banco.abrirCuenta(cuenta);
            }
            ois.close();
            file.close();
        } catch (FileNotFoundException e) {
        } catch (Exception e) {
            System.out.println("Error al leer el fichero");
        }
    }

}
