/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo;

import java.io.Serializable;

/**
 *
 * @author Iván Estévez
 */
public class Archivo implements Serializable, Comparable<Archivo>{
    private String nombre;
    private int tamanho;
    private int prioridad;
    private String BnColor;
    private String tipo;
    private int paginas;
    
    public Archivo(String nombre, int tamanho, int prioridad, String BnColor, String tipo, int paginas) {
        this.nombre = nombre;
        this.tamanho = tamanho;
        this.prioridad = prioridad;
        this.BnColor = BnColor;
        this.tipo = tipo;
        this.paginas = paginas;    
    }

    @Override
    public int compareTo(Archivo a) {
        return Integer.compare(this.getPrioridad(), a.getPrioridad());
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the tamanho
     */
    public int getTamanho() {
        return tamanho;
    }

    /**
     * @param tamanho the tamanho to set
     */
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    /**
     * @return the prioridad
     */
    public int getPrioridad() {
        return prioridad;
    }

    /**
     * @param prioridad the prioridad to set
     */
    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    /**
     * @return the BnColor
     */
    public String getBnColor() {
        return BnColor;
    }

    /**
     * @param BnColor the BnColor to set
     */
    public void setBnColor(String BnColor) {
        this.BnColor = BnColor;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the paginas
     */
    public int getPaginas() {
        return paginas;
    }

    /**
     * @param paginas the paginas to set
     */
    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }
    
}
