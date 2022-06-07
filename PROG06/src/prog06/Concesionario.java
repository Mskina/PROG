package prog06;

import java.time.LocalDate;

/**
 * Representa la creación de un objeto Concesionario. Permite consultar y
 * actualizar sus parámetros, que deberán venir validados previamente.
 *
 * @author Iván Estévez Sabucedo
 */
public class Concesionario {

    private Vehiculo[] listaVehiculos;
    private int numeroVehiculos;

    /**
     * Método constructor del concesionario, en el que se crea el array con un
     * tamaño fijo de 50 vehículos
     */
    public Concesionario() {
        listaVehiculos = new Vehiculo[50];
        numeroVehiculos = 0;
    }

    /**
     * Recibe como parámetro una matrícula, busca el vehículo en el
     * concesionario y devuelve una cadena con los datos del vehículo
     *
     * @param matricula matrícula del vehículo a buscar
     * @return cadena con los datos del vehículo o <code>null</code> si el
     * vehículo buscado no existe
     */
    public String buscarVehiculo(String matricula) {
        String datosVehiculo = null;
        int i = 0;
        while (i < numeroVehiculos && datosVehiculo == null) {
            if (listaVehiculos[i].getMatricula().equals(matricula)) {
                datosVehiculo = listaVehiculos[i].getDatosResumido();
            }
            i++;
        }
        return datosVehiculo;
    }

    /**
     * Recibe todos los datos de un vehículo y trata de insertarlo en el
     * concesionario.
     *
     * @param marca marca del vehículo
     * @param matricula matrícula del vehículo
     * @param kilometros número de kilómetros del vehículo
     * @param fechaMatriculacion fecha de matriculación del vehículo
     * @param descripcion escripción del vehículo
     * @param precio precio del vehículo
     * @param nombrePropietario nombre del propietario del vehículo
     * @param dniPropietario DNI del propietario del vehículo
     * @return <code>0</code> si se hizo con éxito, <code>-1</code> si el
     * concesionario esta vacío y <code>-2</code> si la matrícula ya existe.
     */
    public int insertarVehiculo(String marca, String matricula, int kilometros, LocalDate fechaMatriculacion, String descripcion, double precio, String nombrePropietario, String dniPropietario) {
        int insertarVehiculo = 1;
        int i = 0;
        if (numeroVehiculos == 50) {
            insertarVehiculo = -1; // El concesionario está lleno
        } else {
            while (i < numeroVehiculos && insertarVehiculo != -2) {
                if (listaVehiculos[i].getMatricula().equals(matricula)) {
                    insertarVehiculo = -2; // Ya existe esa matrícula
                }
                i++;
            }
            if (insertarVehiculo != -2) {
                listaVehiculos[numeroVehiculos] = new Vehiculo(marca, matricula, kilometros, fechaMatriculacion, descripcion, precio, nombrePropietario, dniPropietario);
                numeroVehiculos++;
                insertarVehiculo = 0; // Éxito
            }
        }
        return insertarVehiculo;
    }

    /**
     * Lista por pantalla los datos de todos los vehículos del concesionario
     *
     * @return <code>true</code> si se listaron los vehículos y
     * <code>false</code> en caso contrario
     */
    public boolean listarVehiculos() {
        for (int i = 0; i < numeroVehiculos; i++) {
            System.out.println(listaVehiculos[i].getDatosExtendido());
        }
        return (numeroVehiculos > 0); // Si hay coches, se listan.
    }

    /**
     * Recibe por parámetro una matrícula y un número de kilómetros, busca el
     * vehículo con cuya matrícula coincida y actualiza sus kilómetros.
     *
     * @param matricula matrícula del vehículo a actualizar
     * @param kilometrosParaSumar número de kilómetros a sumar
     * @return <code>true</code> si se actualizó con éxito y <code>false</code>
     * en caso contrario.
     */
    public boolean actualizarKms(String matricula, int kilometrosParaSumar) {
        boolean actualizadorKms = false;
        int i = 0;
        while (i < numeroVehiculos && !actualizadorKms) {
            if (listaVehiculos[i].getMatricula().equals(matricula)) {
                listaVehiculos[i].addKilometros(kilometrosParaSumar);
                actualizadorKms = true;
            }
            i++;
        }
        return actualizadorKms;
    }

    /**
     * Recibe por parámetro una matrícula, busca el vehículo cuya matrícula
     * coincida y lo elimina del concesionario
     *
     * @param matricula matrícula del vehículo a eliminar
     * @return <code>true</code> si se eliminó con éxito y <code>false</code> en
     * caso contrario.
     */
    public boolean eliminarVehiculo(String matricula) {
        boolean eliminarVehiculo = false;
        int i = 0;
        while (i < numeroVehiculos && !eliminarVehiculo) {
            if (listaVehiculos[i].getMatricula().equals(matricula)) {
                listaVehiculos[i] = null; // Se elimina la referencia. No de memoria (Chrome está todavía triste)
                eliminarVehiculo = true;
                numeroVehiculos--;
            } else { // para que no cuente en la vez que se elimine
                i++;
            }
        }
        if (eliminarVehiculo) {
            for (int j = i; j < numeroVehiculos; j++) { // imaginamos que arriba es el 3
                // j = 3, viene abajo y en el 3 copia lo que hay en el 4
                listaVehiculos[j] = listaVehiculos[j + 1];
                // si en el array hay 5, en el 3 copia el 4, en el 4 copia el 5...
            }
        }
        return eliminarVehiculo;
    }
}
