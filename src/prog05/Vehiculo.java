/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog05;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author mskin
 */
public class Vehiculo {

    private String marca;
    private String matricula; // https://es.stackoverflow.com/questions/48115/como-poner-una-matricula-en-java-segura/48120
    private int kilometros;
    private LocalDate fechaMatriculacion;
    //private  fecha de matriculación? https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/time/LocalDate.html
    private String descripcion;
    private int precio;
    private String nombrePropietario;
    private String nifPropietario;
    private int anios;

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

    public Vehiculo() {
    }

    /**
     * Método que guarda la marca del vehículo
     *
     * @param marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
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
     * Método que guarda la matrícula del vehículo
     *
     * @param matricula
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
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
     * Método que guarda los kilómetros del vehículo
     *
     * @param kilometros
     */
    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
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
     * Método que guarda la fecha de matriculacion del vehículo
     *
     * @param fechaMatriculacion
     */
    public void setFechaMatriculacion(LocalDate fechaMatriculacion) {
        this.fechaMatriculacion = fechaMatriculacion;
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
     * Método que guarda la descripcion del vehículo
     *
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
     * Método que guarda el precio del vehículo
     *
     * @param precio
     */
    public void setPrecio(int precio) {
        this.precio = precio;
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
     * Método que guarda el nombre del propietario del vehículo
     *
     * @param nombrePropietario
     */
    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
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
     * Método que guarda el NIF del propietario del vehículo una vez validado
     *
     * @param nifPropietario
     * @throws java.lang.Exception
     */
    public void setNifPropietario(String nifPropietario) {
        this.nifPropietario = nifPropietario;
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
        //int anioActual = LocalDate.now().getYear();
        //int anioMatriculacion = fechaMatriculacion.getYear();
        //int anioDiferencia = anioActual - anioMatriculacion;
        //return anioDiferencia;
        LocalDate fechaHoy = LocalDate.now();
        LocalDate fechaMatricula = getFechaMatriculacion();
        long diasEntreFechas = ChronoUnit.DAYS.between(fechaHoy, fechaMatricula);
        int aniosEntreFechas = (int) (diasEntreFechas / 365);
        return aniosEntreFechas;
    }

}
