package concesionario.clases;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author
 */
public class Vehiculo {

    private String marca;
    private String matricula;
    private Integer numKms;
    private LocalDate fechaMatricula;
    private String descripcion;
    private Double precio;
    private String propietario;
    private String dniPropietario;

    public Vehiculo(String marca, String matricula, Integer numKms, LocalDate fechaMatricula,
            String descripcion, Double precio, String propietario, String dniPropietario) {
        this.marca = marca;
        this.matricula = matricula;
        this.numKms = numKms;
        this.fechaMatricula = fechaMatricula;
        this.descripcion = descripcion;
        this.precio = precio;
        this.propietario = propietario;
        this.dniPropietario = dniPropietario;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getNumKms() {
        return numKms;
    }

    public void setNumKms(Integer numKms) {
        this.numKms = numKms;
    }

    public LocalDate getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(LocalDate fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getDniPropietario() {
        return dniPropietario;
    }

    public void setDniPropietario(String dniPropietario) {
        this.dniPropietario = dniPropietario;
    }

    public int getAnios() {      
        return Period.between(this.fechaMatricula, LocalDate.now()).getYears();
    }

    public void actualizarKms(int nuevosKms) {
        this.numKms += nuevosKms;
    }

    @Override
    public String toString() {
        return "Vehiculo:" + "\nmarca=" + marca + "\nmatricula=" + matricula + "\nnumKms=" + numKms + "\nfechaMatricula=" + fechaMatricula + "\ndescripcion=" + descripcion + "\nprecio=" + precio + "\npropietario=" + propietario + "\ndniPropietario=" + dniPropietario;
    }

    
}
