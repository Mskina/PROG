/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog07;

/**
 * Representa la creación de una cuenta de ahorro
 *
 *
 * @author Iván Estévez Sabucedo
 */
public class CuentaAhorro extends CuentaBancaria {

    private double tipoInteresAnual; // Interés anual de remuneración

    public CuentaAhorro(Persona titular, double saldo, String iban, double tipoInteresAnual) {
        super(titular, saldo, iban);
        this.tipoInteresAnual = tipoInteresAnual;
    }

    /**
     * Devuelve la información de la cuenta
     *
     * @return String nombre, apellidos, DNI, saldo, tipo de cuenta e interés
     * anual de la misma
     */
    @Override
    public String devolverInfoString() {
        String contenido = super.devolverInfoString();
        contenido = contenido
                + "- Tipo de cuenta: Cuenta de ahorro\n"
                + "- Interés anual: " + String.format("%.2f", tipoInteresAnual) + " % \n";
        return contenido;
    }
}
