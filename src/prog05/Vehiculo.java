/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog05;

import java.time.LocalDate;
import java.time.Year;
import static prog05.Principal.pedirFechaMatriculacion;
import prog05.util.Validar;

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
    
    public Vehiculo (String marca, String matricula, int kilometros, LocalDate fecha, String descripcion, int precio, String nombrePropietario, String nifPropietario) {
        this.marca = marca;
        this.matricula = matricula;
        this.kilometros = kilometros;
        this.fechaMatriculacion = fecha;
        this.descripcion = descripcion;
        this.precio = precio;
        this.nombrePropietario = nombrePropietario;
        this.nifPropietario = nifPropietario;
    }
    
    public Vehiculo () {   
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getMarca() {
        return marca;
    }
    
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getMatricula() {
        return matricula;
    }
    
    public void setKilometros(int kilometros) {
        if (kilometros <= 0) {
            throw new IllegalArgumentException();
        } else {
           this.kilometros = kilometros; 
        }      
    }
    public int getKilometros() {
        return kilometros;
    }
    
    public void setFechaMatriculacion(LocalDate fechaMatriculacion) {
        this.fechaMatriculacion = fechaMatriculacion;
    }
    public LocalDate getFechaMatriculacion() {
        return fechaMatriculacion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setPrecio(int precio) {
        if (precio <= 0) {
            throw new IllegalArgumentException();
        } else {
            this.precio = precio;
        }   
    }
    public int getPrecio() {
        return precio;
    }
    
    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }
    public String getNombrePropietario() {
        return nombrePropietario;
    }
    
    public void setNifPropietario(String nifPropietario) throws Exception {
        if (Validar.validarNIF(nifPropietario)) {
            this.nifPropietario = nifPropietario;
        } else {
            throw new Exception();
        }
    }
    public String getNifPropietario() {
        return nifPropietario;
    }
    
    public int getAnios() {
        int anioActual = LocalDate.now().getYear();
        int anioMatriculacion = fechaMatriculacion.getYear();
        int anioDiferencia = anioActual - anioMatriculacion;
        return anioDiferencia;
    }
    
    
}
