package prog05;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * En esta clase se incluyen todos los métodos necesarios para crear un objeto
 * Vehículo. Todos los datos que se guardan aquí vienen validados.
 *
 * @author Iván Estévez Sabucedo
 */
public class Vehiculo {

    private String marca; // Marca del vehículo
    private String matricula; // Matrícula del vehículo
    private int kilometros; // Kilómetros del vehículo
    private LocalDate fechaMatriculacion; // Fecha de matriculación del vehículo
    private String descripcion; // Descripción del vehículo
    private int precio; // Precio del vehículo
    private String nombrePropietario; // Nombre del propietario del vehículo
    private String nifPropietario; // NIF del propietario del vehículo

    /**
     * Método constructor del vehículo, donde se solicitan todos los parámetros
     * obligatorios
     *
     * @param marca
     * @param matricula
     * @param kilometros
     * @param fechaMatriculacion
     * @param descripcion
     * @param precio
     * @param nombrePropietario
     * @param nifPropietario
     *
     */
    public Vehiculo(String marca, String matricula, int kilometros, LocalDate fechaMatriculacion, String descripcion, int precio, String nombrePropietario, String nifPropietario) {
        this.marca = marca;
        this.matricula = matricula;
        this.kilometros = kilometros;
        this.fechaMatriculacion = fechaMatriculacion;
        this.descripcion = descripcion;
        this.precio = precio;
        this.nombrePropietario = nombrePropietario;
        this.nifPropietario = nifPropietario;
    }

    /**
     * Método que devuelve la marca del vehículo
     *
     * @return marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Método que devuelve la matrícula del vehículo
     *
     * @return matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Método que guarda los nuevos kilómetros del vehículo
     *
     * @param kilometros
     */
    public void addKilometros(int kilometrosParaSumar) {
        this.kilometros += kilometrosParaSumar;
    }

    /**
     * Método que devuelve los kilómetros del vehículo
     *
     * @return kilometros
     */
    public int getKilometros() {
        return kilometros;
    }

    /**
     * Método que devuelve la fecha de matriculación del vehículo
     *
     * @return fechaMatriculacion
     */
    public LocalDate getFechaMatriculacion() {
        return fechaMatriculacion;
    }

    /**
     * Método que devuelve la descripción del vehículo
     *
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Método que devuelve el precio del vehículo
     *
     * @return precio
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * Método que devuelve el nombre del propietario del vehículo
     *
     * @return nombrePropietario
     */
    public String getNombrePropietario() {
        return nombrePropietario;
    }

    /**
     * Método que devuelve el NIF del propietario del vehículo
     *
     * @return nifPropietario
     */
    public String getNifPropietario() {
        return nifPropietario;
    }

    /**
     * Método que devuelve el número de años (entero) entre la fecha de
     * matriculación y la fecha actual
     *
     * @return anioEntreFechas
     */
    public int getAnios() {
        LocalDate fechaHoy = LocalDate.now();
        LocalDate fechaMatricula = getFechaMatriculacion();
        long diasEntreFechas = ChronoUnit.DAYS.between(fechaHoy, fechaMatricula);
        int aniosEntreFechas = (int) (diasEntreFechas / 365);
        return aniosEntreFechas;
    }
}
