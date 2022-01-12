/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog05;

import prog05.util.Validar;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.DateTimeException;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Vehiculo coche = null;

        String marca;
        String matricula;
        int kilometros;
        LocalDate fechaMatriculacion;
        String descripcion;
        int precio;
        String nombrePropietario;
        String nifPropietario;

        boolean salir = false;

        Scanner scan = new Scanner(System.in);

        System.out.println("Bienvenido a AutoGest, tu sistema de gestión del automóvil.");

        do {
            try {
                int opcion = lanzarMenu(); // Menú de selección de opción
                switch (opcion) { // Características de cada opción
                    case 1:
                        coche = new Vehiculo();
                        System.out.println("");
                        System.out.println("Introduce los siguientes datos:");
                        System.out.println("");

                        System.out.print("Marca: ");
                        marca = scan.nextLine();
                        coche.setMarca(marca);

                        System.out.print("Matrícula: ");
                        matricula = scan.nextLine();
                        coche.setMatricula(matricula);

                        System.out.print("Kilómetros: ");
                        do {
                            kilometros = Validar.obtenerEnteroPorTeclado();
                        } while (Validar.esMayorQueCero(kilometros) == false);
                        coche.setKilometros(kilometros);

                        System.out.println("Fecha de matriculación: ");
                        do { // Primer bucle. Encierra que la fecha no sea igual a la actual
                            do { // Segundo bucle. Encierra que la fecha sea correcta.
                                try {
                                    fechaMatriculacion = pedirFechaMatriculacion();
                                } catch (DateTimeException e) {
                                    System.out.println("La fecha que has introducido no es correcta. Por favor, escribe una fecha válida: ");
                                    fechaMatriculacion = null;
                                }
                            } while (fechaMatriculacion == null);
                            if (fechaMatriculacion.equals(LocalDate.now())) {
                                System.out.println("La fecha de matriculación no puede ser la de hoy. Escribe una fecha anterior.");
                            }
                        } while (fechaMatriculacion.equals(LocalDate.now()));
                        coche.setFechaMatriculacion(fechaMatriculacion);

                        System.out.print("Descripción del vehículo: ");
                        descripcion = scan.nextLine();
                        coche.setDescripcion(descripcion);

                        System.out.print("Precio: ");
                        do {
                            precio = Validar.obtenerEnteroPorTeclado();
                        } while (Validar.esMayorQueCero(precio) == false);
                        coche.setPrecio(precio);

                        System.out.print("Nombre del propietario: ");
                        nombrePropietario = scan.nextLine();
                        coche.setNombrePropietario(nombrePropietario);

                        System.out.print("NIF del propietario: ");
                        do {
                            nifPropietario = scan.nextLine();
                            try {
                                Validar.validarNIF(nifPropietario);
                            } catch (NumberFormatException nfe) {
                                nifPropietario = null;
                            }
                            System.out.print("NIF incorrecto. Por favor, escribe un NIF correcto: ");
                        } while (Validar.validarNIF(nifPropietario) == false);
                        coche.setNifPropietario(nifPropietario);
                        
                        coche = new Vehiculo(coche.getMarca(), coche.getMatricula(), coche.getKilometros(), coche.getFechaMatriculacion(), coche.getDescripcion(), coche.getPrecio(), coche.getNombrePropietario(), coche.getNifPropietario());
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
     * Método que muestra el menú principal validando la opción elegida
     *
     * @return opcion
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
     * Método para solicitar la fecha de matriculación.
     * 
     * @return LocalDate.of
     * @throws DateTimeException
     */
    public static LocalDate pedirFechaMatriculacion() throws DateTimeException {
        Scanner scan = new Scanner(System.in);
        System.out.print("  Día: ");
        int dayOfMonth = scan.nextInt();
        scan.nextLine();
        System.out.print("  Mes: ");
        int month = scan.nextInt();
        scan.nextLine();
        System.out.print("  Año: ");
        int year = scan.nextInt();
        scan.nextLine();
        return LocalDate.of(year, month, dayOfMonth);
    }

    /**
     * Método que permite actualizar el kilometráje del vehículo instanciado. No
     * permite introducir el valor cero.
     *
     * @param coche
     */
    public static void actualizarKilometros(Vehiculo coche) {
        int kilometrosParaSumar;
        System.out.print("Número de kilómetros a incrementar: ");
        do {
            kilometrosParaSumar = Validar.obtenerEnteroPorTeclado();
        } while (Validar.esMayorQueCero(kilometrosParaSumar) == false);
        int kilometrosActuales = coche.getKilometros();
        int kilometrosNuevos = kilometrosActuales + kilometrosParaSumar;
        coche.setKilometros(kilometrosNuevos);
    }
}
