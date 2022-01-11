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
import java.time.Month;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Bienvenido a AutoGest, tu sistema de gestión del automóvil.");
        Vehiculo coche = new Vehiculo();
        Scanner scan = new Scanner(System.in);
        while (true) {
            int opcion = lanzarMenu(); // Menú de selección de opción
            switch (opcion) { // Características de cada opción
                case 1:
                    coche = new Vehiculo();
                    System.out.println("");
                    System.out.println("Introduce los siguientes datos:");
                    System.out.println("");

                    System.out.print("Marca: ");
                    String marca = scan.nextLine();
                    coche.setMarca(marca);

                    System.out.print("Matrícula: ");
                    String matricula = scan.nextLine();
                    coche.setMatricula(matricula);
                    
                    System.out.print("Kilómetros: ");
                    int kilometros = scan.nextInt();
                    scan.nextLine();
                    try {
                        coche.setKilometros(kilometros);
                    } catch (Exception ex) {
                        System.out.println("El kilometraje debe ser positivo y has escrito: " + kilometros);
                        break;
                    }
                    
                    System.out.println("Fecha de matriculación: ");
                    LocalDate fechaMatriculacion = pedirFechaMatriculacion();
                    coche.setFechaMatriculacion(fechaMatriculacion);
                    
                    System.out.print("Descripción del vehículo: ");
                    String descripcion = scan.nextLine();
                    coche.setDescripcion(descripcion);

                    System.out.print("Precio: ");
                    int precio = scan.nextInt();
                    scan.nextLine();
                    try {
                        coche.setPrecio(precio);
                    } catch (Exception ex) {
                        System.out.println("El precio debe ser positivo y has escrito: " + precio);
                        break;
                    }
                    
                    System.out.print("Nombre del propietario: ");
                    String nombrePropietario = scan.nextLine();
                    coche.setNombrePropietario(nombrePropietario);
                    
                    System.out.print("NIF del propietario: ");
                    String nifPropietario = scan.nextLine();
                     {
                        try {
                            coche.setNifPropietario(nifPropietario);
                        } catch (Exception ex) {
                            System.out.println("NIF incorrecto.");
                            break;
                        }
                    }
                    break;

                case 2:
                    System.out.println("Matrícula del vehículo: " + coche.getMatricula());
                    break;

                case 3:
                    System.out.println("El vehículo tiene " + coche.getKilometros() + " kilómetros.");
                    break;

                case 4:
                    System.out.println("");
                    break;

                case 5:
                    System.out.println("Desde que se matriculó han pasado " + coche.getAnios() + " años.");
                    break;

                case 6:
                    System.out.println("El propietario es " + coche.getNombrePropietario() + ", con NIF " + coche.getNifPropietario() + ".");
                    break;

                case 7:
                    System.out.println("El vehículo " + coche.getMarca() + " con la matrícula " + coche.getMatricula() + " tiene " + coche.getKilometros() + " kilómetros.");
                    break;

                case 8:
                    System.out.println("Precio del vehículo: " + coche.getPrecio() + " euros.");
                    break;

                case 9:
                    System.out.println("Gracias por utilizar AutoGest.");
                    System.exit(0); // Finalizamos el programa.
            }
        }
    }

    public static int lanzarMenu() {
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
     *
     * @param year
     * @param month
     * @param dayOfMonth
     * @return
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
}
