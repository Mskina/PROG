/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog07;

/**
 * Representa la creación de una cuenta corriente
 *
 * @author Iván Estévez Sabucedo
 */
public abstract class CuentaCorriente extends CuentaBancaria {

    protected String listaEntidadesAutorizadas; // Entidades autorizadas para domiciliar recibos   

    public CuentaCorriente(Persona titular, double saldo, String iban, String listaEntidadesAutorizadas) {
        super(titular, saldo, iban);
        this.listaEntidadesAutorizadas = listaEntidadesAutorizadas;
    }

    /**
     * Devuelve la información de la cuenta
     *
     * @return String nombre, apellidos, DNI, saldo, tipo de cuenta, interés
     * anual y entidades autorizadas para hacer domiciliaciones
     */
    @Override
    public String devolverInfoString() {
        String contenido = super.devolverInfoString();
        contenido = contenido
                + "- Entidades autorizadas: " + listaEntidadesAutorizadas + " \n";
        return contenido;
    }
}
