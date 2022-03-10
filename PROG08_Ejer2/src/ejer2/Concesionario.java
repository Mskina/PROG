package ejer2;

import java.time.LocalDate;
import java.util.*;

/**
 * Representa la creación de un objeto Concesionario. Permite consultar y
 * actualizar sus parámetros, que deberán venir validados previamente.
 *
 * @author Iván Estévez Sabucedo
 */
public class Concesionario {

    /* Opto por emplear un TreeSet ya que ordena los elementos nativamente.
    En mi caso, modifico el método compareTo() para que realice las comparaciones
    en función de la matrícula de los vehículos.  
     */
    private TreeSet<Vehiculo> listaVehiculos; // Árbol de objetos

    /**
     * Método constructor del concesionario, en el que se crea un TreeSet.
     */
    public Concesionario() {
        listaVehiculos = new TreeSet<Vehiculo>(); // Creación del TreeSet
    }

    /**
     * Recibe como parámetro una matrícula, busca el vehículo en el
     * concesionario y devuelve una cadena con los datos del vehículo.
     *
     * @param matricula matrícula del vehículo a buscar
     * @return cadena con los datos del vehículo o <code>null</code> si el
     * vehículo buscado no existe
     */
    public String buscarVehiculo(String matricula) {
        String datosVehiculo = null;
        Vehiculo vehiculoBuscar = new Vehiculo(matricula); // Vehículo temporal para hacer las comparaciones
        Vehiculo vehiculoEncontrado = listaVehiculos.floor(vehiculoBuscar); // Vehículo para hacer la búsqueda binaria
        if (vehiculoEncontrado.compareTo(vehiculoBuscar) == 0) {
            datosVehiculo = vehiculoEncontrado.getDatosResumido();
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
        if (listaVehiculos.size() == 50) {
            insertarVehiculo = -1; // El concesionario está lleno (entendemos que físicamente)
        } else {
            Vehiculo v = new Vehiculo(marca, matricula, kilometros, fechaMatriculacion, descripcion, precio, nombrePropietario, dniPropietario);
            if (listaVehiculos.add(v)) {
                insertarVehiculo = 0;
            } else {
                insertarVehiculo = -2;
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
        for (Vehiculo veh : listaVehiculos) {
            System.out.println(veh.getDatosExtendido());
        }
        return (listaVehiculos.size() > 0); // Si hay coches, se listan.
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
        Vehiculo vehiculoBuscar = new Vehiculo(matricula); // Vehículo temporal para hacer las comparaciones
        Vehiculo vehiculoEncontrado = listaVehiculos.floor(vehiculoBuscar); // Vehículo sobre el que se realiza la búsqueda binaria
        if (vehiculoEncontrado.compareTo(vehiculoBuscar) == 0) {
            vehiculoEncontrado.addKilometros(kilometrosParaSumar);
            actualizadorKms = true;
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
        Vehiculo v = new Vehiculo(matricula); // Vehículo temporal para intentar realizar la eliminación
        return listaVehiculos.remove(v);
    }
}
