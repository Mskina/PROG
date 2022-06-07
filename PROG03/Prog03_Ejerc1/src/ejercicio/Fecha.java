/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio;

/**
 *
 * @author mskin
 */
public class Fecha {
    enum EnumMes
    {
        enero,febrero,marzo,abril,mayo,junio,julio,agosto,septiembre,octubre,noviembre,diciembre;
    }
    int dia;
    EnumMes mes;
    int anio;
    
    public Fecha(EnumMes mes) {
        this.mes = mes;
    }
    
    public Fecha(int dia, EnumMes mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }
    
    public int getDia() {
        return dia;
    }
    
    public void setDia(int dia) {
        this.dia = dia;
    }
    
    public EnumMes getMes() {
        return mes;
    }
    
    public void setMes(EnumMes mes) {
        this.mes = mes;
    }
    
    public int getAnio() {
        return anio;
    }
    
    public void setAnio(int anio) {
        this.anio = anio;
    }
    
    public boolean isSummer() {
        boolean verano1 = (mes == EnumMes.julio)?true:false;
        boolean verano2 = (mes == EnumMes.agosto)?true:false;
        boolean isSummer = (verano1 || verano2) == true;
        return isSummer;
    }
               
    
    /* Prueba que hice buscando información extra
    public boolean isSummer2() {
        if (mes==EnumMes.julio || mes==EnumMes.agosto) {
            return true;
        }
        if (mes==EnumMes.junio && dia>=21) {
            return true;
        }
        if (mes==EnumMes.septiembre && dia <=21) {
            return true;
        }
        
        return false;
        
    }
    */
    
    public String toString () {
        String str = this.dia+" de "+this.mes+" del "+this.anio;
        return str;
    }
}
    





