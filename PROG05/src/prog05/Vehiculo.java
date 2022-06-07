package prog05;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Representa la creación de un objeto Vehículo. Permite consultar y actualizar
 * sus parámetros, que deberán venir validados previamente.
 *
 * @author Iván Estévez Sabucedo
 */
public class Vehiculo {

    private String marca;
    private String matricula;
    private int kilometros;
    private LocalDate fechaMatriculacion;
    private String descripcion;
    private int precio;
    private String nombrePropietario;
    private String nifPropietario;

    /**
     * Método constructor del vehículo, donde se solicitan todos los parámetros
     * obligatorios
     *
     * @param marca marca del vehículo
     * @param matricula matrícula del vehículo
     * @param kilometros número de kilómetros del vehículo
     * @param fechaMatriculacion fecha de matriculación del vehículo
     * @param descripcion escripción del vehículo
     * @param precio precio del vehículo
     * @param nombrePropietario nombre del propietario del vehículo
     * @param nifPropietario NIF del propietario del vehículo
     *
     */
    public Vehiculo(String marca, String matricula, int kilometros, LocalDate fechaMatriculacion, String descripcion, int precio, String nombrePropietario, String nifPropietario) {
        this.marca = marca.trim(); // Con .trim evitamos almacenar espacios en blanco
        this.matricula = matricula.trim();
        this.kilometros = kilometros;
        this.fechaMatriculacion = fechaMatriculacion;
        this.descripcion = descripcion.trim();
        this.precio = precio;
        this.nombrePropietario = nombrePropietario.trim();
        this.nifPropietario = nifPropietario;
    }

    /**
     * Devuelve la marca del vehículo
     *
     * @return Marca del vehículo
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Devuelve la matrícula del vehículo
     *
     * @return Matrícula del vehículo
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Permite actualizar el número de kilómetros del vehículo
     *
     * @param kilometrosParaSumar número de kilómetros que queremos añadir a la cifra
     * actual
     */
    public void addKilometros(int kilometrosParaSumar) {
        this.kilometros += kilometrosParaSumar;
    }

    /**
     * Devuelve los kilómetros del vehículo
     *
     * @return Kilómetros del vehículo
     */
    public int getKilometros() {
        return kilometros;
    }

    /**
     * Devuelve la fecha de matriculación del vehículo
     *
     * @return Fecha de matriculación del vehículo
     */
    public LocalDate getFechaMatriculacion() {
        return fechaMatriculacion;
    }

    /**
     * Devuelve la descripción del vehículo
     *
     * @return Descripción del vehículo
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Devuelve el precio del vehículo
     *
     * @return Precio del vehículo
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * Devuelve el nombre del propietario del vehículo
     *
     * @return Nombre del propietario del vehículo
     */
    public String getNombrePropietario() {
        return nombrePropietario;
    }

    /**
     * Devuelve el NIF del propietario del vehículo
     *
     * @return NIF del propietario del vehículo
     */
    public String getNifPropietario() {
        return nifPropietario;
    }

    /**
     * Calcula los años entre la fecha de matriculación y la actual
     *
     * @return número de años
     */
    public long getAnios() {
        LocalDate fechaHoy = LocalDate.now();
        LocalDate fechaMatricula = getFechaMatriculacion();
        long aniosEntreFechas = ChronoUnit.YEARS.between(fechaHoy, fechaMatricula);
        return aniosEntreFechas;
    }
}
